import java.io.BufferedWriter;
import java.io.IOException;

public class OutputGP {
    static BufferedWriter writer_stats;
    static BufferedWriter writer_programs;

    /**
     * <h1>Print parameters</h1>
     * Prints the parameters of the current run
     */
    static void print_parms() throws IOException {
        System.out.print("-- TINY GP (Java version) --\n");
        System.out.print("SEED="+ TinyGP.seed +"\nMAX_LEN="+ TinyGP.MAX_LEN +
                "\nPOPULATION_SIZE="+ TinyGP.POPULATION_SIZE +"\nDEPTH="+ TinyGP.DEPTH +
                "\nCROSSOVER_PROB="+ TinyGP.CROSSOVER_PROB +
                "\nPMUT_PER_NODE="+ TinyGP.PMUT_PER_NODE +
                "\nMIN_RANDOM="+ TinyGP.minRandom +
                "\nMAX_RANDOM="+ TinyGP.maxRandom +
                "\nGENERATIONS="+ TinyGP.GENERATIONS +
                "\nT_SIZE="+ TinyGP.T_SIZE +
                "\n----------------------------------\n");
    }

    /**
     * <h1>Stats</h1>
     * Prints statistics about the current generation
     * @param gen - current generation
     */
    static void stats(double[] fitness, char[][] population, int gen) throws IOException {
        int i, best = TinyGP.rd.nextInt(TinyGP.POPULATION_SIZE);
        int nodeCount = 0;
        TinyGP.fitnessBestPopulation = fitness[best];
        TinyGP.fitnessAvgPopulation = 0.0;

        for (i = 0; i < TinyGP.POPULATION_SIZE; i ++ ) {
            nodeCount +=  TinyGP.traverse( population[i], 0 );
            TinyGP.fitnessAvgPopulation += fitness[i];
            if ( fitness[i] > TinyGP.fitnessBestPopulation) {
                best = i;
                TinyGP.fitnessBestPopulation = fitness[i];
            }
        }
        TinyGP.avgLength = (double) nodeCount / TinyGP.POPULATION_SIZE;
        TinyGP.fitnessAvgPopulation /= TinyGP.POPULATION_SIZE;

        writer_stats.write(gen+", "+(-TinyGP.fitnessAvgPopulation)+
                ", "+(-TinyGP.fitnessBestPopulation)+", "+TinyGP.avgLength+"\n");
        writer_stats.flush();

        System.out.print("Generation="+gen+" Avg Fitness="+(-TinyGP.fitnessAvgPopulation)+
                " Best Fitness="+(-TinyGP.fitnessBestPopulation)+" Avg Size="+ TinyGP.avgLength +
                "\nBest Individual: ");
        printIndividual( population[best], 0 );
        OutputGP.writer_programs.write("\n");
        OutputGP.writer_programs.flush();
        System.out.print( "\n");
        System.out.flush();
    }

    /**
     * <h1>Print individual</h1>
     * Prints the individual in a readable format
     */
    static int printIndividual(char[] buffer, int bufferCounter) throws IOException {
        int a1 = 0, a2;
        if ( buffer[bufferCounter] < TinyGP.FSET_START) {
            if ( buffer[bufferCounter] < TinyGP.varNumber) {
                System.out.print( "X"+ (buffer[bufferCounter] + 1 )+ " ");
                writer_programs.write("X"+ (buffer[bufferCounter] + 1 )+ " ");
            }
            else {
                System.out.print( TinyGP.x[buffer[bufferCounter]]);
                writer_programs.write(Double.toString(TinyGP.x[buffer[bufferCounter]]));
            }
            return( ++bufferCounter );
        }
        switch(buffer[bufferCounter]) {
            case TinyGP.ADD: System.out.print("(");
                writer_programs.write("(");
                a1 = printIndividual( buffer, ++bufferCounter );
                System.out.print(" + ");
                writer_programs.write(" + ");
                break;
            case TinyGP.SUB: System.out.print("(");
                writer_programs.write("(");
                a1 = printIndividual( buffer, ++bufferCounter );
                System.out.print(" - ");
                writer_programs.write(" - ");
                break;
            case TinyGP.MUL: System.out.print("(");
                writer_programs.write("(");
                a1 = printIndividual( buffer, ++bufferCounter );
                System.out.print(" * ");
                writer_programs.write(" * ");
                break;
            case TinyGP.DIV: System.out.print("(");
                writer_programs.write("(");
                a1 = printIndividual( buffer, ++bufferCounter );
                System.out.print(" / ");
                writer_programs.write(" / ");
                break;
            case TinyGP.SIN: System.out.print("sin(");
                writer_programs.write("sin(");
                a1 = printIndividual( buffer, ++bufferCounter);
                System.out.print(")");
                writer_programs.write(")");
                return(a1);
            case TinyGP.COS: System.out.print("cos(");
                writer_programs.write("cos(");
                a1 = printIndividual( buffer, ++bufferCounter);
                System.out.print(")");
                writer_programs.write(")");
                return(a1);
        }
        a2 = printIndividual( buffer, a1);
        System.out.print(")");
        writer_programs.write(")");
        return(a2);
    }
}
