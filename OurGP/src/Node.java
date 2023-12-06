import java.util.ArrayList;
import java.util.List;
import java.util.Random;


enum Rules {
    PROGRAM(null),
    EXPR(null),
    IF(EXPR),
    WHILE(EXPR),
    BLOCK(EXPR),
    PRINT(EXPR),
    SCAN(EXPR),
    ASSIGN(EXPR),
    BOOL_VALUE(null),
    NUMERIC_VALUE(null),
    COMPARISON(BOOL_VALUE),
    LOGIC(BOOL_VALUE),
    ARITHMETIC(NUMERIC_VALUE),
    TRIG(NUMERIC_VALUE);

    private final Rules dependency;

    Rules(Rules dependency) {
        this.dependency = dependency;
    }

    public Rules getDependency() {
        if (this.dependency == null)
            return this;
        return dependency;
    }
}

abstract class Node {
    Node parent;
    int depth;
    Rules rule;
    static final int max_depth = 30;
    static final double mutation_probability = 0.05;

    Node copy() { return copy(null); }
    abstract Node copy(Node parent);
    abstract int length();
    abstract Node getNode(int index);
    ArrayList<Node> getNodes(Rules rule) {
        return getNodes(rule, new ArrayList<Node>());
    }
    abstract ArrayList<Node> getNodes(Rules rule, ArrayList<Node> nodes);

    Rules getRuleClass() {
        return this.rule.getDependency();
    }

    abstract void mutate();
}

class LeafNode extends Node {
    String token;

    LeafNode(Node parr, String tok) {
        this.rule = null;
        this.parent = parr;
        this.token = tok;
        this.depth = parent.depth+1;
    }

    LeafNode copy(Node parent) {
        return new LeafNode(parent, this.token);
    }

    int length() { return 1; }
    Node getNode(int index) { return null; }
    ArrayList<Node> getNodes(Rules rule, ArrayList<Node> nodes) {
        return nodes;
    }

    void mutate() {
        if (Math.random() > mutation_probability) return;

        Random random = new Random();
        String[] compSymbols = {"==", "!=", "<", "<=", ">", ">="};
        String[] logicSymbols = {"&&", "||"};
        String[] arithSymbols = {"+", "-", "*", "/", "%"};
        String[] trigSymbols = {"sin", "cos"};

        switch (token) {
            case "==", "!=", "<", "<=", ">", ">=":
                this.token = compSymbols[random.nextInt(6)];
                break;
            case "&&", "||":
                this.token = logicSymbols[random.nextInt(2)];
                break;
            case "+", "-", "*", "/", "%":
                this.token = arithSymbols[random.nextInt(5)];
                break;
            case "sin", "cos":
                this.token = trigSymbols[random.nextInt(2)];
                break;
        }
    }
}

class RuleNode extends Node {
    List<Node> children;

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

    void grow(int max_depth) {
        Random random = new Random();
        String[] compSymbols = {"==", "!=", "<", "<=", ">", ">="};
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

    RuleNode copy(Node parent) {
        RuleNode copy = new RuleNode(parent, this.rule);
        for (Node child : this.children)
            copy.children.add(child.copy(copy));

        return copy;
    }

    int length() {
        int len = 1;
        for (Node child : this.children)
            len += child.length();

        return len;
    }

    Node getNode(int index) {
        if (index == 0)
            return this;
        else {
            for (Node child : this.children) {
                if (index < child.length())
                    return child.getNode(index-1);
                else
                    index -= child.length();
            }
            return null;
        }
    }

    ArrayList<Node> getNodes(Rules rule, ArrayList<Node> nodes) {
        if (this.rule.getDependency() == rule)
            nodes.add(this);

        for (Node child : this.children)
            child.getNodes(rule, nodes);

        return nodes;
    }

    void mutate() {
        for (Node child : this.children)
            child.mutate();
    }


}
