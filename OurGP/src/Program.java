import java.util.HashMap;
import java.util.Map;


public class Program {
    private char[] program;
    private double fitness = Double.POSITIVE_INFINITY;
    private static Function function = TinyGP.function;

    static final class NonTerm {
        public static final int
                ADD = 110,
                SUB = 111,
                MUL = 112,
                DIV = 113,
                SIN = 114,
                COS = 115;

        public static final Map<Character, String> str = new HashMap<>();
        static {
            str.put((char)ADD, " + ");
            str.put((char)SUB, " - ");
            str.put((char)MUL, " * ");
            str.put((char)DIV, " / ");
            str.put((char)SIN, "sin");
            str.put((char)COS, "cos");
        }
    }
    static final class Const {
        public static final int
                FSET_START = NonTerm.ADD,
                FSET_END = NonTerm.COS,
                MAX_LEN = 10000,
                DEPTH = 5;

        public static final double
                MUTATION_CHANCE  = 0.05;
    }

    //! ---------- CONSTRUCTORS ----------
    /**
     * <h1>Constructors</h1>
     * Creates a random individual
     */
    public Program() {
        this(createRandomIndividual());
    }
    private Program(char[] program) {
        this.program = program;
    }


    //! ---------- PROGRAM CREATION ----------
    /**
     * <h1>Create random individual</h1>
     * Creates a random individual
     *
     * @return random individual as char array
     */
    private static char[] createRandomIndividual() {
        char[] buffer = new char[Const.MAX_LEN];
        int len;

        do {
            len = grow(buffer);
        } while (len < 0);

        char[] individual = new char[len];
        System.arraycopy(buffer, 0, individual, 0, len);

        return individual;
    }

    /**
     * <h1>Grow</h1>
     * Helper for createRandomIndividual
     *
     * @param buffer - buffer to be filled with random individual
     * @return next position in the buffer aka length of the individual
     */
    private static int grow(char[] buffer) {
        return grow(buffer, 0, Const.DEPTH);
    }
    private static int grow(char[] buffer, int index, int depth) {
        // out of range, program too long
        if (index >= Const.MAX_LEN)
            return -1;

        if (index != 0 && (depth == 0 || TinyGP.rd.nextInt(2) == 0)) {
            buffer[index] = getRandomTerminal();
            return index+1;
        } else {
            buffer[index] = getRandomNonTerminal();
            int oneChild = grow(buffer, index+1, depth-1);
            if (oneChild < 0)
                return -1;

            if (isAritmetic(buffer[index]))
                return grow(buffer, oneChild, depth-1);
            else // isTrigonometric
                return oneChild;
        }
    }

    private static char getRandomTerminal() {
        return (char) TinyGP.rd.nextInt(function.variableNumber + function.constantsNumber);
    }
    private static char getRandomNonTerminal() {
        return (char) (TinyGP.rd.nextInt(Const.FSET_END - Const.FSET_START + 1) + Const.FSET_START);
    }
    private static char getRandomAritmetic() {
        return (char) (TinyGP.rd.nextInt(NonTerm.DIV - NonTerm.ADD + 1) + NonTerm.ADD);
    }
    private static char getRandomTrigonometric() {
        return (char) (TinyGP.rd.nextInt(NonTerm.COS - NonTerm.SIN + 1) + NonTerm.SIN);
    }


    //! ---------- GENETIC OPERATORS ----------
    /**
     * <h1>Crossover</h1>
     * Performs crossover on two individuals
     *
     * @return offspring as char array
     */
    public static Program crossover(Program parent1, Program parent2) {
        int len1 = parent1.length(0);
        int len2 = parent2.length(0);

        int xo1start = TinyGP.rd.nextInt(len1);
        int xo1end = parent1.length(xo1start);

        int xo2start = TinyGP.rd.nextInt(len2);
        int xo2end = parent2.length(xo2start);

        int lenoff = xo1start + (xo2end-xo2start) + (len1-xo1end);

        char[] offspring = new char[lenoff];

        System.arraycopy(parent1.program, 0,
                offspring, 0,
                xo1start);

        System.arraycopy(parent2.program, xo2start,
                offspring, xo1start,
                (xo2end - xo2start));

        System.arraycopy(parent1.program, xo1end,
                offspring, xo1start + (xo2end-xo2start),
                (len1 - xo1end));

        return new Program(offspring);
    }

    /**
     * <h1>Mutation</h1>
     * Performs mutation on an individual
     *
     * @return mutated individual as char array
     */
    public static Program mutation(Program parent) {
        int len = parent.length(0);
        char[] mutant = new char[len];

        System.arraycopy(parent.program, 0, mutant, 0, len);
        for (int i = 0; i < len; i++) {
            if (TinyGP.rd.nextDouble() < Const.MUTATION_CHANCE) {
                if (isTerminal(mutant[i]))
                    mutant[i] = getRandomTerminal();
                else if (isAritmetic(mutant[i]))
                    mutant[i] = getRandomAritmetic();
                else // isTrigonometric
                    mutant[i] = getRandomTrigonometric();
            }
        }
        return new Program(mutant);
    }

    private static boolean isTerminal(char c) {
        return c < Const.FSET_START;
    }
    private static boolean isVariable(char c) {
        return c < function.variableNumber;
    }
    private static boolean isConstant(char c) {
        return isTerminal(c) && !isVariable(c);
    }
    private static boolean isNonTerminal(char c) {
        return c >= Const.FSET_START && c <= Const.FSET_END;
    }
    private static boolean isAritmetic(char c) {
        return c >= NonTerm.ADD && c <= NonTerm.DIV;
    }
    private static boolean isTrigonometric(char c) {
        return c >= NonTerm.SIN && c <= NonTerm.COS;
    }


    //! ---------- TRAVERSAL AND EVALUATION ----------
    /**
     * <h1>Traverse</h1>
     * Calculates the length of the program starting at the given position
     *
     * @return length of the program starting at the given position
     */
    public int length() { return length(0); }
    private int length(int bufferPos) {
        char primitive = program[bufferPos];

        if (isTerminal(primitive))
            return ++bufferPos;

        if (isAritmetic(primitive))
            return length(length(++bufferPos));

        if (isTrigonometric(primitive))
            return length(++bufferPos);

        return -1;
    }

    private int recurencyIndex;
    private double[] args;
    /**
     * <h1>Evaluate the program</h1>
     * Runs program in order to evaluate it's value for given input
     *
     * @return value of the program
     */
    public double evaluate(double[] args) {
        this.recurencyIndex = 0;
        this.args = args;
        return run();
    }
    private double run() {
        char primitive = program[recurencyIndex++];


        if (isConstant(primitive))
            return TinyGP.constants[primitive];
        if (isVariable(primitive))
            return args[primitive];

        switch (primitive) {
            case NonTerm.ADD:
                return run() + run();
            case NonTerm.SUB:
                return run() - run();
            case NonTerm.MUL:
                return run() * run();
            case NonTerm.DIV:
                double num = run(), den = run();
                return (Math.abs(den) <= 0.001) ? num : (num / den);
            case NonTerm.SIN:
                return Math.sin(run());
            case NonTerm.COS:
                return Math.cos(run());

            default:
                return Double.POSITIVE_INFINITY;
        }
    }


    //! ---------- FITNESS ----------
    /**
     * <h1>Calculate fitness</h1>
     * Calculates the fitness of the program
     *
     * @return fitness of the program
     */
    private double calculateFitness() {
        double fit = 0.0;

        for (double[] target : function.targets)
            fit -= Math.abs(evaluate(target) - target[target.length-1]);

        this.fitness = fit;
        return this.fitness;
    }
    public double getFitness() {
        if (fitness > 0.0)
            return calculateFitness();
        return fitness;
    }


    //! ---------- PRINTING ----------
    public String toString() {
        recurencyIndex = 0;
        return _toString();
    }
    public String _toString() {
        char primitive = program[recurencyIndex++];

        if (isVariable(primitive))
            return "X" + (int)primitive;
        if (isConstant(primitive))
            return Double.toString(TinyGP.constants[primitive]);

        if (isAritmetic(primitive))
            return "(" + _toString() + NonTerm.str.get(primitive) + _toString() + ")";
        if (isTrigonometric(primitive))
            return NonTerm.str.get(primitive) + "(" + _toString() + ")";

        return "";
    }

    private static String toString(char primitive) {
        if (isVariable(primitive))
            return " X" + (int)primitive;
        if (isConstant(primitive))
            return " C" + (int)primitive;

        if (isNonTerminal(primitive))
            return NonTerm.str.get(primitive);

        return "";
    }
}

