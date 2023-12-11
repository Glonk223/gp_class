using OurGP.Nodes.Expressions;

namespace OurGP.Nodes
{
    public abstract class Node
    {
        protected static readonly int minDepth = int.MaxValue;
        protected readonly int currentDepth;
        protected readonly Node? parent;

        static int seed = 0;
        public static int Seed
        {
            get => seed;
            set
            {
                seed = value;
                rd = new Random(Seed);
            }
        }
        protected static Random rd = new(Seed: Seed);


        public abstract void Run();

        
        //! ---------- CONSTRUCTORS ----------
        //* Depth constructor
        protected Node(int depth = 0, Node? parent = null)
        {
            currentDepth = depth;
            this.parent = parent;
        }

        //* Grow constructor
        public static Node Random(int currentDepth, int maxDepth, Node? parent = null)
        {
            // Console.WriteLine($"Node.Grow({currentDepth}, {maxDepth})");
            return new ExpressionList(currentDepth, maxDepth, parent);
        }


        // protected abstract Node CreateChild(int maxDepth);
        // public abstract void Mutate();
        // public abstract void Crossover(Node other);
        public override string ToString() { return ToString(indent: ""); }
        public abstract string ToString(string indent);
    } 
}