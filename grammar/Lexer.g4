lexer grammar Lexer;


WS: [ \t\r]+ -> skip;
NEWLINE: '\n';

LPAREN: '(';
RPAREN: ')';
LBRACE: '{';
RBRACE: '}';
SEMICOLON: ';';

ADD: '+';
SUB: '-';
MUL: '*';
DIV: '/';
MOD: '%';

SIN: 'sin';
COS: 'cos';

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

TRUE: 'true';
FALSE: 'false';

IF: 'if';
WHILE: 'while';

PRINT: 'print';
SCAN: 'scan';

NUMBER: [0-9]+ ('.' [0-9]+)?;
NUM_VAR: 'X' [0-9];
BOOL_VAR: 'L' [0-9];