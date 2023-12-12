using OurGP.Nodes.Values;
using OurGP.Nodes.Values.BooleanValues;
using OurGP.Nodes.Values.NumericValues;

namespace OurGP.Nodes.Expressions
{
    public class ScanStatement : Expression
    {
        static readonly Dictionary<string, int> possibleTransformations = new(){
            ["BooleanVariable"] = BooleanVariable.minDepth,
            ["NumericVariable"] = NumericVariable.minDepth,
        };

        internal static new readonly int minDepth = 2;
        private IVariable Variable
        {
            get => (IVariable)_children[0];
            set => _children[0] = (Node)value;
        }
        // TODO: Create IIn interface
        // private IIn input;


        //! ---------- CONSTRUCTORS ----------
        //* Static constructor
        static ScanStatement()
        {
            // TODO: Make this configurable
            // input = 
        }

        //* Depth constructor
        public ScanStatement(int depth, Node? parent)
            : base(1, depth, parent) { }

        //* Parameterized constructor
        public ScanStatement(IVariable variable)
            : base(1)
        {
            Variable = variable;
        }

        //* Grow constructor
        public static new ScanStatement Grow(int maxDepth, int currentDepth = 0, Node? parent = null)
        {
            // Console.WriteLine($"ScanStatement.Grow({currentDepth}, {maxDepth})");
            if (maxDepth - currentDepth < minDepth)
                throw new System.ArgumentException(GrowErrorMessage(maxDepth, currentDepth));

            var node = new ScanStatement(currentDepth, parent);
            node.Variable = GetTransformationType(maxDepth - currentDepth) switch
            {
                "BooleanVariable" => BooleanVariable.Grow(maxDepth, currentDepth + 1, node),
                "NumericVariable" => NumericVariable.Grow(maxDepth, currentDepth + 1, node),
                _ => throw new System.ArgumentException(GrowErrorMessage(maxDepth, currentDepth))
            };

            return node;
        }
        static string GetTransformationType(int requiredDepth)
        {
            return possibleTransformations.Keys.ToList()[GP.rd.Next(possibleTransformations.Count)];
        }
        static string GrowErrorMessage(int maxDepth, int currentDepth)
        {
            return $"From node ScanStatement on depth={currentDepth}:\n\tCannot grow ScanStatement Node of depth={maxDepth - currentDepth},\n\tMinimum depth is {minDepth}";
        }

        //* Copy constructor
        public static ScanStatement DeepCopy(ScanStatement other)
        {
            return new ScanStatement(IVariable.DeepCopy(other.Variable));
        }


        //! ---------- PROPERTIES ----------
        public override int MinDepth => Variable.MinDepth + 1;
        public override int MaxDepth => Variable.MaxDepth + 1;


        //! ---------- METHODS ----------
        public override void Run()
        {
            // input.Read(_value.IOPrint());
        }

        public override string ToString(string indent = "")
        {
            return $"{indent}scan({Variable})";
        }
    }
}