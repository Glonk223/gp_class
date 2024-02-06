namespace OurGP.Nodes;
    public abstract class Node
    {
        static double PICK_THIS_CHANCE = 0.4;

        protected static readonly int minDepthToLeaf = int.MaxValue;
        protected static readonly int maxDepthToLeaf = int.MaxValue;
        protected int currentDepth;
        protected Node? parent;
        protected int subtreeCount = 0;

        protected Node[] _children;


        //! ---------- CONSTRUCTORS ----------
        //* Depth constructor
        protected Node(int childrenCount = 0, int depth = 0, Node? parent = null)
        {
            _children = childrenCount !=0 ? new Node[childrenCount] : Array.Empty<Node>();
            currentDepth = depth;
            this.parent = parent;
        }

        //* Grow constructor
        public static Node Grow(int maxDepth, int minDepth = 0, int currentDepth = 0, Node? parent = null)
        {
            throw new NotImplementedException("Not implemented and it'll newer be.\nHow you would expect it to work on an abstract Node pall?!\n💀💀💀");
        }

        //* Copy constructor
        public Node DeepCopy(Node other)
        {
            throw new NotImplementedException("Not implemented and it'll newer be.\nHow you would expect it to work on an abstract Node pall?!\n💀💀💀");
        }

        //! ---------- FIXING DEPENDENCIES ----------
        public int FixDependecies(Node? parent = null)
        {
            this.parent = parent;
            currentDepth = parent?.currentDepth + 1 ?? 0;
            subtreeCount = 1;
            foreach (var child in _children)
                subtreeCount += child.FixDependecies(this);
            return subtreeCount;
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
        private static void Swap(ref Node a, ref Node b)
        {
            var parentA = a.parent;
            var parentB = b.parent;

            var indexA = Array.IndexOf(parentA!._children, a);
            var indexB = Array.IndexOf(parentB!._children, b);

            a.parent!._children[indexA] = b;
            b.parent!._children[indexB] = a;

            (a.parent, b.parent) = (b.parent, a.parent);

            a.FixSubtreeCountBottomUp();
            b.FixSubtreeCountBottomUp();
        }

        private static bool AreSwapable(Node? a, Node? b)
        {
            if (a == null || b == null)
                return false;
            
            if (a.parent == null || b.parent == null)
                return false;

            var parAaccepts = a.parent.GetReplacementType(a);
            var parBaccepts = b.parent.GetReplacementType(b);

            if (!b.GetType().IsSubclassOf(parAaccepts))
                return false;

            if (!a.GetType().IsSubclassOf(parBaccepts))
                return false;
            
            return true;
        }

        public override string ToString() { return ToString(indent: ""); }
        public abstract string ToString(string indent);

        public Node GetNodeRandom()
        {
            //* Is leaf -> return this
            if (subtreeCount == 1)
                return this;

            if (GP.rd.NextDouble() < PICK_THIS_CHANCE && parent != null)
                return this;
            return _children[GP.rd.Next(_children.Length)].GetNodeRandom();
        }
        public Node GetNodeAt(int index)
        {
            if (index < 0 || index >= subtreeCount)
                throw new System.ArgumentOutOfRangeException($"Index {index} is out of range [0, {subtreeCount})");

            if (index <= 0)
                return this;
            
            foreach (var child in _children)
            {
                if (index <= child.subtreeCount)
                    return child.GetNodeAt(index - 1);
                index -= child.subtreeCount;
            }
            throw new System.ArgumentOutOfRangeException($"No Node found for index {index} in range [0, {subtreeCount})\nIt should never happen!");
        }

        public List<Node> GetAllNodesOfType(Type type)
        {
            var nodes = new List<Node>();
            if (GetType().IsSubclassOf(type))
                nodes.Add(this);
            foreach (var child in _children)
                nodes.AddRange(child.GetAllNodesOfType(type));
            return nodes; 
        }
        public Node? GetNodeOfTypeRandom(Type type)
        {
            var possibilities = GetAllNodesOfType(type);
            if (possibilities.Count == 0)
                return null;
            return possibilities[GP.rd.Next(possibilities.Count)];
        }


        //! ---------- GENETIC OPERATIONS ----------
        public void Mutate()
        {
            var node = GetNodeRandom();

            int newMaxDepth = (int)(node.MaxDepth * 1.5) + node.currentDepth;
            int newMinDepth = (int)(node.MaxDepth * 0.5) + node.currentDepth;
            var growMethod = node.GetType().GetMethod("Grow");
            if (growMethod != null)
            {
                var newNode = growMethod.Invoke(null, new object[] { newMaxDepth, newMinDepth, node.currentDepth, node.parent! }) as Node;

                var mutationIndex = Array.IndexOf(node.parent!._children, node);
                node.parent._children[mutationIndex] = newNode!;
                newNode!.parent = node!.parent;
                node.parent?.FixSubtreeCountBottomUp();
            }
        }

        public static (Programm, Programm) Crossover(Programm parent1, Programm parent2)
        {
            var child1 = parent1.DeepCopy();
            var child2 = parent2.DeepCopy();

            Node node1;
            Node? node2;
            do
            {
                node1 = child1.GetNodeRandom();
                var replacementType = node1.parent!.GetReplacementType(node1);
                node2 = child2.GetNodeOfTypeRandom(replacementType);
            }
            while (!Node.AreSwapable(node1, node2));

            Swap(ref node1, ref node2!);
            return (child1, child2);
        }

        public abstract Type GetReplacementType(Node child);
    }

