using OurGP.Nodes.Values.BooleanValues;
using OurGP.Nodes.Values.NumericValues;

namespace OurGP.Nodes.Values
{
    public abstract class Value : Node
    {
        static readonly Dictionary<string, (int, int)> possibleTransformations = new(){
            ["BooleanValue"] = (BooleanValue.minDepthToLeaf, BooleanValue.maxDepthToLeaf),
            ["NumericValue"] = (NumericValue.minDepthToLeaf, NumericValue.maxDepthToLeaf),
        };

        internal static new readonly int minDepthToLeaf = possibleTransformations.Values.Min(x => x.Item1);
        internal static new readonly int maxDepthToLeaf = possibleTransformations.Values.Max(x => x.Item2);


        //! ---------- CONSTRUCTORS ----------
        //* Depth constructor
        protected Value(int childrenCount, int depth = 0, Node? parent = null)
            : base(childrenCount, depth, parent) { }

        //* Grow constructor
        public static new Value Grow(int maxDepth, int minDepth = 0, int currentDepth = 0, Node? parent = null)
        {
            int requiredMaxDepth = maxDepth - currentDepth;
            int requiredMinDepth = minDepth - currentDepth;

            // Console.WriteLine($"Value.Grow({currentDepth}, {maxDepth})");
            if (requiredMaxDepth < minDepthToLeaf)
                throw new System.ArgumentException(GrowErrorMessage(maxDepth, currentDepth));
            
            return GetTransformationType(requiredMaxDepth, requiredMinDepth) switch
            {
                "BooleanValue" => BooleanValue.Grow(maxDepth, minDepth, currentDepth, parent),
                "NumericValue" => NumericValue.Grow(maxDepth, minDepth, currentDepth, parent),
                _ => throw new System.ArgumentException(GrowErrorMessage(maxDepth, currentDepth))
            };
        }
        static string GetTransformationType(int requiredMaxDepth, int requiredMinDepth)
        {
            var ptFiltered = possibleTransformations
                .Where(x => x.Value.Item1 <= requiredMaxDepth && x.Value.Item2 >= requiredMinDepth)
                .ToDictionary(x => x.Key, x => x.Value).Keys.ToList();

            return ptFiltered[GP.rd.Next(ptFiltered.Count)];
        }
        static string GrowErrorMessage(int maxDepth, int currentDepth)
        {
            return $"From node Value on depth={currentDepth}:\n\tCannot grow NumericValue Node of depth={maxDepth - currentDepth},\n\tMinimum depth is {minDepthToLeaf}";
        }

        //* Copy constructor
        public Value DeepCopy()
        {
            return this switch
            {
                BooleanValue booleanValue => booleanValue.DeepCopy(),
                NumericValue numericValue => numericValue.DeepCopy(),
                _ => throw new System.ArgumentException($"Cannot copy Value of type {GetType()}")
            };
        }


        //! ---------- METHODS ----------
        public override string ToString(string indent = "")
        {
            return ToString(indent: "");
        }

        // public abstract string IOPrint();
    }
}