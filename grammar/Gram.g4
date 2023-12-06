grammar Gram;

options { tokenVocab=Lexer; }


program: expr+;

expr
    : if_statement
    | while_loop
    | block
    | print_call
    | scan_call
    | assignment
    ;

//! ----- IF_STATEMENT -----
if_statement: IF LPAREN bool_value RPAREN block;

//! ----- WHILE_LOOP -----
while_loop  : WHILE LPAREN bool_value RPAREN block;

//! ----- BLOCK -----
block: LBRACE expr* RBRACE;

//! ----- PRINT_CALL -----
print_call
    : PRINT LPAREN numeric_value RPAREN SEMICOLON
    | PRINT LPAREN  bool_value   RPAREN SEMICOLON
    ;

//! ----- SCAN_CALL -----
scan_call
    : SCAN LPAREN NUM_VAR  RPAREN SEMICOLON
    | SCAN LPAREN BOOL_VAR RPAREN SEMICOLON
    ;

//! ----- ASSIGNMENT -----
assignment
    : NUM_VAR  ASS numeric_value SEMICOLON
    | BOOL_VAR ASS bool_value SEMICOLON
    ;

//! ----- MATH & LOGIC -----
comparisson_type      : EQ  | NEQ | LE  | LEQ | GE  | GEQ;
logic_operator        : AND | OR  ;
aritmetic_operator    : ADD | SUB | MUL | DIV | MOD ;
trigonometric_operator: SIN | COS ;

bool_value
    : BOOL_VAR | TRUE | FALSE | NOT bool_value
    | numeric_value comparisson_type numeric_value
    | bool_value     logic_operator     bool_value
    | LPAREN bool_value RPAREN
    ;

numeric_value
    : NUMBER | NUM_VAR
    | numeric_value (MUL | DIV | MOD) numeric_value
    | numeric_value    (ADD | SUB)    numeric_value
    | trigonometric_operator LPAREN numeric_value RPAREN
    | LPAREN numeric_value RPAREN
    ;