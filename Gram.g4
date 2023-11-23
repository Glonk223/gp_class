grammar Gram;


WS: [ \t\r]+ -> skip;
NEWLINE: '\n';

ADD: '+';
SUB: '-';
MUL: '*';
DIV: '/';
MOD: '%';
POW: '**';
ROT: '//';

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

IF: 'if';
WHILE: 'while';

PRINT: 'print';
SCAN: 'scan';

NUMBER: [0-9]+ '.' [0-9]+;
VARIABLE: 'X' [0-9];

comparisson_type: EQ | NEQ | LE | LEQ | GE | GEQ;

logic_operator: AND | OR;

aritmetic_operator: ADD | SUB | MUL | DIV | MOD | POW | ROT;

trigonometric_operator: SIN | COS;

value: NUMBER | VARIABLE | num_expr;

prog: (expr NEWLINE+)+;

expr:
	if_statement
	| while_loop
	| block
	| print_call
	| scan_call
	| assignment;

block: '{' expr+ '}';

// ----- IF -----
if_statement: IF '(' if_condition ')' block;

if_condition:
	value comparisson_type value
	| if_condition logic_operator if_condition;

// ----- WHILE -----
while_loop: WHILE '(' if_condition ')' block;

// ----- ASSIGNMENT -----
assignment: VARIABLE '=' value;

// ----- NUMBER EXPRESSION -----
num_expr:
	'(' expr aritmetic_operator expr ')'
	| trigonometric_operator '(' expr ')'
	| NUMBER
	| VARIABLE;

// ----- PRINT -----
print_call: PRINT '(' num_expr ')';

// ----- SCAN -----
scan_call: SCAN '(' VARIABLE ')';