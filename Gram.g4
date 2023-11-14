
grammar Gram;

WS: ' ' -> skip;

ADD: '+';
SUBSTRACT: '-';
MULTIPLY: '*';
DIVIDE:  '/';
EQ: '=';
COMA : ',';
LPAREN: '(';
RPAREN: ')';
LCURL: '{';
RCURL: '}';
LTHAN: '<';
GTHAN: '>';
LE: '<=';
GE: '>=';
EQEQ: '==';
NOTEQ: '!=';
AND: '&&';
OR: '||';
SINGLE_QUOTE: '\'';
IF: 'if';
ELSE: 'else';
FOR: 'for';
WHILE: 'while';
BREAK: 'break';
CONST: 'const';
NEWLINE: [\r\n]+ ;
INT: 'Int';
DOUBLE: 'Double';
FLOAT: 'Float';
CHAR: 'Char';
STRING: 'String';
BOOLEAN: 'Boolean';
PRINT: 'print';
SCAN: 'scan';
IDENTIFIER: ('a'..'z' | 'A'..'Z') ('0'..'9' | 'a'..'z' | 'A'..'Z')*;
INTLITERAL: ('-'? ('1'..'9')('0'..'9')*) | '0';
DOUBLELITERAL:  ('0'..'9')+ '.' ('0'..'9')+ ;
UNTERMINATEDSTRINGLITERAL : '"' (~["\\\r\n] | '\\' (. | EOF))*;
STRINGLITERAL: UNTERMINATEDSTRINGLITERAL '"';
CHARLITERAL: '"' (~["\\\r\n] | '\\' (. | EOF)) '"';
BOOLEANLITERAL: 'true' | 'false';
INTNUMBER: ('0'..'9');

prog: (expr NEWLINE*)*;

expr: (
      variable
    | if_statement
    | variable_assign
    | print_call
    | scan_call
    | while_loop
    | block
    | NEWLINE);

block: LCURL expr* RCURL;
variable: variable_assign | variable_declaration;
variable_declaration: (CONST)? typ IDENTIFIER (EQ literals)?;
variable_assign: IDENTIFIER EQ literals;

operators: MULTIPLY
            | DIVIDE
            | ADD
            | SUBSTRACT;

logic_operators: AND
                | OR;

numeric_literals: numeric_type operators numeric_type
        | numeric_type;

text_type: text_type  ADD text_type
        | STRINGLITERAL
        | CHARLITERAL
        | IDENTIFIER;

numeric_type:   INTLITERAL
              | DOUBLELITERAL
              | IDENTIFIER
              | numeric_type operators numeric_type;

literals:   BOOLEANLITERAL
        | text_type
        | numeric_literals
        | IDENTIFIER
        | scan_call;

comparisson_type: EQEQ
          | LE
          | GE
          | GTHAN
          | LTHAN
          | NOTEQ;

typ:  INT
    | DOUBLE
    | STRING
    | CHAR
    | IDENTIFIER
    | BOOLEAN;

if_statement: IF LPAREN if_condition RPAREN LCURL NEWLINE*
                expr*
                RCURL NEWLINE*  (ELSE if_statement | ELSE LCURL NEWLINE* expr* RCURL NEWLINE*)?;

if_condition: literals comparisson_type literals
        | if_condition logic_operators if_condition;

while_loop: WHILE LPAREN while_condition RPAREN LCURL NEWLINE*
            expr*
            RCURL;

while_condition: (literals comparisson_type literals);

print_call: PRINT LPAREN (text_type)? RPAREN NEWLINE*;

scan_call: SCAN LPAREN (IDENTIFIER)? RPAREN NEWLINE*;