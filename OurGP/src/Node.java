import java.util.*;

enum Rules{
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
    List<Node> children;
    Node parent;
    int depth;
    Rules rule;
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

    abstract public String toString();
    abstract void grow(int max_depth);
    abstract void mutate();
}

class LeafNode extends Node {
    String token;

    LeafNode(Node parr, String tok){
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

    @Override
    void grow(int max_depth) {
    }

    void mutate() {
        Random random = new Random();
        if (random.nextDouble() > mutation_probability) return;

        String[] compSymbols = {"==", "!=", "<", "<=", ">", ">="};
        String[] logicSymbols = {"&&", "||"};
        String[] arithSymbols = {"+", "-", "*", "/", "%"};
        String[] trigSymbols = {"sin", "cos"};

        // System.out.print("mutate leaf: " + this.token + " -> ");
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
        // System.out.println(this.token);
    }

    public String toString() {
        return token;
    }
}


class RuleNode extends Node {
    RuleNode(Node parr, Rules r, int depth) {
        this.parent = parr;
        this.rule = r;
        this.depth = depth;
        this.children = new ArrayList<>();
    }

    RuleNode(Node parr, Rules r) {
        this.parent = parr;
        this.rule = r;
        this.children = new ArrayList<>();
        if (parr == null)
            this.depth = 0;
        else
            this.depth = parent.depth+1;
    }

    List<Node> generateExpressions(int max_depth) {
        List<Node> childs = new ArrayList<>();
        Random random = new Random();
        int howManyChilds = random.nextInt(4)+1;
        for(int i=0; i < howManyChilds; i++) {
            int expr = random.nextInt(6);
            Rules[] exprChildRules = {Rules.IF, Rules.WHILE, Rules.BLOCK, Rules.PRINT, Rules.SCAN, Rules.ASSIGN};

            if (max_depth - this.depth > 3) {
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
        return "L" + random.nextInt(10);
    }

    String numVar() {
        Random random = new Random();
        return "X" + random.nextInt(10);
    }

    String number() {
        Random random = new Random();
        return Double.toString(random.nextDouble(100));
    }

    @Override
    void grow(int max_depth) {
        Random random = new Random();
        String[] compSymbols = {"==", "!=", "<", "<=", ">", ">="};
        String[] logicSymbols = {"&&", "||"};
        String[] arithSymbols = {"+", "-", "*", "/", "%"};
        String[] trigSymbols = {"sin", "cos"};
        Stack<Integer> stack = new Stack<>();

        switch (this.rule) {
            case PROGRAM:
                this.children.add(new RuleNode(this, Rules.EXPR));
                break;
            case EXPR, BLOCK:
                this.children = generateExpressions(max_depth);
                break;
            case IF:
                this.children.add(new LeafNode(this, "if"));
                this.children.add(new RuleNode(this, Rules.BOOL_VALUE));
                this.children.add(new RuleNode(this, Rules.BLOCK));
                break;
            case WHILE:
                this.children.add(new LeafNode(this, "while"));
                this.children.add(new RuleNode(this, Rules.BOOL_VALUE));
                this.children.add(new RuleNode(this, Rules.BLOCK));
                break;
            case PRINT:
                this.children.add(new LeafNode(this, "print"));
                if  (random.nextInt(2) == 0)
                    this.children.add(new RuleNode(this, Rules.NUMERIC_VALUE));
                else
                    this.children.add(new RuleNode(this, Rules.BOOL_VALUE));
                break;
            case SCAN:
                this.children.add(new LeafNode(this, "scan"));
                if  (random.nextInt(2) == 0)
                    this.children.add(new LeafNode(this, numVar()));
                else
                    this.children.add(new LeafNode(this, boolVar()));
                break;
            case ASSIGN:
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
                break;
            case COMPARISON:
                this.children.add(new LeafNode(this, compSymbols[random.nextInt(6)]));
                break;
            case LOGIC:
                this.children.add(new LeafNode(this, logicSymbols[random.nextInt(2)]));
                break;
            case ARITHMETIC:
                this.children.add(new LeafNode(this, arithSymbols[random.nextInt(5)]));
                break;
            case TRIG:
                this.children.add(new LeafNode(this, trigSymbols[random.nextInt(2)]));
                break;
            case BOOL_VALUE:
                if (random.nextBoolean() && max_depth - this.depth > 3) {
                    int whichRule = random.nextInt(4);
                    if (whichRule == 0) {
                        this.children.add(new LeafNode(this, "!"));
                        this.children.add(new RuleNode(this, Rules.BOOL_VALUE));
                    }
                    else if (whichRule == 1) {
                        this.children.add(new RuleNode(this, Rules.NUMERIC_VALUE));
                        this.children.add(new RuleNode(this, Rules.COMPARISON));
                        this.children.add(new RuleNode(this, Rules.NUMERIC_VALUE));
                    }
                    else if (whichRule == 2) {
                        this.children.add(new RuleNode(this, Rules.BOOL_VALUE));
                        this.children.add(new RuleNode(this, Rules.LOGIC));
                        this.children.add(new RuleNode(this, Rules.BOOL_VALUE));
                    }
                    else
                        this.children.add(new RuleNode(this, Rules.BOOL_VALUE));
                }
                else {
                    int whichTerm = random.nextInt(3);
                    if (whichTerm == 0)
                        this.children.add(new LeafNode(this, boolVar()));
                    else if (whichTerm == 1)
                        this.children.add(new LeafNode(this, "true"));
                    else
                        this.children.add(new LeafNode(this, "false"));
                }
                break;
            case NUMERIC_VALUE:
                if (random.nextBoolean() && max_depth - this.depth > 3) {
                    int whichRule = random.nextInt(3);
                    if (whichRule == 0) {
                        this.children.add(new RuleNode(this, Rules.TRIG));
                        this.children.add(new RuleNode(this, Rules.NUMERIC_VALUE));
                    }
                    else if (whichRule == 1) {
                        this.children.add(new RuleNode(this, Rules.NUMERIC_VALUE));
                    }
                    else {
                        this.children.add(new RuleNode(this, Rules.NUMERIC_VALUE));
                        this.children.add(new LeafNode(this, arithSymbols[random.nextInt(5)]));
                        this.children.add(new RuleNode(this, Rules.NUMERIC_VALUE));
                    }
                }
                else {
                    int whichTerm = random.nextInt(2);
                    if (whichTerm == 0)
                        this.children.add(new LeafNode(this, numVar()));
                    else
                        this.children.add(new LeafNode(this, number()));
                }
                break;
        }

        for(int i = this.children.size()-1; i >= 0; i--) {
            if (this.children.get(i).rule != null) {
                stack.push(i);
            }
        }

        while (!stack.empty()) {
            int index = stack.pop();
            this.children.get(index).grow(max_depth);
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

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        Stack<Node> stack = new Stack<>();
        Rules[] numValParRules = {Rules.PRINT, Rules.NUMERIC_VALUE};
        Rules[] boolValParRules = {Rules.PRINT, Rules.BOOL_VALUE, Rules.WHILE, Rules.IF};


        for (int i = this.children.size()-1; i >= 0; i--) {
            stack.push(this.children.get(i));
        }

        while (!stack.empty()) {
            Node n = stack.pop();
            if ((n.rule == Rules.NUMERIC_VALUE && Arrays.asList(numValParRules).contains(n.parent.rule))
                    || (n.rule == Rules.BOOL_VALUE && Arrays.asList(boolValParRules).contains(n.parent.rule))
                    || (n.parent.rule == Rules.SCAN && !Objects.equals(n.toString(), "scan")))
            {
                s.append('(');
                s.append(n);
                s.append(')');
            } else if (n.rule == Rules.BLOCK) {
                s.append('{');
                s.append(n);
                s.append('}');
            } else
                s.append(n);
        }

        return s.toString();
    }

    void mutate() {
        for (Node child : this.children)
            child.mutate();
    }
}
