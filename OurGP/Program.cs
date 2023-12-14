using OurGP.Nodes;

GP.Seed = (int)DateTime.UtcNow.Ticks;
// GP.Seed = -1030006198;
Console.WriteLine($"Seed: {GP.Seed}\n");


// testGrow(4);
// testLongGrow(1_000_000, 100);
// testDeepCopy();
// testMutation();
// testCrossover();


void testGrow(int d = 8)
{
    var program = OurGP.Nodes.Program.Grow(d);
    Console.WriteLine(program);
}

void testLongGrow(int n, int d = 8)
{
    var population = new Node[n];
    for (int i = 0; i < n; i++)
        population[i] = OurGP.Nodes.Program.Grow(d);
}

void testDeepCopy(int d = 8)
{
    var program = OurGP.Nodes.Program.Grow(d);
    Console.WriteLine(program);
    var copy = program.DeepCopy();
    Console.WriteLine(copy);
}

void testMutation(int d = 8)
{
    var program = OurGP.Nodes.Program.Grow(d);
    Console.WriteLine(program);
    program.Mutate();
    Console.WriteLine(program);
}

void testCrossover(int d = 8)
{
    var program1 = OurGP.Nodes.Program.Grow(d);
    var program2 = OurGP.Nodes.Program.Grow(d);
    Console.WriteLine(program1);
    Console.WriteLine(program2);
    var (c1, c2) = Node.Crossover(program1, program2);
    Console.WriteLine(c1);
    Console.WriteLine(c2);
}