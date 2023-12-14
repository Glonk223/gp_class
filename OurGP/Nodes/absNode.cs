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
        public static void Swap(ref Node a, ref Node b)
        {
            var parentA = a.parent;
            var parentB = b.parent;

            var indexA = Array.IndexOf(parentA?._children ?? Array.Empty<Node>(), a);
            var indexB = Array.IndexOf(parentB?._children ?? Array.Empty<Node>(), b);

            // Console.WriteLine(indexA + " " + indexB);

            // Console.WriteLine("old a:\n" + a.parent);
            // Console.WriteLine("old b:\n" + b.parent);
            a.parent?.AssignNewChild(b, indexA);
            // Console.WriteLine("mid a:\n" + a.parent);
            // Console.WriteLine("mid b:\n" + b.parent);
            parentB?.AssignNewChild(a, indexB);
            // Console.WriteLine("new a:\n" + a.parent);
            // Console.WriteLine("new b:\n" + b.parent);

            (a.parent, b.parent) = (b.parent, a.parent);
        }
        public void AssignNewChild(Node newChild, int index)
        {
            if (index < 0 || index >= _children.Length)
                throw new System.ArgumentOutOfRangeException($"Index {index} is out of range [0, {_children.Length})");
            
            _children[index] = newChild;
            newChild.parent = this;
        }

        public override string ToString() { return ToString(indent: ""); }
        public abstract string ToString(string indent);

        /// <summary>
        /// does not include this node (i mean root node)
        /// </summary>
        public Node GetNodeRandom()
        {
            int index = GP.rd.Next(subtreeCount-1)+1;
            // Console.WriteLine($"GetRandomNode() => {index}");
            return GetNodeAt(index);
        }
        // public Node GetRandomNode(Type type)
        // {
        //     return GetRandomNode(type.Name);
        // }
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


        //! ---------- GENETIC OPERATIONS ----------
        public void Mutate()
        {
            var node = GetNodeRandom();

            // Console.WriteLine($"Mutating {node.GetType().Name} on depth {node.currentDepth} with subtreeCount {node.subtreeCount}, maxDepth {node.MaxDepth}, minDepth {node.MinDepth}");
            // Console.WriteLine($"Before mutation:\n{node}");

            int newMaxDepth = (int)(node.MaxDepth * 1.5);

            var growMethod = node.GetType().GetMethod("Grow");
            if (growMethod != null)
            {
                var newNode = growMethod.Invoke(null, new object[] { newMaxDepth + node.currentDepth, node.currentDepth, node.parent! }) as Node;

                node.parent?.AssignNewChild(newNode!, Array.IndexOf(node.parent._children, node));
            }
        }
        public static (Program, Program) Crossover(Program parent1, Program parent2)
        {
            var child1 = parent1.DeepCopy();
            var child2 = parent2.DeepCopy();

            var node1 = child1.GetNodeRandom();
            // get type of node 1 seen from its parent for example node can be of type NumericVariable but seen from its parent it is of type NumericValue
            //! this is not base type but type of the node seen from its parent
            // TODO: implement getter for replacement type in each class (the argument is child node, return is replacement type)
            // var type1 = node1.GetReplacementType();
            // var node2 = child2.GetNodeRandom(type1);

            // Swap(ref node1, ref node2);
            return (child1, child2);
        }
    }
}