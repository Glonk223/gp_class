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
        private IVariable _variable;
        // TODO: Create IIn interface
        // private IIn input;


        //! ---------- CONSTRUCTORS ----------
        //* Static constructor
        static ScanStatement()
        {
            // TODO: Make this configurable
            // input = 
        }

        // TODO: Copy constructor
        // public ScanStatement(ScanStatement scanStatement)

        //* Parameterized constructor
        public ScanStatement(IVariable variable, int depth = 0) : base(depth)
        {
            _variable = variable;
        }

        //* Grow constructor
        public ScanStatement(int currentDepth, int maxDepth, Node? parent)
            : base(currentDepth, parent)
        {
            // Console.WriteLine($"ScanStatement.Grow({currentDepth}, {maxDepth})");
            if (maxDepth - currentDepth < minDepth)
                throw new System.ArgumentException(GrowErrorMessage(currentDepth, maxDepth));

            _variable = GetTransformationType(maxDepth - currentDepth) switch
            {
                "BooleanVariable" => new BooleanVariable(currentDepth + 1, maxDepth, this),
                "NumericVariable" => new NumericVariable(currentDepth + 1, maxDepth, this),
                _ => throw new System.ArgumentException(GrowErrorMessage(currentDepth, maxDepth))
            };
        }

        static string GetTransformationType(int requiredDepth)
        {
            return possibleTransformations.Keys.ToList()[rd.Next(possibleTransformations.Count)];
        }

        static string GrowErrorMessage(int currentDepth, int maxDepth)
        {
            return $"From node ScanStatement on depth={currentDepth}:\n\tCannot grow ScanStatement Node of depth={maxDepth - currentDepth},\n\tMinimum depth is {minDepth}";
        }


        //! ---------- RUN ----------
        public override void Run()
        {
            // input.Read(_value.IOPrint());
        }


        //! ---------- TO STRING ----------
        public override string ToString(string indent = "")
        {
            return $"{indent}scan({_variable})";
        }
    }
}