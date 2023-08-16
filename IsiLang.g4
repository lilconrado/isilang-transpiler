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
    private String _idAtribuido;

    public void init() {
        program.setSymbolTable(_symbolTable);
        _stack.push(new ArrayList<AbstractCommand>());
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
    verificaId(_input.LT(-1).getText());
} FP PF ;

cmdEscrita: 'escreva' AP (ID {
    verificaId(_input.LT(-1).getText());
} | TEXT) FP PF ;

cmdExpr: ID {
    _idAtribuido = _input.LT(-1).getText();
    verificaId(_idAtribuido);

    _leftType = _symbolTable.get(_idAtribuido).getType();
    _rightType = null;
} ATTR expr PF {
    Identifier id = _symbolTable.get(_idAtribuido);
    if (_expression != null) {
        id.setValue(_expression.eval());
        _symbolTable.add(id);

        System.out.println("EVAL ("+_expression+") = "+_expression.eval());

        CmdAttrib attr = new CmdAttrib(id, _expression);
        _stack.peek().add(attr);
        _expression = null;
    }
} ;

cmdIf: 'se' AP expr OP_REL expr FP AC bloco FC ('senao' AC bloco FC)? ;

cmdWhile: 'enquanto' AP expr OP_REL expr FP AC bloco FC ;

cmdDoWhile: 'faca' AC bloco FC 'enquanto' AP expr OP_REL expr FP ;

expr: termo (OP termo)* ;

termo: ID {
    _idAtribuido = _input.LT(-1).getText();
    verificaId(_idAtribuido);
} | INTEGER {
    _expression = new IntegerExpression(_input.LT(-1).getText());
} | REAL {
    _expression = new RealExpression(_input.LT(-1).getText());
} | TEXT {
    _expression = new TextExpression(_input.LT(-1).getText());
} ;

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

TEXT: '"' ([a-z]|[A-Z]|[0-9]|' '|'\t'|'!'|'-'|'='|'<'|'>')* '"';

BLANK: (' '| '\t' | '\n' | '\r') -> skip;

CS: '/*';

CE: '*/';

CL: '//';

SIGLE_COMMENT: CL ~( '\r' | '\n' )* -> skip;

MULTI_COMMENT: CS (.)*? CE -> skip;