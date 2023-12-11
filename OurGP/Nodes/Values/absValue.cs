using OurGP.Nodes.Values.BooleanValues;
using OurGP.Nodes.Values.NumericValues;

namespace OurGP.Nodes.Values
{
    public abstract class Value : Node
    {
        static readonly Dictionary<string, int> possibleTransformations = new(){
            ["BooleanValue"] = BooleanValue.minDepth,
            ["NumericValue"] = NumericValue.minDepth,
        };

        internal static new readonly int minDepth = possibleTransformations.Values.Min();

        //! ---------- CONSTRUCTORS ----------
        //* Depth constructor
        protected Value(int depth = 0, Node? parent = null)
            : base(depth, parent) { }

        //* Grow constructor
        public static new Value Random(int currentDepth, int maxDepth, Node? parent)
        {
            // Console.WriteLine($"Value.Grow({currentDepth}, {maxDepth})");
            if (maxDepth - currentDepth < minDepth)
                throw new System.ArgumentException(GrowErrorMessage(currentDepth, maxDepth));
            
            return GetTransformationType(maxDepth - currentDepth) switch
            {
                "BooleanValue" => BooleanValue.Random(currentDepth, maxDepth, parent),
                "NumericValue" => NumericValue.Random(currentDepth, maxDepth, parent),
                _ => throw new System.ArgumentException(GrowErrorMessage(currentDepth, maxDepth))
            };
        }

        static string GetTransformationType(int requiredDepth)
        {
            var possibleTransformationsFiltered = possibleTransformations.Where(x => x.Value <= requiredDepth).ToDictionary(x => x.Key, x => x.Value).Keys.ToList();
            return possibleTransformationsFiltered[rd.Next(possibleTransformationsFiltered.Count)];
        }

        static string GrowErrorMessage(int currentDepth, int maxDepth)
        {
            return $"From node Value on depth={currentDepth}:\n\tCannot grow NumericValue Node of depth={maxDepth - currentDepth},\n\tMinimum depth is {minDepth}";
        }


        //! ---------- TO STRING ----------
        public override string ToString(string indent = "")
        {
            return ToString(indent: "");
        }

        // public abstract string IOPrint();
    }
}