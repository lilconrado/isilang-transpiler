grammar IsiLang;

prog: 'programa' (declara)? bloco 'fimprog.' ;

declara: 'declare' ID (VIR ID)* PF ;

bloco: (cmd)+ ;

cmd : cmdLeitura | cmdEscrita | cmdExpr | cmdIf | cmdWhile | cmdDoWhile ;

cmdLeitura: 'leia' AP ID FP PF ;

cmdEscrita: 'escreva' AP (ID | TEXT) FP PF ;

cmdExpr: ID ATTR expr PF;

cmdIf: 'se' AP expr OP_REL expr FP AC bloco FC ('senao' AC bloco FC)? ;

cmdWhile: 'enquanto' AP expr OP_REL expr FP AC bloco FC ;

cmdDoWhile: 'faca' AC bloco FC 'enquanto' AP expr OP_REL expr FP ;

expr: termo (OP termo)* ;

termo: ID | NUMBER | TEXT;

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