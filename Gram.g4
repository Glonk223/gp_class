grammar Gram;


WS: [ \t\r]+ -> skip;
NEWLINE: '\n';

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

NUMBER: [0-9]+ ('.'[0-9]+)?;
NUM_VAR: 'X' [0-9];
BOOL_VAR: 'L' [0-9];

prog: expr+;

comparisson_type: EQ | NEQ | LE | LEQ | GE | GEQ;

logic_operator: AND | OR;

aritmetic_operator: ADD | SUB | MUL | DIV | MOD;

trigonometric_operator: SIN | COS;

bool_value: BOOL_VAR | TRUE | FALSE | NOT bool_value
    | '(' bool_value logic_operator bool_value ')'
    | '(' numeric_value comparisson_type numeric_value ')'
    ;

numeric_value: NUMBER | NUM_VAR | num_expr;

expr:
	if_statement
	| while_loop
	| block
	| print_call
	| scan_call
	| assignment
	| NEWLINE+
	;

block: '{' expr* '}';

// ----- IF -----
if_statement: IF '(' bool_value ')' NEWLINE? block;

// ----- WHILE -----
while_loop: WHILE '(' bool_value ')' NEWLINE? block;

// ----- ASSIGNMENT -----
assignment
    : NUM_VAR '=' numeric_value
    | BOOL_VAR '=' bool_value
    ;

// ----- NUMBER EXPRESSION -----
num_expr:
    num_expr (MUL | DIV | MOD) num_expr
    | num_expr (ADD | SUB) num_expr
	| '('num_expr')'
	| trigonometric_operator '(' num_expr ')'
	| NUMBER
	| NUM_VAR;

// ----- PRINT -----
print_call
    : PRINT '(' numeric_value ')'
    | PRINT '(' bool_value ')';

// ----- SCAN -----
scan_call
    : SCAN '(' NUM_VAR ')'
    | SCAN '(' BOOL_VAR ')';
