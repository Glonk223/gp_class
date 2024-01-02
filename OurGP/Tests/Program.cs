// using GPInterpreter;
// using OurGP.Nodes;

// GP.Seed = (int)DateTime.UtcNow.Ticks;
// // GP.Seed = 1228081554;
// Console.WriteLine($"Seed: {GP.Seed}\n");

// //! niesknczona pętla
// string program1 = """
// while(True) {
//     X1 = X1 + 1
//     print(X1)
// }
// """;

// //! silnia
// string program2 = """
// X0 = 5
// X9 = 1
// while(X0 > 0) {
//     X9 = X9 * X0
//     X0 = X0 - 1
// }
// print(X9)
// """;


// // testGrow(7);
// // testLongGrow(100_000, 100);
// // testDeepCopy();
// // testMutation();
// // testCrossover(6);

// // testRun(6);
// // testRun2(program1);
// // testRun2(program2);
// // testFitness1();
// // testFitness2();

// // testPopulation();


// void testGrow(int d = 8)
// {
//     var program = OurGP.Nodes.Program.Grow(d);
//     Console.WriteLine(program);
// }

// void testLongGrow(int n, int d = 8)
// {
//     var population = new Node[n];
//     for (int i = 0; i < n; i++)
//         population[i] = OurGP.Nodes.Program.Grow(d);
// }

// void testDeepCopy(int d = 8)
// {
//     var program = OurGP.Nodes.Program.Grow(d);
//     Console.WriteLine(program);
//     var copy = program.DeepCopy();
//     Console.WriteLine(copy);
// }

// void testMutation(int d = 8)
// {
//     var program = OurGP.Nodes.Program.Grow(d);
//     Console.WriteLine(program);
//     program.Mutate();
//     Console.WriteLine(program);
// }

// void testCrossover(int d = 8)
// {
//     var program1 = OurGP.Nodes.Program.Grow(d);
//     var program2 = OurGP.Nodes.Program.Grow(d);
//     Console.WriteLine(program1);
//     Console.WriteLine(program2);

//     Console.WriteLine("----- Crossover -----\n");

//     var (c1, c2) = Node.Crossover(program1, program2);
//     Console.WriteLine(c1);
//     Console.WriteLine(c2);
// }

// void testRun(int d = 8)
// {
//     var program = OurGP.Nodes.Program.Grow(d);
//     Console.WriteLine(program);

//     var result = program.Run(new List<Value>{new(true), new(false)});
//     foreach (var value in result)
//         Console.Write($"{value.GetNum()}, ");
//     Console.WriteLine();
// }

// void testRun2(string program)
// {
//     Console.WriteLine(program);
//     OurGP.Nodes.Program p = new();
//     var result = p.Run(new List<Value>{new(true), new(false)}, 1000, program);
//     foreach (var value in result)
//         Console.Write($"{value.GetNum()}, ");
//     Console.WriteLine();
// }

// void testFitness1(int d = 8)
// {
//     var program = OurGP.Nodes.Program.Grow(d);
//     Console.WriteLine(program);

//     var result = program.Run(new List<Value>{new(true), new(false)});
//     foreach (var value in result)
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
//     var program = OurGP.Nodes.Program.Grow(d);
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

// void testPopulation()
// {
    
// }

