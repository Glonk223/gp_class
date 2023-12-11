# OurGP
## A Genetic Programming Framework for our grammmar implemented in C#.

## Code Structure
```java
abs Node
 ├─ abs Expression
 │   ├─ abs Assignment
 │   │   ├─ NumericAssignment
 │   │   └─ BooleanAssignment
 │   │
 │   ├─ IfStatement
 │   ├─ PrintStatement
 │   ├─ ScanStatement
 │   └─ WhileStatement
 │
 ├─ abs Value
 │   ├─ IVariable
 │   ├─ IConstant
 │   │
 │   ├─ abs BooleanValue
 │   │   ├─ BooleanConstant : IConstant
 │   │   ├─ BooleanNegation
 │   │   ├─ BooleanVariable : IVariable
 │   │   ├─ ComparisonOperation
 │   │   └─ LogicalOperation
 │   │
 │   └─ abs NumericValue
 │       ├─ ArithmeticOperation
 │       ├─ NumericConstant : IConstant
 │       ├─ NumericNegation
 │       └─ NumericVariable : IVariable
 │
 └─ Program
```
