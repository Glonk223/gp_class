import java.util.List;
import java.util.Random;

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
        root = new RuleNode(null, Rules.PROGRAM);
        root.grow(5);
    }
    /**
     * <h1>Generates a random program.</h1>
     * Max depth of this program is defined by int parameter in grow method.
     * @param max_depth max depth of this program
     */
    public Program(int max_depth) {
        root = new RuleNode(null, Rules.PROGRAM);
        root.grow(max_depth);
    }

    public Program(Program program) {
        root = (RuleNode) program.root.copy();
    }


    //! ---------- GENETIC OPERATORS ----------
    public Program crossover(Program parent1, Program parent2) {
        Program offspring = new Program(parent1);
        
        Node crossoverNode1 = offspring.root.getNode(rd.nextInt(offspring.root.length()));
        if (crossoverNode1 == null)
            return offspring;
        
        List<Node> potentialCrossoverNodes = parent2.root.getNodes(crossoverNode1.rule.getDependency());

        if (potentialCrossoverNodes.size() == 0)
            return offspring;
        
        Node crossoverNode2 = potentialCrossoverNodes.get(rd.nextInt(potentialCrossoverNodes.size()));

        crossoverNode1 = crossoverNode2.copy(crossoverNode1.parent);

        return offspring;
    }

    public Program mutation(Program parent) {
        Program offspring = new Program(parent);
        offspring.root.mutate();

        return offspring;
    }
}
