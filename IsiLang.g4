grammar IsiLang;

@header {
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Stack;
    import java.lang.String;
    import io.github.lilconrado.isilang.symbols.*;
    import io.github.lilconrado.isilang.exceptions.SemanticException;
    import io.github.lilconrado.isilang.ast.*;
    import io.github.lilconrado.isilang.expressions.*;
}

@members {
    private Type _type;
    private String _varName;
    private String _varValue;
    private SymbolTable _symbolTable = new SymbolTable();
    private Identifier _identifier;
    private Program  program = new Program();
    private Stack<List<AbstractCommand>> _stack = new Stack<List<AbstractCommand>>();
    private Type _rightType;
    private Type _leftType;
    private AbstractExpression _expression;
    private PolyExpression _polyExpr;
    private String _idAtribuido;
    private boolean _isAtribuicao;

    public void setLanguage(String nome){
        program.setLanguage(nome);
    }

    public void init() {
        program.setSymbolTable(_symbolTable);
        _stack.push(new ArrayList<AbstractCommand>());
        _isAtribuicao = false;
    }

    public void exibirIds(){
        _symbolTable.getSymbols().values().stream().forEach((id)->System.out.println(id));
    }

    public void verificaId(String name) {
        if (!_symbolTable.exists(name)) {
            throw new SemanticException("Variable " + name + " not declared");
        }
    }

    public Identifier getId(String name) {
        verificaId(name);
        return _symbolTable.get(name);
    }

    public void generateObjectCode() {
        program.generateTarget();
    }

    public void verifyUnused() {
         _symbolTable.getSymbols().forEach((k, v) -> {
            if (!v.isUsed()) {
                System.out.printf("Variable %s declared but never used\n", k);
            }
        });
    }

    private void resetExpressions() {
        _expression = null;
        _polyExpr = null;
    }

    private void setExpressions(AbstractExpression expr) {
        if (_polyExpr != null) {
            _polyExpr.addExpression(expr);
        } else {
            _expression = expr;
        }
    }
}

prog: 'programa' (declara)* bloco 'fimprog.'
    {
        program.setCommands(_stack.pop());
    }
    ;

identifier: ID {
    _varName = _input.LT(-1).getText();
    _varValue = null;

    if (!_symbolTable.exists(_varName)) {
        _identifier = new Identifier(_varName, _type);
        _symbolTable.add(_identifier);

        CmdDeclaration decl = new CmdDeclaration(_identifier);
        _stack.peek().add(decl);
    } else {
        throw new SemanticException("Variable " + _varName + " already declared");
    }
} ;

declara: tipo identifier (VIR identifier)* PF ;

tipo : 'inteiro' { _type = Type.INTEGER; }
     | 'real' { _type = Type.REAL; }
     | 'texto' { _type = Type.STRING; } ;

bloco: (cmd)+ ;

cmd : cmdLeitura | cmdEscrita | cmdExpr | cmdIf | cmdWhile | cmdDoWhile ;

cmdLeitura: 'leia' AP ID {
    String idName = _input.LT(-1).getText();
    Identifier id = _symbolTable.get(idName);

    if (id == null) {
            throw new SemanticException("Variable " + idName + " not declared");
    }

    CmdRead read = new CmdRead(id);
    _stack.peek().add(read);
    id.setUsed(true);
} FP PF ;

cmdEscrita: 'escreva' AP (ID {
    String idName = _input.LT(-1).getText();
    Identifier id = _symbolTable.get(idName);

    if (id == null) {
        throw new SemanticException("Variable " + idName + " not declared");
    }

    CmdWrite write = new CmdWrite(id);
    _stack.peek().add(write);
} | TEXT {
    String text = _input.LT(-1).getText();
    CmdWrite write = new CmdWrite(text);
    _stack.peek().add(write);
}) FP PF ;

cmdExpr: ID {
    _idAtribuido = _input.LT(-1).getText();
    verificaId(_idAtribuido);

    _leftType = _symbolTable.get(_idAtribuido).getType();
    _rightType = null;
    _isAtribuicao = true;

    _symbolTable.get(_idAtribuido).setUsed(true);
} ATTR expr PF {
    Identifier id = _symbolTable.get(_idAtribuido);
    if (_expression != null) {
        _symbolTable.add(id);

        CmdAttrib attr = new CmdAttrib(id, _polyExpr != null ? _polyExpr : _expression);

        _stack.peek().add(attr);
        resetExpressions();
        _isAtribuicao = false;
    }
} ;

cmdIf: 'se' {
    _stack.push(new ArrayList<AbstractCommand>());
    BinaryExpression _relExpr = new BinaryExpression();
    CmdIf _cmdIf = new CmdIf();

    boolean hasElse = false;
} AP expr {
    _relExpr.setLeft(_expression);
} OP_REL {
    _relExpr.setOperator(_input.LT(-1).getText().charAt(0));
} expr {
    _relExpr.setRight(_expression);
    _cmdIf.setExpr(_relExpr);
    resetExpressions();
} FP AC bloco {
    _cmdIf.setListTrue(_stack.pop());
} FC ('senao' AC {
    hasElse = true;
    _stack.push(new ArrayList<AbstractCommand>());
} bloco FC)? {
    if (hasElse) {
        _cmdIf.setListFalse(_stack.pop());
    }

    _stack.peek().add(_cmdIf);
} ;

cmdWhile: 'enquanto' {
    _stack.push(new ArrayList<AbstractCommand>());
    BinaryExpression _relExpr = new BinaryExpression();
    CmdWhile _cmdWhile = new CmdWhile();
} AP expr{
    _relExpr.setLeft(_expression);
} OP_REL {
    _relExpr.setOperator(_input.LT(-1).getText().charAt(0));
} expr {
    _relExpr.setRight(_expression);
    resetExpressions();
    _cmdWhile.setExpr(_relExpr);
} FP AC bloco {
    _cmdWhile.setListTrue(_stack.pop());
    _stack.peek().add(_cmdWhile);
} FC ;

cmdDoWhile: 'faca' {
    _stack.push(new ArrayList<AbstractCommand>());
    BinaryExpression _relExpr = new BinaryExpression();
    CmdDoWhile _cmdDoWhile = new CmdDoWhile();
} AC bloco {
    _cmdDoWhile.setListTrue(_stack.pop());
} FC 'enquanto' AP expr {
    _relExpr.setLeft(_expression);
} OP_REL {
    _relExpr.setOperator(_input.LT(-1).getText().charAt(0));
} expr {
    _relExpr.setRight(_expression);
    _cmdDoWhile.setExpr(_relExpr);
    _stack.peek().add(_cmdDoWhile);
    _expression = null;
    _polyExpr = null;
} FP PF;

expr: termo (OP {
    if (_polyExpr == null) {
        _polyExpr = new PolyExpression();
        _polyExpr.addExpression(_expression);
    }

    _polyExpr.addOperator(_input.LT(-1).getText());
} termo)* ;

termo: INTEGER {
    setExpressions(new IntegerExpression(_input.LT(-1).getText()));
} | REAL {
    setExpressions(new RealExpression(_input.LT(-1).getText()));
} | TEXT {
    setExpressions(new TextExpression(_input.LT(-1).getText()));
} | ID {
    String idName = _input.LT(-1).getText();
    Identifier id = _symbolTable.get(idName);
    if (id == null) {
        throw new SemanticException("Variable " + idName + " not declared");
    }

    if (_isAtribuicao) {
        _rightType = id.getType();
        if (_leftType != _rightType) {
              throw new SemanticException("Type mismatch (" + _leftType + ", " + _rightType + ")");
        }

        if (id.isUsed()) {
            setExpressions(new AttributionExpression(_identifier, id));
        } else {
            throw new SemanticException("Unassigned variable: " + idName);
        }
    } else {
        setExpressions(new VariableExpression(id));
    }
  };

AP: '(' ;

FP: ')' ;

PF: '.' ;

VIR: ',' ;

AC: '{' ;

FC: '}' ;

SC: ';' ;

ATTR: ':=' ;

OP: '+' | '-' | '*' | '/' ;

OP_REL: '<' | '>' | '<=' | '>=' | '!=' | '==' ;

ID: [a-z] ([a-z]|[A-Z]|[0-9])* ;

INTEGER: [0-9]+ ;

REAL: [0-9]+ ('.' [0-9]+)? ;

TEXT: '"' ([a-z]|[A-Z]|[0-9]|' '|'\t'|'!'|'-'|'='|'<'|'>'|'?'|':' |'\\' )* '"';

BLANK: (' '| '\t' | '\n' | '\r') -> skip;

CS: '/*';

CE: '*/';

CL: '//';

SIGLE_COMMENT: CL ~( '\r' | '\n' )* -> skip;

MULTI_COMMENT: CS (.)*? CE -> skip;