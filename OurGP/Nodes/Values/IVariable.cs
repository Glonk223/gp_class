using OurGP.Nodes.Values.BooleanValues;
using OurGP.Nodes.Values.NumericValues;

namespace OurGP.Nodes.Values
{
    public interface IVariable
    {
        static readonly Dictionary<string, int> possibleTransformations = new(){
            ["BooleanVariable"] = BooleanVariable.minDepth,
            ["NumericVariable"] = NumericVariable.minDepth,
        };

        internal static readonly int minDepth = 2;


        //! ---------- CONSTRUCTORS ----------
        //* Grow constructor
        public static IVariable Grow(int maxDepth, int currentDepth = 0, Node? parent = null)
        {
            // Console.WriteLine($"IVariable.Grow({currentDepth}, {maxDepth})");
            if (maxDepth - currentDepth < minDepth)
                throw new System.ArgumentException(GrowErrorMessage(maxDepth, currentDepth));

            return GetTransformationType(maxDepth - currentDepth) switch
            {
                "BooleanVariable" => BooleanVariable.Grow(maxDepth, currentDepth + 1, parent),
                "NumericVariable" => NumericVariable.Grow(maxDepth, currentDepth + 1, parent),
                _ => throw new System.ArgumentException(GrowErrorMessage(maxDepth, currentDepth))
            };
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
        public IVariable DeepCopy()
        {
            return this switch
            {
                NumericVariable numericVariable => numericVariable.DeepCopy(),
                BooleanVariable booleanVariable => booleanVariable.DeepCopy(),
                _ => throw new System.Exception("Cannot copy a non-variable.")
            };
        }

    
        //! ---------- PROPERTIES ----------
        public int MinDepth { get; }
        public int MaxDepth { get; }


        //! ---------- METHODS ----------
        public void Assign(Value value);
    }
}