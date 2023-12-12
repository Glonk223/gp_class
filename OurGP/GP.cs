using OurGP.Nodes;

static class GP
{
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

    static Program[]? population;


}