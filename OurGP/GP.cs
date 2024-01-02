using OurGP.Nodes;
using Fitness;
using OutInterface;

static class GP
{
    static readonly int
        POPULATION_SIZE = 100,
        MAX_GENERATIONS = 100,
        OPERATIONS_PER_GENERATION = 200,
        TOURNAMENT_SIZE = 2;
    static readonly double
        CROSSOVER_CHANCE = 0.75;

    static IOutInterface
        programOut,
        statisticsOut,
        consoleOut;

    static int seed;
    public static int Seed
    {
        get => seed;
        set
        {
            seed = value;
            rd = new Random(Seed);
        }
    }
    public static Random rd = new();

    static Individual[] population = new Individual[POPULATION_SIZE];
    public static FitnessFunction fitnessFunction;

    static GP()
    {
        Seed = (int)DateTime.UtcNow.Ticks;

        programOut = OutInterfaceFactory.CreateOutputToConsole();
        statisticsOut = OutInterfaceFactory.CreateOutputToConsole();
        consoleOut = OutInterfaceFactory.CreateOutputToConsole();
    }

    //! ---------- SETUP ----------
    static void Setup(FitnessFunction fitnessFunction, int? seed=null)
    {
        Seed = seed ?? (int)DateTime.UtcNow.Ticks;
        GP.fitnessFunction = fitnessFunction;
    }
    static void CreatePopulation(int initialDepth=5)
    {
        for (int i = 0; i < POPULATION_SIZE; i++)
            population[i] = new Individual(initialDepth);
    }
    static void SetupOutput(string? program=null, string? statistics=null)
    {
        if (program != null)
            programOut = OutInterfaceFactory.CreateOutputToFile(program);

        if (statistics != null)
            statisticsOut = OutInterfaceFactory.CreateOutputToFile(statistics);

        consoleOut = OutInterfaceFactory.CreateOutputToConsole();
    }

    //! ---------- PRINTING ----------
    static void PrintParameters()
    {
        consoleOut.PrintLine("------------------------------");
        consoleOut.PrintLine($"GP parameters:");
        consoleOut.PrintLine($"Population size: {POPULATION_SIZE}");
        consoleOut.PrintLine($"Max generations: {MAX_GENERATIONS}");
        consoleOut.PrintLine($"Operations per generation: {OPERATIONS_PER_GENERATION}");
        consoleOut.PrintLine($"Tournament size: {TOURNAMENT_SIZE}");
        consoleOut.PrintLine($"Crossover chance: {CROSSOVER_CHANCE}");
        consoleOut.PrintLine($"Seed: {Seed}");
        consoleOut.PrintLine("------------------------------\n");
    }

    static void PrintLabels()
    {
        string labels = "Generation, Best Fitness, Average Fitness, Average Size";

        statisticsOut.PrintLine(labels);
        consoleOut.PrintLine(labels);
    }

    static void PrintGeneration(int genNumber)
    {
        double bestFitness = BestIndividual.Fitness;
        double avgFitness = 0.0;
        double avgSize = 0.0;

        foreach (var individual in population)
        {
            avgFitness += individual.Fitness;
            avgSize += individual.Program.MaxDepth;
        }
        avgFitness /= POPULATION_SIZE;
        avgSize /= POPULATION_SIZE;

        string genStats = $"{genNumber}, {-bestFitness}, {-avgFitness}, {avgSize}";

        statisticsOut.PrintLine(genStats);
        consoleOut.PrintLine(genStats);
        programOut.PrintLine(BestIndividual.Program.ToString());
        programOut.PrintLine("------------------------------");
    }

    static void PrintSolution(bool foundSolution)
    {
        consoleOut.PrintLine("------------------------------");
        consoleOut.PrintLine("Solution" + (foundSolution ? " found!" : " not found!"));
        consoleOut.PrintLine($"Best individual:");
        consoleOut.PrintLine(BestIndividual.Program);
    }


    //! ---------- TOURNAMENTS ----------
    public static int TournamentSelection(int tournamentSize=2)
    {
        int bestIndex = rd.Next(POPULATION_SIZE);
        for (int i = 1; i < tournamentSize; i++)
        {
            int index = rd.Next(POPULATION_SIZE);
            if (population[index].Fitness > population[bestIndex].Fitness)
                bestIndex = index;
        }
        return bestIndex;
    }

    public static int NegativeTournamentSelection(int tournamentSize=2)
    {
        int worstIndex = rd.Next(POPULATION_SIZE);
        for (int i = 1; i < tournamentSize; i++)
        {
            int index = rd.Next(POPULATION_SIZE);
            if (population[index].Fitness < population[worstIndex].Fitness)
                worstIndex = index;
        }
        return worstIndex;
    }

    public static Individual BestIndividual
    {
        get
        {
            var best = population[0];
            foreach (var individual in population)
            {
                if (individual.Fitness < best.Fitness)
                    best = individual;
            }
            return best;
        }
    }


    //! ---------- EVOLUTION ----------
    public static void Run()
    {
        PrintParameters();
        PrintLabels();
        PrintGeneration(0);

        bool foundSolution = false;
        for (int gen = 1; gen <= MAX_GENERATIONS && !foundSolution; gen++)
        {
            EvolveGeneration();
            PrintGeneration(gen);

            if (-BestIndividual.Fitness < 1e-3)
                foundSolution = true;
        }

        PrintSolution(foundSolution);
    }

    static void EvolveGeneration()
    {
        for (int i = 0; i < OPERATIONS_PER_GENERATION; i++)
        {
            if (rd.NextDouble() < CROSSOVER_CHANCE)
            {
                var parent1 = population[TournamentSelection(TOURNAMENT_SIZE)];
                var parent2 = population[TournamentSelection(TOURNAMENT_SIZE)];
                var (child1, child2) = Program.Crossover(parent1.Program, parent2.Program);

                population[NegativeTournamentSelection()] = new Individual(child1);
                population[NegativeTournamentSelection()] = new Individual(child2);
            }
            else
            {
                var parent = population[TournamentSelection(TOURNAMENT_SIZE)];

                var child = parent.Program.DeepCopy();
                child.Mutate();

                population[NegativeTournamentSelection()] = new Individual(child);
            }
        }
    }


    //! ---------- MAIN ----------
    static void Main(string[] args)
    {
        string folder = "./data/";

        Setup(new FitnessFunction(folder + "data.txt", true));
        SetupOutput(folder + "program.txt", folder + "statistics.csv");
        CreatePopulation();

        Run();
    }
}
