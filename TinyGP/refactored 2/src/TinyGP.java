import java.util.Random;


public class TinyGP {
    private Program[] population;

    public static Function function;
    public static double[] constants;

    public static Random rd;
    public long seed;

    public static OutInterface
        programOut,
        statisticsOut,
        consoleOut;

    static final class Const {
        public static final int
            GENERATIONS = 100,
            POPULATION_SIZE = 100_000,
            TOURNAMENT_SIZE = 2;

        public static final double
            CROSSOVER_CHANCE = 0.9;
    }
    

    //! ---------- CONSTRUCTORS ----------
    public TinyGP(Function function) {
        this(function, System.currentTimeMillis());
    }
    public TinyGP(Function function, long seed) {
        TinyGP.function = function;
        rd = new Random(seed);
        this.seed = seed;
        setupTerminals();
        setupPopulation();
    }


    //! ---------- SETUP ----------
    public void setupPopulation() {
        population = new Program[Const.POPULATION_SIZE];
        for (int i = 0; i < Const.POPULATION_SIZE; i++) {
            population[i] = new Program();
        }
    }
    public void setupTerminals() {
        constants = new double[function.constantsNumber + function.variableNumber];

        for (int i = 0; i < function.constantsNumber + function.variableNumber; i++)
            constants[i] = (function.randomMax - function.randomMin) * TinyGP.rd.nextDouble() + function.randomMin;
    }
    public static void setupOutput(OutInterface programOut,
                                   OutInterface statisticOut,
                                   OutInterface consoleOut) {
        TinyGP.programOut = programOut;
        TinyGP.statisticsOut = statisticOut;
        TinyGP.consoleOut = consoleOut;
    }

    
    //! ---------- PRINTING ----------
    public void printParameters() {
        var sb = new StringBuilder();
        sb.append("\nTinyGP (Java version)");
        sb.append("\nSeed: " + seed);
        sb.append("\nMAX_LEN: " + Program.Const.MAX_LEN);
        sb.append("\nPOPULATION_SIZE: " + Const.POPULATION_SIZE);
        sb.append("\nDEPTH: " + Program.Const.DEPTH);
        sb.append("\nCROSSOVER_CHANCE: " + Const.CROSSOVER_CHANCE);
        sb.append("\nMUTATION_CHANCE: " + Program.Const.MUTATION_CHANCE);
        sb.append("\nRANDOM_RANGE: [" + String.format("%.2f", function.randomMin) + "; " +  String.format("%.2f", function.randomMax) + "]");
        sb.append("\nGENERATIONS: " + Const.GENERATIONS);
        sb.append("\nTOURNAMENT_SIZE: " + Const.TOURNAMENT_SIZE);
        sb.append("\n------------------------------\n");

        TinyGP.consoleOut.println(sb.toString());
    }

    private void printGeneration(int generation) {
        double bestFitness = Double.NEGATIVE_INFINITY;
        double avgFitness = 0.0;
        double avgSize = 0.0;
        double currentFitness = 0.0;
        Program bestProgram = null;

        for (var program : population) {
            currentFitness = program.getFitness();
            
            if (currentFitness > bestFitness) {
                bestProgram = program;
                bestFitness = currentFitness;
            }
            avgFitness += currentFitness;
            avgSize += program.length();
        }
        avgFitness /= population.length;
        avgSize /= population.length;

        TinyGP.programOut.println(bestProgram);
        TinyGP.statisticsOut.println(generation + ", " + -avgFitness + ", " + -bestFitness + ", " + avgSize);
        TinyGP.consoleOut.println(generation + ",\t\t" + -bestFitness + ",\t" + bestProgram.length());
    }


    //! ---------- TOURNAMENT ----------
    private Program tournament() {
        int best = 0, competitor = 0;
        double bestFitness = -1e34;

        for (int i = 0; i < Const.TOURNAMENT_SIZE; i++) {
            competitor = rd.nextInt(population.length);
            if (population[competitor].getFitness() > bestFitness) {
                best = competitor;
                bestFitness = population[best].getFitness();
            }
        }

        return population[best];
    }
    private int negativeTournamentIndex() {
        int worst = 0, competitor = 0;
        double worstFitness = 1e34;

        for (int i = 0; i < Const.TOURNAMENT_SIZE; i++) {
            competitor = rd.nextInt(population.length);
            if (population[competitor].getFitness() < worstFitness) {
                worst = competitor;
                worstFitness = population[worst].getFitness();
            }
        }

        return worst;
    }


    //! ---------- EVOLUTION ----------
    public void run() {
        printParameters();
        TinyGP.statisticsOut.println("Generation, Avg Fitness, Best Fitness, Avg Size");
        TinyGP.consoleOut.println("Generation, \tBest fitness, \t\tsize");
        printGeneration(0);

        for (int gen = 1; gen <= Const.GENERATIONS; gen++) {
            evolve();
            printGeneration(gen);
        }
    }
    public void evolve() {
        Program parent1, parent2, indiv;

        for (int i = 0; i < Const.POPULATION_SIZE; i++) {
            if (rd.nextDouble() < Const.CROSSOVER_CHANCE) {
                parent1 = tournament();
                parent2 = tournament();
                indiv = Program.crossover(parent1, parent2);
            } else {
                parent1 = tournament();
                indiv = Program.mutation(parent1);
            }

            population[negativeTournamentIndex()] = indiv;
        }
    }


    //! ---------- MAIN ----------
    public static void main(String[] args) {
        Function function = new Function("", "./data", "f1_0");
        TinyGP tinyGP = new TinyGP(function);
        
        tinyGP.run();
    }
}
