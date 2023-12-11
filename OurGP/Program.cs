using OurGP.Nodes;

Node.Seed = (int)DateTime.UtcNow.Ticks;
// Node.Seed = -815812464;
Console.WriteLine($"Seed: {Node.Seed}\n");

// OurGP.Nodes.Program.PrintMinDepth();

// for (int i = 0; i < 100_000; i++)
// {
//     var x = new OurGP.Nodes.Program(30);
//     // Console.WriteLine(x);
// }

var program = new OurGP.Nodes.Program(15);

Console.WriteLine(program);