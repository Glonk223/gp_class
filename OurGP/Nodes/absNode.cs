namespace OurGP.Nodes
{
    public abstract class Node
    {
        protected static readonly int minDepth = int.MaxValue;
        protected int currentDepth;
        protected Node? parent;
        protected int subtreeCount = 0;

        protected Node[] _children;

        public abstract void Run();


        //! ---------- CONSTRUCTORS ----------
        //* Depth constructor
        protected Node(int childrenCount = 0, int depth = 0, Node? parent = null)
        {
            _children = childrenCount !=0 ? new Node[childrenCount] : Array.Empty<Node>();
            currentDepth = depth;
            this.parent = parent;
        }

        //* Grow constructor
        public static Node Grow(int maxDepth, int currentDepth = 0, Node? parent = null)
        {
            throw new NotImplementedException("Not implemented and it'll newer be.\n💀💀💀\nHow you would expect it to work on an abstract Node pall?!");
        }


        //! ---------- FIXING DEPENDENCIES ----------
        public int FixDependecies(Node? parent = null)
        {
            this.parent = parent;
            currentDepth = parent?.currentDepth + 1 ?? 0;
            subtreeCount = 0;
            foreach (var child in _children)
                subtreeCount += child.FixDependecies(this);
            return subtreeCount + 1;
        }
        public void FixParenting(Node? parent = null)
        {
            this.parent = parent;
            foreach (var child in _children)
                child.FixParenting(this);
        }
        public int FixSubtreeCountTopDown()
        {
            subtreeCount = 1;
            foreach (var child in _children)
                subtreeCount += child.FixSubtreeCountTopDown();
            return subtreeCount;
        }
        public void FixSubtreeCountBottomUp()
        {
            parent?.FixSubtreeCountBottomUp();
            subtreeCount = _children.Sum(child => child.subtreeCount);
        }


        //! ---------- DEBUGGING ----------
        public void PrintDebugTree()
        {
            PrintInfo();
            foreach (var child in _children)
                child.PrintDebugTree();
        }
        public void PrintInfo()
        {
            Console.WriteLine(GetType().Name);
            Console.WriteLine($"(depth={currentDepth}, subtreeCount={subtreeCount}, parent={parent?.GetType().Name ?? "null"})\n");
        }


        //! ---------- PROPERTIES ----------
        public abstract int MinDepth { get; }
        public abstract int MaxDepth { get; }


        //! ---------- METHODS ----------
        public static void Swap(ref Node a, ref Node b)
        {
            (a.currentDepth, b.currentDepth) = (b.currentDepth, a.currentDepth);
            (      a.parent, b.parent      ) = (      b.parent, a.parent      );
            (             a, b             ) = (             b, a             );
        }

        public override string ToString() { return ToString(indent: ""); }
        public abstract string ToString(string indent);

        public Node GetRandomNode()
        {
            int index = GP.rd.Next(subtreeCount);
            return GetNodeAt(index);
        }
        public Node GetNodeAt(int index)
        {
            if (index < 0 || index >= subtreeCount)
                throw new System.ArgumentOutOfRangeException($"Index {index} is out of range [0, {subtreeCount})");


            // Console.WriteLine($"GetNodeAt({index})");
            if (index <= 0)
                // Console.WriteLine($"Returning 'this'");
                return this;
            
            // Console.WriteLine($"Searching in children");
            // Console.WriteLine($"\tChildren counts: " + string.Join(", ", _children.Select(child => child.subtreeCount)));
            foreach (var child in _children)
            {
                if (index <= child.subtreeCount)
                    return child.GetNodeAt(index - 1);
                index -= child.subtreeCount;
            }
            throw new System.ArgumentOutOfRangeException($"No Node found for index {index} in range [0, {subtreeCount})\nIt should never happen!");
        }


        //! ---------- GENETIC OPERATIONS ----------
        public void Mutate()
        {
            var par = parent;

            
        }
        // public abstract void Crossover(Node other);
    } 
}