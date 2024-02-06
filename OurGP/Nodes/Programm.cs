using Antlr4.Runtime;
using GPInterpreter;

namespace OurGP.Nodes
{
    public class Programm : Node
    {
        internal static new readonly int minDepthToLeaf = 4;
        internal static new readonly int maxDepthToLeaf = int.MaxValue;
        private ExpressionList Expressions
        {
            get => (ExpressionList)_children[0];
            set => _children[0] = value;
        }


        //! ---------- CONSTRUCTORS ----------
        //* Default constructor
        public Programm()
            : base(1) { }

        //* Depth constructor
        public Programm(int depth, Node? parent)
            : base(1, depth, parent) { }

        //* Parameterized constructor
        public Programm(ExpressionList expressions)
            : base(1)
        {
            Expressions = expressions;
        }

        //* Grow constructor
        public static new Programm Grow(int maxDepth, int minDepth = 0, int currentDepth = 0, Node? parent = null)
        {
            // Console.WriteLine($"Program.Grow({currentDepth}, {maxDepth})");
            if (maxDepth-currentDepth < minDepthToLeaf)
                throw new System.ArgumentException(GrowErrorMessage(maxDepth, currentDepth));
            
            var node = new Programm(currentDepth, parent);
            node.Expressions = ExpressionList.Grow(maxDepth, minDepth, currentDepth+1, node);

            node.FixSubtreeCountTopDown();
            return node;
        }
        public static Programm GrowFull(int maxDepth)
        {
            return Grow(maxDepth, maxDepth, 0, null);
        }

        static string GrowErrorMessage(int maxDepth, int currentDepth)
        {
            return $"From node Program on depth={currentDepth}:\n\tCannot grow Program Node of depth={maxDepth-currentDepth},\n\tMinimum depth is {minDepthToLeaf}";
        }

        //* Copy constructor
        public Programm DeepCopy()
        {
            var p = new Programm(Expressions.DeepCopy());
            p.FixDependecies();
            return p;
        }


        //! ---------- DON'T PICK THIS TO MUTATE ----------
        public new Node GetNodeRandom()
        {
            return _children[GP.rd.Next(_children.Length)].GetNodeRandom();
        }


        //! ---------- PROPERTIES ----------
        public override int MinDepth => Expressions.MinDepth + 1;
        public override int MaxDepth => Expressions.MaxDepth + 1;


        //! ---------- METHODS ----------
        public InOutVector Run(List<Value> input, int maxSteps = 500, string? program = null)
        {
            AntlrInputStream inputStream = new(program ?? this.ToString());
            GramLexer gramLexer = new(inputStream);
            CommonTokenStream commonTokenStream = new(gramLexer);
            GramParser gramParser = new(commonTokenStream);

            GramParser.ProgramContext progContext = gramParser.program();
            GpVisitor visitor = new(input, maxSteps);
            return visitor.ourVisit(progContext);
        }


        public override string ToString(string indent = "")
        {
            return Expressions.ToString(indent);
        }

        public override Type GetReplacementType(Node child)
        {
            return typeof(ExpressionList);
        }
    }
}