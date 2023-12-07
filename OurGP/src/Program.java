import java.util.*;

public class Program {
    RuleNode root;
    Random rd = new Random();

    //! ---------- CONSTRUCTORS ----------
    /**
     * <h1>Generates a random program.</h1>
     * Max depth of this program is defined by int parameter in grow method.
     * Default max depth is 5.
     */
    public Program() {
        root = new RuleNode(null, Rules.PROGRAM, 0);
        root.grow(5);
    }
    /**
     * <h1>Generates a random program.</h1>
     * Max depth of this program is defined by int parameter in grow method.
     * @param max_depth max depth of this program
     */
    public Program(int max_depth) {
        root = new RuleNode(null, Rules.PROGRAM, 0);
        root.grow(max_depth);
    }

    public Program(Program program) {
        root = (RuleNode) program.root.copy();
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        Stack<Node> stack = new Stack<>();
        Rules[] numValParRules = {Rules.PRINT, Rules.NUMERIC_VALUE};
        Rules[] boolValParRules = {Rules.PRINT, Rules.BOOL_VALUE, Rules.WHILE, Rules.IF};

        for(int i = root.children.size()-1; i >= 0; i--) {
            stack.push(root.children.get(i));
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

    //! ---------- GENETIC OPERATORS ----------
    public Program crossover(Program parent1, Program parent2) {
        Program offspring = new Program(parent1);
        
        Node crossoverNode1 = offspring.root.getNode(rd.nextInt(offspring.root.length()-1)+1);
        // System.out.println("\tcrossover node1: " + crossoverNode1);
        if (crossoverNode1 == null)
            return offspring;
        
        List<Node> potentialCrossoverNodes = parent2.root.getNodes(crossoverNode1.rule.getDependency());
        // System.out.println("\tpotential crossover nodes: ");
        // for (var potentialCrossoverNode : potentialCrossoverNodes)
        //     System.out.println("\t\t" + potentialCrossoverNode);

        if (potentialCrossoverNodes.size() == 0)
            return offspring;
        
        Node crossoverNode2 = potentialCrossoverNodes.get(rd.nextInt(potentialCrossoverNodes.size()));
        // System.out.println("\tcrossover node2: " + crossoverNode2);

        swapSubTrees(crossoverNode1, crossoverNode2);

        return offspring;
    }

    public Program mutation(Program parent) {
        Program offspring = new Program(parent);
        offspring.root.mutate();

        return offspring;
    }

    //! ---------- HELPER METHODS ----------
    private void swapSubTrees(Node node1, Node node2) {
        Node parent1 = node1.parent;
        Node parent2 = node2.parent;

        int index1 = parent1.children.indexOf(node1);
        int index2 = parent2.children.indexOf(node2);

        parent1.children.set(index1, node2);
        parent2.children.set(index2, node1);

        node1.parent = parent2;
        node2.parent = parent1;
    }

    public static void main(String[] args) {
        Program p1 = new Program(5);
        Program p2 = new Program(5);
        System.out.println(p1);
        System.out.println(p2);

        Program p3 = p1.crossover(p1, p2);
        System.out.println(p3);

        Program p4 = p3.mutation(p1);
        System.out.println(p4);
    }
}
