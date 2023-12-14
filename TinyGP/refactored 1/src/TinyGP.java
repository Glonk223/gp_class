/*
 * Program:   TinyGP.java
 *
 * Author:    Riccardo Poli (email: rpoli@essex.ac.uk)
 *
 */

import java.io.*;
import java.util.Random;
import java.util.StringTokenizer;
import java.lang.Math;

public class TinyGP {
    double [] fitness;
    char [][] population;
    static Random rd = new Random();
    static final int ADD = 110, SUB = 111, MUL = 112, DIV = 113, SIN = 114, COS = 115, FSET_START = ADD, FSET_END = COS,
            MAX_LEN = 10000, POPULATION_SIZE = 25000, DEPTH = 5, GENERATIONS = 100, T_SIZE = 2;
    static double [] x = new double[FSET_START];
    static double minRandom, maxRandom, avgLength;
    static char [] program;
    static int varNumber, fitnessCases, randomNumber, pc;
    static double fitnessBestPopulation = 0.0, fitnessAvgPopulation = 0.0;
    static long seed;
    public static final double PMUT_PER_NODE  = 0.05, CROSSOVER_PROB = 0.9;
    static double [][] targets;
    static char [] buffer = new char[MAX_LEN];

    // ---------------------------------------------------

    /**
     * <h1>Run the program</h1>
     * Runs program in order to evaluate it's value for given input
     *
     * @return value of the program
     */
    static double run() { /* Interpreter */
        char primitive = program[pc++];
        if ( primitive < FSET_START )
            return(x[primitive]);
        switch ( primitive ) {
            case ADD :
                return(run() + run());
            case SUB :
                return(run() - run());
            case MUL :
                return(run() * run());
            case DIV : {
                double num = run(), den = run();
                if ( Math.abs( den ) <= 0.001 )
                    return(num);
                else
                    return(num / den);
            }
            case SIN :
                return(Math.sin(run()));
            case COS :
                return(Math.cos(run()));
        }
        return(0.0); // should never get here
    }

    /**
     * <h1>Traverse</h1>
     * Calculates the length of the program
     *
     * @return length of the program
     */
    static int traverse(char[] buffer, int bufferCount) {
        if ( buffer[bufferCount] < FSET_START )
            return( ++bufferCount );

        return switch (buffer[bufferCount]) {
            case ADD, SUB, MUL, DIV, SIN, COS -> (traverse(buffer, traverse(buffer, ++bufferCount)));
            default -> (0);
        };
    }

    /**
     * <h1>Setup fitness function</h1>
     * Parses the data file and sets up the fitness function
     * Initializes the targets array and TinyGP parameters
     * <ul>
     * <li>varnumber - number of variables</li>
     * <li>randomnumber - number of constants</li>
     * <li>minrandom - minimum value of constants</li>
     * <li>maxrandom - maximum value of constants</li>
     * <li>inst_num - number of instances</li>
     * </ul>
     *
     * @param filename - name of the file with data
     */
    void setupFitness(String filename) throws IOException {
        try {
            int i, j;
            String line;

            BufferedReader in = new BufferedReader(new FileReader(filename));
            line = in.readLine();
            StringTokenizer tokens = new StringTokenizer(line);
            varNumber = Integer.parseInt(tokens.nextToken().trim());
            randomNumber = Integer.parseInt(tokens.nextToken().trim());
            minRandom =	Double.parseDouble(tokens.nextToken().trim());
            maxRandom =  Double.parseDouble(tokens.nextToken().trim());
            fitnessCases = Integer.parseInt(tokens.nextToken().trim());
            targets = new double[fitnessCases][varNumber+1];
            if (varNumber + randomNumber >= FSET_START ) {
                System.out.println("too many variables and constants");
                OutputGP.writer_stats.write("too many variables and constants");
            }

            for (i = 0; i < fitnessCases; i ++ ) {
                line = in.readLine();
                tokens = new StringTokenizer(line);
                for (j = 0; j <= varNumber; j++) {
                    targets[i][j] = Double.parseDouble(tokens.nextToken().trim());
                }
            }
            in.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("ERROR: Please provide a data file");
            OutputGP.writer_stats.write("ERROR: Please provide a data file");
            System.exit(0);
        }
        catch(Exception e ) {
            System.out.println("ERROR: Incorrect data format");
            OutputGP.writer_stats.write("ERROR: Incorrect data format");
            System.exit(0);
        }
    }

    /**
     * <h1>Fitness function</h1>
     *
     * @param prog - program to be evaluated
     * @return fitness value, higher is better (negative values)
     */
    static double fitnessFunction(char[] prog) {
        double result, fit = 0.0;

        traverse(prog, 0);
        for (int i = 0; i < fitnessCases; i ++ ) {
            if (varNumber >= 0) System.arraycopy(targets[i], 0, x, 0, varNumber);
            program = prog;
            pc = 0;
            result = run();
            fit += Math.abs( result - targets[i][varNumber]);
        }
        return(-fit);
    }

    /**
     * <h1>Grow</h1>
     * Helper for create_random_indiv
     */
    int grow( char [] buffer, int pos,  int depth ) {
        char prim = (char) rd.nextInt(2);
        int oneChild;

        if ( pos >= MAX_LEN )
            return(-1);

        if ( pos == 0 )
            prim = 1;

        if ( prim == 0 || depth == 0 ) {
            prim = (char) rd.nextInt(varNumber + randomNumber);
            buffer[pos] = prim;
            return(pos+1);
        }
        else  {
            prim = (char) (rd.nextInt(FSET_END - FSET_START + 1) + FSET_START);
            switch(prim) {
                case ADD:
                case SUB:
                case MUL:
                case DIV:
                case SIN:
                case COS:
                    buffer[pos] = prim;
                    oneChild = grow( buffer, pos+1, depth-1);
                    if ( oneChild < 0 )
                        return(-1);
                    return(grow( buffer, oneChild, depth-1));
            }
        }
        return(0); // should never get here
    }

    /**
     * <h1>Create random individual</h1>
     * Creates a random individual
     *
     * @return random individual as char array
     */
    char [] createRandomIndividual() {
        char [] ind;
        int len;

        len = grow( buffer, 0, TinyGP.DEPTH);

        while (len < 0 )
            len = grow( buffer, 0, TinyGP.DEPTH);

        ind = new char[len];

        System.arraycopy(buffer, 0, ind, 0, len);
        return( ind );
    }

    /**
     * <h1>Create random population</h1>
     * Creates population of random individuals
     *
     * @return population as array of char arrays
     */
    char [][] createRandomPopulation(double [] fitness ) {
        char [][]population = new char[TinyGP.POPULATION_SIZE][];
        int i;

        for (i = 0; i < TinyGP.POPULATION_SIZE; i ++ ) {
            population[i] = createRandomIndividual();
            fitness[i] = fitnessFunction( population[i] );
        }
        return( population );
    }

    public TinyGP(String filename, long s ) throws IOException {
        fitness =  new double[POPULATION_SIZE];
        seed = s;
        if ( seed >= 0 )
            rd.setSeed(seed);
        setupFitness(filename);
        for ( int i = 0; i < FSET_START; i ++ )
            x[i]= (maxRandom-minRandom)*rd.nextDouble()+minRandom;
        population = createRandomPopulation(fitness );
    }

    public static void main(String[] args) throws IOException {
        String filename = "./src/f1.dat";
        long s = -1;
        String path = "./data/";
        File dir = new File("./data/");
        File[] directiorListing = dir.listFiles();
        if (directiorListing != null) {
            for (File child: directiorListing){
                TinyGP gp = new TinyGP(path+child.getName(), s);
                OutputGP.writer_programs = new BufferedWriter(new FileWriter("./data/output/out_"+child.getName()));
                OutputGP.writer_stats = new BufferedWriter(new FileWriter("./data/output/stats_"+child.getName()));
                EvolutionGP.evolve(gp);
            }
        }

//        TinyGP gp = new TinyGP(filename, s);
//        EvolutionGP.evolve(gp);

        if ( args.length == 2 ) {
            s = Integer.parseInt(args[0]);
            filename = args[1];
        }
        if ( args.length == 1 ) {
            filename = args[0];
        }

        System.exit(0);
    }
}
