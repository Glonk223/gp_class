using GPInterpreter;
using OurGP.Nodes;

GP.Seed = (int)DateTime.UtcNow.Ticks;
// GP.Seed = 1228081554;
Console.WriteLine($"Seed: {GP.Seed}\n");

//! niesknczona pętla
string program1 = """
while(True) {
    X1 = X1 + 1
    print(X1)
}
""";

//! silnia
string program2 = """
X0 = 5
X9 = 1
while(X0 > 0) {
    X9 = X9 * X0
    X0 = X0 - 1
}
print(X9)
""";

string p = """
print(23 * -(-((34 + (-(-(34 + (34 / -(-(-(-(34 + (34 / -(-(-(34 + (34 / -(23 * -23))))))) * -(-X5 % (59 * -(-(34 + -(-41))))))))))) / -(23 * -23))) + (34 / -((X3 + 8) * -23)))))
scan(X5)
scan(X5)
scan(X5)
scan(X5)
print(23 * -(-(34 + (34 / -(-(-(-(23 + (34 / -(-(-(34 + (34 / -(23 * -23))))))) * -(-X5 % (59 * -(-(34 + -(-41))))))))))))
print(23 * -(-((34 + (-(-(34 + (34 / -(-(-(-(34 + (34 / -(-(-(34 + (34 / -(23 * -23))))))) * -(-X5 % (59 * -(-(34 + -(-41))))))))))) / -(23 * -23))) + (34 / -((X3 + 8) * -23)))))
""";


// testGrow(6);
// testGrowFull(6);
// testLongGrow(100_000, 100);
// testDeepCopy();
// testMutation();
// testCrossover(6);

// testRun(6);
// testRun2("scan(X1)");
testRun2(program1);
// testRun2(program2);
// testRun2(p);
// testFitness1();
// testFitness2();

// testPopulation();


void testGrow(int d = 8)
{
    var program = Programm.Grow(d);
    Console.WriteLine(program);
}

void testGrowFull(int d = 8)
{
    var program = Programm.GrowFull(d);
    // program.PrintDebugTree();
    Console.WriteLine(program);
}

void testLongGrow(int n, int d = 8)
{
    var population = new Node[n];
    for (int i = 0; i < n; i++)
        population[i] = Programm.Grow(d);
}

void testDeepCopy(int d = 8)
{
    var program = Programm.Grow(d);
    Console.WriteLine(program);
    var copy = program.DeepCopy();
    Console.WriteLine(copy);
}

void testMutation(int d = 8)
{
    var program = Programm.Grow(d);
    Console.WriteLine(program);
    var p2 = program.DeepCopy();

    Console.WriteLine("----- Mutation -----\n");

    p2.Mutate();
    Console.WriteLine(p2);
}

void testCrossover(int d = 8)
{
    var program1 = Programm.Grow(d);
    var program2 = Programm.Grow(d);
    Console.WriteLine(program1);
    Console.WriteLine("----------\n");
    Console.WriteLine(program2);

    Console.WriteLine("----- Crossover -----\n");

    var (c1, c2) = Node.Crossover(program1, program2);
    Console.WriteLine(c1);
    Console.WriteLine("----------\n");
    Console.WriteLine(c2);

    // Console.WriteLine(program1);
    // Console.WriteLine(program2);
}

void testRun(int d = 8)
{
    var program = Programm.Grow(d);
    Console.WriteLine(program);

    var result = program.Run(new List<Value>{new(true), new(false)});
    foreach (var value in result.output)
        Console.Write($"{value.GetNum()}, ");
    Console.WriteLine();
}

void testRun2(string program)
{
    Console.WriteLine(program);
    Programm p = new();

    var result = p.Run(new List<Value>{new(-5), new(5)}, 1000, program);
    foreach (var value in result.output)
        Console.Write($"{value.GetNum()}, ");
    Console.WriteLine();
}

// void testFitness1(int d = 8)
// {
//     var program = Programm.Grow(d);
//     Console.WriteLine(program);

//     var input = new List<Value>{new(true), new(false)};
//     var result = program.Run(input);
//     foreach (var value in result.output)
//         Console.Write($"{value.GetNum()}, ");
//     Console.WriteLine();

//     double fitness = double.MaxValue;
//     foreach (var value in result)
//     {
//         double val = Math.Abs(value.GetNum() - 1);
//         if (val < fitness)
//             fitness = val;
//     }

//     Console.WriteLine("fitenss: " + fitness);
// }

// void testFitness2(int d = 8)
// {
//     var program = Programm.Grow(d);
//     Console.WriteLine(program);

//     var result = program.Run(new List<Value>{new(true), new(false)});
//     foreach (var value in result)
//         Console.Write($"{value.GetNum()}, ");
//     Console.WriteLine();

//     var firstNum = result.Count() > 0 ? result[0].GetNum() : Double.MaxValue;
//     double fitness = Math.Abs(firstNum - 1);
//     fitness += result.Count - 1;

//     Console.WriteLine("fitenss: " + fitness);
// }

