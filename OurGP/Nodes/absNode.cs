using System.Dynamic;
using OurGP.Nodes.Expressions.Assignments;
using OurGP.Nodes.Values;

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
            {
                // Console.WriteLine("a or b is null");
                return false;
            }
            
            if (a.parent == null || b.parent == null)
            {
                // Console.WriteLine("a.parent or b.parent is null");
                return false;
            }

            var parAaccepts = a.parent.GetReplacementType(a);
            var parBaccepts = b.parent.GetReplacementType(b);

            if (!b.GetType().IsSubclassOf(parAaccepts))
            {
                // Console.WriteLine($"{b.GetType().Name} is not subclass of {parAaccepts.Name}");
                return false;
            }

            if (!a.GetType().IsSubclassOf(parBaccepts))
            {
                // Console.WriteLine($"{a.GetType().Name} is not subclass of {parBaccepts.Name}");
                return false;
            }
            
            return true;
        }

        public override string ToString() { return ToString(indent: ""); }
        public abstract string ToString(string indent);

        public Node GetNodeRandom()
        {
            int index = GP.rd.Next(subtreeCount-1)+1;
            // Console.WriteLine($"GetRandomNode() => {index}");
            return GetNodeAt(index);
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

            int newMaxDepth = (int)(node.MaxDepth * 1.5);
            var growMethod = node.GetType().GetMethod("Grow");
            if (growMethod != null)
            {
                var newNode = growMethod.Invoke(null, new object[] { newMaxDepth + node.currentDepth, node.currentDepth, node.parent! }) as Node;

                var mutationIndex = Array.IndexOf(node.parent!._children, node);
                node.parent._children[mutationIndex] = newNode!;
                newNode.parent = node!.parent;
                node.parent?.FixSubtreeCountBottomUp();
            }
        }

        public static (Program, Program) Crossover(Program parent1, Program parent2)
        {
            var child1 = parent1.DeepCopy();
            var child2 = parent2.DeepCopy();

            Node node1; 
            Node? node2;
            do
            {
                node1 = child1.GetNodeRandom();
                // Console.WriteLine($"node1 type: {node1.GetType().Name}");
                // Console.WriteLine($"node1 parent type: {node1.parent?.GetType().Name}");

                var replacementType = node1.parent!.GetReplacementType(node1);
                // Console.WriteLine($"replacementType: {replacementType.Name}");

                node2 = child2.GetNodeOfTypeRandom(replacementType);
                // Console.WriteLine($"node2 type: {node2?.GetType().Name}");
                // Console.WriteLine($"node2 parent type: {node2?.parent?.GetType().Name}");

                // Console.WriteLine($"AreSwapable: {Node.AreSwapable(node1, node2)}");
                // Console.ReadKey();
            }
            while (!Node.AreSwapable(node1, node2));

            Swap(ref node1, ref node2);
            return (child1, child2);
        }

        public abstract Type GetReplacementType(Node child);
    }
}
