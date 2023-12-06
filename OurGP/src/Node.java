import java.util.ArrayList;
import java.util.List;
import java.util.Random;

enum Rules {
    PROGRAM,
    EXPR,
    IF,
    WHILE,
    BLOCK,
    PRINT,
    SCAN,
    ASSIGN,
    COMPARISON,
    LOGIC,
    ARITHMETIC,
    TRIG,
    BOOL_VALUE,
    NUMERIC_VALUE
}

abstract class Node {
    Node parent;
    int depth;
    int max_depth = 30;
}

class LeafNode extends Node {
    String token;

    LeafNode(Node parr, String tok) {
        this.parent = parr;
        this.token = tok;
        this.depth = parent.depth+1;
    }
}

class RuleNode extends Node {
    List<Node> children;
    Rules rule;

    RuleNode(Node parr, Rules r) {
        this.parent = parr;
        this.rule = r;
        this.depth = parent.depth+1;
    }

    List<Node> generateExpressions() {
        List<Node> childs = new ArrayList<>();
        Random random = new Random();
        int howManyChilds = random.nextInt(10+1)+1;
        for(int i=0; i < howManyChilds; i++) {
            int expr = random.nextInt(6);
            Rules[] exprChildRules = {Rules.IF, Rules.WHILE, Rules.BLOCK, Rules.PRINT, Rules.SCAN, Rules.ASSIGN};

            if (max_depth - this.depth > 2) {
                childs.add(new RuleNode(this, exprChildRules[expr]));
            }
            else {
                expr %= 3;
                childs.add(new RuleNode(this, exprChildRules[expr+3]));

            }
        }
        return childs;
    }

    String boolVar() {
        Random random = new Random();
        return "L" + String.valueOf(random.nextInt(10));
    }

    String numVar() {
        Random random = new Random();
        return "X" + String.valueOf(random.nextInt(100));
    }

    void grow() {
        Random random = new Random();
        String[] compSymbols = {"=", "!=", "<", "<=", ">", ">="};
        String[] logicSymbols = {"&&", "||"};
        String[] arithSymbols = {"+", "-", "*", "/", "%"};
        String[] trigSymbols = {"sin", "cos"};

        switch (this.rule) {
            case Rules.PROGRAM:
                this.children.add(new RuleNode(this, Rules.EXPR));
                break;
            case Rules.EXPR:
                this.children = generateExpressions();
                break;
            case Rules.IF:
                this.children.add(new LeafNode(this, "if"));
                this.children.add(new LeafNode(this, "("));
                this.children.add(new RuleNode(this, Rules.BOOL_VALUE));
                this.children.add(new LeafNode(this, ")"));
                this.children.add(new LeafNode(this, "\n"));
                this.children.add(new LeafNode(this, "{"));
                this.children.add(new RuleNode(this, Rules.BLOCK));
                break;
            case Rules.WHILE:
                this.children.add(new LeafNode(this, "while"));
                this.children.add(new LeafNode(this, "("));
                this.children.add(new RuleNode(this, Rules.BOOL_VALUE));
                this.children.add(new LeafNode(this, ")"));
                this.children.add(new LeafNode(this, "\n"));
                this.children.add(new LeafNode(this, "{"));
                this.children.add(new RuleNode(this, Rules.BLOCK));
                break;
            case Rules.BLOCK:
                this.children.add(new LeafNode(this, "{"));
                this.children.add(new RuleNode(this, Rules.EXPR));
                this.children.add(new LeafNode(this, "}"));
                break;
            case Rules.PRINT:
                this.children.add(new LeafNode(this, "print"));
                this.children.add(new LeafNode(this, "("));
                if  (random.nextInt(2) == 0)
                    this.children.add(new RuleNode(this, Rules.NUMERIC_VALUE));
                else
                    this.children.add(new RuleNode(this, Rules.BOOL_VALUE));
                this.children.add(new LeafNode(this, ")"));
                break;
            case Rules.SCAN:
                this.children.add(new LeafNode(this, "scan"));
                this.children.add(new LeafNode(this, "("));
                if  (random.nextInt(2) == 0)
                    this.children.add(new LeafNode(this, numVar()));
                else
                    this.children.add(new LeafNode(this, boolVar()));
                this.children.add(new LeafNode(this, ")"));
                break;
            case Rules.ASSIGN:
                if  (random.nextInt(2) == 0) {
                    this.children.add(new LeafNode(this, numVar()));
                    this.children.add(new LeafNode(this, "="));
                    this.children.add(new RuleNode(this, Rules.NUMERIC_VALUE));
                }
                else {
                    this.children.add(new LeafNode(this, boolVar()));
                    this.children.add(new LeafNode(this, "="));
                    this.children.add(new RuleNode(this, Rules.BOOL_VALUE));
                }
                this.children.add(new LeafNode(this, ";"));
                break;
            case Rules.COMPARISON:
                this.children.add(new LeafNode(this, compSymbols[random.nextInt(6)]));
                break;
            case Rules.LOGIC:
                this.children.add(new LeafNode(this, logicSymbols[random.nextInt(2)]));
                break;
            case Rules.ARITHMETIC:
                this.children.add(new LeafNode(this, arithSymbols[random.nextInt(5)]));
                break;
            case Rules.TRIG:
                this.children.add(new LeafNode(this, trigSymbols[random.nextInt(2)]));
                break;
        }
    }
}
