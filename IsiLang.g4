grammar IsiLang;

prog: 'programa' declara bloco 'fimprog.' ;

declara: 'declare' ID (VIR ID)* PF ;

bloco: (cmd PF)+ ;

cmd : cmdLeitura | cmdEscrita | cmdExpr ;

cmdLeitura: 'leia' AP ID FP ;

cmdEscrita: 'escreva' AP (ID | TEXT) FP ;

cmdExpr: ID ATTR expr ;

expr: termo (OP termo)* ;

termo: ID | NUMBER;

AP: '(' ;

FP: ')' ;

PF: '.' ;

VIR: ',' ;

ATTR: ':=' ;

OP: '+' | '-' | '*' | '/' ;

ID: [a-z] ([a-z][A-Z]|[0-9])* ;

NUMBER: [0-9]+ ('.'[0-9]+) ;

TEXT: '"' ([a-z]|[A-Z]|[0-9]|' '|'\t'|'!'|'-')* '"';

BLANK     : (' '| '\t' | '\n' | '\r') -> skip;