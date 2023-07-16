grammar IsiLang;

prog: 'programa' bloco 'fimprog.' ;

bloco: (cmd)+ ;

cmd : cmdLeitura | cmdEscrita | cmdExpr ;

cmdLeitura: 'leia' AP ID FP PF ;

cmdEscrita: 'escreva' AP (ID | TEXT) FP PF ;

cmdExpr: ID ATTR expr PF;

expr: termo (OP termo)* ;

termo: ID | NUMBER;

AP: '(' ;

FP: ')' ;

PF: '.' ;

ATTR: ':=' ;

OP: '+' | '-' | '*' | '/' ;

ID: [a-z] ([a-z][A-Z]|[0-9])* ;

NUMBER: [0-9]+ ('.'[0-9]+) ;

TEXT: '"' ([a-z]|[A-Z]|[0-9]|' '|'\t'|'!'|'-')* '"';

BLANK     : (' '| '\t' | '\n' | '\r') -> skip;