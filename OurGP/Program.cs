using OurGP.Nodes;

GP.Seed = (int)DateTime.UtcNow.Ticks;
// GP.Seed = -1884828724;
Console.WriteLine($"Seed: {GP.Seed}\n");

// OurGP.Nodes.Program.PrintMinDepth();

// var population = new OurGP.Nodes.Program[1_000_000];
// for (int i = 0; i < population.Length; i++)
//     population[i] = OurGP.Nodes.Program.Grow(100);

var program = OurGP.Nodes.Program.Grow(15);

Console.WriteLine(program);

// GP.Seed = (int)DateTime.UtcNow.Ticks;

program.Mutate();

Console.WriteLine("\n" + program);
// program.PrintDebugTree();

// var program2 = OurGP.Nodes.Program.DeepCopy(program);
// Console.WriteLine(program2);