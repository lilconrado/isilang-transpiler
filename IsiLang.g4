grammar IsiLang;

@header {
    import java.util.ArrayList;
    import java.lang.String;
    import io.github.lilconrado.isilang.symbols.Identifier;
    import io.github.lilconrado.isilang.symbols.SymbolTable;
    import io.github.lilconrado.isilang.symbols.Type;
    import io.github.lilconrado.isilang.exceptions.SemanticException;
}

@members {
    private Type _type;
    private String _varName;
    private String _varValue;
    private SymbolTable _symbolTable = new SymbolTable();
    private Identifier _identifier;

    public void verificaId(String name) {
        if (!_symbolTable.exists(name)) {
            throw new SemanticException("Variable " + name + " not declared");
        }
    }

    public Identifier getId(String name) {
        verificaId(name);
        return _symbolTable.get(name);
    }
}

prog: 'programa' (declara)? bloco 'fimprog.' ;

identifier: ID {
    _varName = _input.LT(-1).getText();
    _varValue = null;

    if (!_symbolTable.exists(_varName)) {
        _identifier = new Identifier(_varName);
        _symbolTable.add(_identifier);
    } else {
        throw new SemanticException("Variable " + _varName + " already declared");
    }
} ;

declara: 'declare' identifier (VIR identifier)* PF ;

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
    System.out.println(_identifier);
} | TEXT {
    _identifier.setType(_input.LT(-1).getText());
    System.out.println(_identifier);
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