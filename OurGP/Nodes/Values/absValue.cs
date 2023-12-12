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
        protected Value(int childrenCount, int depth = 0, Node? parent = null)
            : base(childrenCount, depth, parent) { }

        //* Grow constructor
        public static new Value Grow(int maxDepth, int currentDepth = 0, Node? parent = null)
        {
            // Console.WriteLine($"Value.Grow({currentDepth}, {maxDepth})");
            if (maxDepth - currentDepth < minDepth)
                throw new System.ArgumentException(GrowErrorMessage(maxDepth, currentDepth));
            
            return GetTransformationType(maxDepth - currentDepth) switch
            {
                "BooleanValue" => BooleanValue.Grow(maxDepth, currentDepth, parent),
                "NumericValue" => NumericValue.Grow(maxDepth, currentDepth, parent),
                _ => throw new System.ArgumentException(GrowErrorMessage(maxDepth, currentDepth))
            };
        }
        static string GetTransformationType(int requiredDepth)
        {
            var possibleTransformationsFiltered = possibleTransformations.Where(x => x.Value <= requiredDepth).ToDictionary(x => x.Key, x => x.Value).Keys.ToList();
            return possibleTransformationsFiltered[GP.rd.Next(possibleTransformationsFiltered.Count)];
        }
        static string GrowErrorMessage(int maxDepth, int currentDepth)
        {
            return $"From node Value on depth={currentDepth}:\n\tCannot grow NumericValue Node of depth={maxDepth - currentDepth},\n\tMinimum depth is {minDepth}";
        }

        //* Copy constructor
        public static Value DeepCopy(Value other)
        {
            return other switch
            {
                BooleanValue => BooleanValue.DeepCopy((BooleanValue)other),
                NumericValue => NumericValue.DeepCopy((NumericValue)other),
                _ => throw new System.ArgumentException($"Cannot copy Value of type {other.GetType()}")
            };
        }


        //! ---------- METHODS ----------
        public override void Run() { }
        public override string ToString(string indent = "")
        {
            return ToString(indent: "");
        }

        // public abstract string IOPrint();
    }
}