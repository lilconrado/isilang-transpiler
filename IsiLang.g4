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
    private Stack<List<AbstractCommand>> stack = new Stack<List<AbstractCommand>>();

    public void init() {
        program.setSymbolTable(_symbolTable);
        stack.push(new ArrayList<AbstractCommand>());
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

    public void generateObjectCode(){
        program.generateTarget();
    }
}

prog: 'programa' (declara)* bloco 'fimprog.'
    {
        program.setCommands(stack.pop());
    }
    ;

identifier: ID {
    _varName = _input.LT(-1).getText();
    _varValue = null;

    if (!_symbolTable.exists(_varName)) {
        _identifier = new Identifier(_varName, _type);
        _symbolTable.add(_identifier);
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
    _identifier = getId(_input.LT(-1).getText());
} ATTR expr PF;

cmdIf: 'se' AP expr OP_REL expr FP AC bloco FC ('senao' AC bloco FC)? ;

cmdWhile: 'enquanto' AP expr OP_REL expr FP AC bloco FC ;

cmdDoWhile: 'faca' AC bloco FC 'enquanto' AP expr OP_REL expr FP ;

expr: termo (OP termo)* ;

termo: ID {
    verificaId(_input.LT(-1).getText());
} | NUMBER {
    _identifier.setType(_input.LT(-1).getText());
} | TEXT {
    _identifier.setType(_input.LT(-1).getText());
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

NUMBER: [0-9]+ ('.' [0-9]+)? ;

TEXT: '"' ([a-z]|[A-Z]|[0-9]|' '|'\t'|'!'|'-'|'='|'<'|'>')* '"';

BLANK: (' '| '\t' | '\n' | '\r') -> skip;

CS: '/*';

CE: '*/';

CL: '//';

SIGLE_COMMENT: CL ~( '\r' | '\n' )* -> skip;

MULTI_COMMENT: CS (.)*? CE -> skip;