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

    System.out.println(_identifier);
} ;

declara: 'declare' identifier (VIR identifier)* PF ;

bloco: (cmd)+ ;

cmd : cmdLeitura | cmdEscrita | cmdExpr | cmdIf | cmdWhile | cmdDoWhile ;

cmdLeitura: 'leia' AP ID FP PF ;

cmdEscrita: 'escreva' AP (ID | TEXT) FP PF ;

cmdExpr: ID {
    System.out.println("ID = " + _input.LT(-1).getText());
} ATTR expr PF;

cmdIf: 'se' AP expr OP_REL expr FP AC bloco FC ('senao' AC bloco FC)? ;

cmdWhile: 'enquanto' AP expr OP_REL expr FP AC bloco FC ;

cmdDoWhile: 'faca' AC bloco FC 'enquanto' AP expr OP_REL expr FP ;

expr: termo (OP termo)* ;

termo: ID | NUMBER | TEXT ;

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