grammar Gram;

options { tokenVocab=Lexer; }


program: expressions;


//! ----- EXPRESSIONS -----
expressions
    :   ( if_statement
        | while_loop
        | print_call
        | scan_call
        | assignment) (expressions | )
    ;

//! ----- IF_STATEMENT -----
if_statement: IF LPAREN bool_value RPAREN block;

//! ----- WHILE_LOOP -----
while_loop  : WHILE LPAREN bool_value RPAREN block;

//! ----- BLOCK -----
block: LBRACE expressions RBRACE;

//! ----- PRINT_CALL -----
print_call
    : PRINT LPAREN numeric_value RPAREN
    | PRINT LPAREN  bool_value   RPAREN
    ;

//! ----- SCAN_CALL -----
scan_call
    : SCAN LPAREN NUM_VAR  RPAREN
    | SCAN LPAREN BOOL_VAR RPAREN
    ;

//! ----- ASSIGNMENT -----
assignment
    : NUM_VAR  ASS numeric_value
    | BOOL_VAR ASS bool_value
    ;

//! ----- MATH & LOGIC -----
comparisson_type            : EQ  | NEQ | LE  | LEQ | GE  | GEQ;
logic_operator              : AND | OR  ;
aritmetic_operator_strong   : MUL | DIV | MOD ;
aritmetic_operator_weak     : ADD | SUB ;

bool_value
    : BOOL_VAR | TRUE | FALSE | NOT bool_value
    | numeric_value comparisson_type numeric_value
    | bool_value     logic_operator     bool_value
    | LPAREN bool_value RPAREN
    ;

numeric_value
    : NUMBER | NUM_VAR | SUB numeric_value
    | numeric_value aritmetic_operator_strong numeric_value
    | numeric_value  aritmetic_operator_weak  numeric_value
    | LPAREN numeric_value RPAREN
    ;