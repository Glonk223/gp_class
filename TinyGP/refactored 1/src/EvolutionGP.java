import java.io.IOException;

public class EvolutionGP {

    /**
     * <h1>Mutation</h1>
     * Performs mutation on an individual
     *
     * @return mutated individual as char array
     */
    static char [] mutation(char[] parent) {
        int len = TinyGP.traverse( parent, 0 ), i;
        int mutSite;
        char [] parentCopy = new char [len];

        System.arraycopy( parent, 0, parentCopy, 0, len );
        for (i = 0; i < len; i ++ ) {
            if ( TinyGP.rd.nextDouble() < TinyGP.PMUT_PER_NODE) {
                mutSite =  i;
                if ( parentCopy[mutSite] < TinyGP.FSET_START )
                    parentCopy[mutSite] = (char) TinyGP.rd.nextInt(TinyGP.varNumber+TinyGP.randomNumber);
                else
                    switch(parentCopy[mutSite]) {
                        case TinyGP.ADD:
                        case TinyGP.SUB:
                        case TinyGP.MUL:
                        case TinyGP.DIV:
                        case TinyGP.SIN:
                        case TinyGP.COS:
                            parentCopy[mutSite] =
                                    (char) (TinyGP.rd.nextInt(TinyGP.FSET_END - TinyGP.FSET_START + 1)
                                            + TinyGP.FSET_START);
                    }
            }
        }
        return( parentCopy );
    }

    static void evolve(TinyGP gp) throws IOException {
        int indivs, offspring, parent1, parent2, parent;
        double newFitness;
        char [] newIndividual;
        OutputGP.print_parms();
        OutputGP.stats(gp.fitness, gp.population, 0 );
        for (int gen = 1; gen < TinyGP.GENERATIONS; gen ++ ) {
            if (  TinyGP.fitnessBestPopulation > -1e-5 ) {
                System.out.print("PROBLEM SOLVED\n");
//                writer.write("PROBLEM SOLVED\n");
//                System.exit( 0 );
            }
            for ( indivs = 0; indivs < TinyGP.POPULATION_SIZE; indivs ++ ) {
                if ( TinyGP.rd.nextDouble() < TinyGP.CROSSOVER_PROB  ) {
                    parent1 = tournament( gp.fitness);
                    parent2 = tournament( gp.fitness);
                    newIndividual = crossover( gp.population[parent1],gp.population[parent2] );
                }
                else {
                    parent = tournament( gp.fitness);
                    newIndividual = mutation( gp.population[parent]);
                }
                newFitness = TinyGP.fitnessFunction( newIndividual );
                offspring = negativeTournament( gp.fitness);
                gp.population[offspring] = newIndividual;
                gp.fitness[offspring] = newFitness;
            }
            OutputGP.stats(gp.fitness, gp.population, gen );
        }
        System.out.print("PROBLEM *NOT* SOLVED\n");
//        writer.write("PROBLEM *NOT* SOLVED\n");
//        System.exit( 1 );
    }

    /**
     * <h1>Crossover</h1>
     * Performs crossover on two individuals
     *
     * @return offspring as char array
     */
    static char [] crossover(char[] parent1, char[] parent2) {
        int xo1start, xo1end, xo2start, xo2end;
        char [] offspring;
        int len1 = TinyGP.traverse( parent1, 0 );
        int len2 = TinyGP.traverse( parent2, 0 );
        int lenoff;

        xo1start =  TinyGP.rd.nextInt(len1);
        xo1end = TinyGP.traverse( parent1, xo1start );

        xo2start =  TinyGP.rd.nextInt(len2);
        xo2end = TinyGP.traverse( parent2, xo2start );

        lenoff = xo1start + (xo2end - xo2start) + (len1-xo1end);

        offspring = new char[lenoff];

        System.arraycopy( parent1, 0, offspring, 0, xo1start );
        System.arraycopy( parent2, xo2start, offspring, xo1start,
                (xo2end - xo2start) );
        System.arraycopy( parent1, xo1end, offspring,
                xo1start + (xo2end - xo2start),
                (len1-xo1end) );

        return( offspring );
    }

    /**
     * <h1>Negative tournament</h1>
     * Selects the worst individual from a random subset of the population
     * @return index of found individual
     */
    static int negativeTournament(double[] fitness) {
        int worst = TinyGP.rd.nextInt(TinyGP.POPULATION_SIZE), i, competitor;
        double fworst = 1e34;

        for (i = 0; i < TinyGP.T_SIZE; i ++ ) {
            competitor = TinyGP.rd.nextInt(TinyGP.POPULATION_SIZE);
            if ( fitness[competitor] < fworst ) {
                fworst = fitness[competitor];
                worst = competitor;
            }
        }
        return( worst );
    }

    /**
     * <h1>Tournament</h1>
     * Selects the best individual from a random subset of the population
     * @return index of found individual
     */
    static int tournament(double[] fitness) {
        int best = TinyGP.rd.nextInt(TinyGP.POPULATION_SIZE), i, competitor;
        double  fbest = -1.0e34;

        for (i = 0; i < TinyGP.T_SIZE; i ++ ) {
            competitor = TinyGP.rd.nextInt(TinyGP.POPULATION_SIZE);
            if ( fitness[competitor] > fbest ) {
                fbest = fitness[competitor];
                best = competitor;
            }
        }
        return( best );
    }
}
