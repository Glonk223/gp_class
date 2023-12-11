lexer grammar Lexer;


WS: [ \t\r\n]+ -> skip;

LPAREN: '(';
RPAREN: ')';
LBRACE: '{';
RBRACE: '}';

ADD: '+';
SUB: '-';
MUL: '*';
DIV: '/';
MOD: '%';

ASS: '=';

EQ: '==';
NEQ: '!=';
LE: '<';
LEQ: '<=';
GE: '>';
GEQ: '>=';

AND: '&&';
OR: '||';
NOT: '!';

TRUE: 'True';
FALSE: 'False';

IF: 'if';
WHILE: 'while';

PRINT: 'print';
SCAN: 'scan';

NUMBER: [0-9]+ ('.' [0-9]+)?;
NUM_VAR: 'X' [0-9];
BOOL_VAR: 'L' [0-9];