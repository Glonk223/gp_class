namespace OurGP.Nodes.Values.NumericValues
{
    public abstract class NumericValue : Value
    {
        static readonly Dictionary<string, (int, int)> possibleTransformations = new(){
            ["ArithmeticOperation"] = (ArithmeticOperation.minDepthToLeaf, ArithmeticOperation.maxDepthToLeaf),
            ["NumericConstant"]     = (    NumericConstant.minDepthToLeaf,     NumericConstant.maxDepthToLeaf),
            ["NumericNegation"]     = (    NumericNegation.minDepthToLeaf,     NumericNegation.maxDepthToLeaf),
            ["NumericVariable"]     = (    NumericVariable.minDepthToLeaf,     NumericVariable.maxDepthToLeaf),
        };

        internal static new readonly int minDepthToLeaf = possibleTransformations.Values.Min(x => x.Item1);
        internal static new readonly int maxDepthToLeaf = possibleTransformations.Values.Max(x => x.Item2);


        //! ---------- CONSTRUCTORS ----------
        //* Depth constructor
        protected NumericValue(int childrenCount, int depth = 0, Node? parent = null)
            : base(childrenCount, depth, parent) { }

        //* Grow constructor
        public static new NumericValue Grow(int maxDepth, int minDepth = 0, int currentDepth = 0, Node? parent = null)
        {
            int requiredMaxDepth = maxDepth - currentDepth;
            int requiredMinDepth = minDepth - currentDepth;

            // Console.WriteLine($"NumericValue.Grow({currentDepth}, {maxDepth})");
            if (requiredMaxDepth < minDepthToLeaf)
                throw new System.ArgumentException(GrowErrorMessage(maxDepth, currentDepth));

            return GetTransformationType(requiredMaxDepth, requiredMinDepth, parent) switch
            {
                "ArithmeticOperation" => ArithmeticOperation.Grow(maxDepth, minDepth, currentDepth, parent),
                "NumericConstant"     =>     NumericConstant.Grow(maxDepth, minDepth, currentDepth, parent),
                "NumericNegation"     =>     NumericNegation.Grow(maxDepth, minDepth, currentDepth, parent),
                "NumericVariable"     =>     NumericVariable.Grow(maxDepth, minDepth, currentDepth, parent),
                _ => throw new System.ArgumentException(GrowErrorMessage(maxDepth, currentDepth))
            };
        }
        static string GetTransformationType(int requiredMaxDepth, int requiredMinDepth, Node? parent = null)
        {
            var ptFiltered = possibleTransformations
                .Where(x => x.Value.Item1 <= requiredMaxDepth && x.Value.Item2 >= requiredMinDepth)
                .ToDictionary(x => x.Key, x => x.Value).Keys.ToList();

            if (parent is not NumericNegation)
                return ptFiltered[GP.rd.Next(ptFiltered.Count)];
            return ptFiltered.Where(x => x != "NumericNegation").ToList()[GP.rd.Next(ptFiltered.Count - 1)];
        }
        static string GrowErrorMessage(int maxDepth, int currentDepth)
        {
            return $"From node NumericValue on depth={currentDepth}:\n\tCannot grow NumericValue Node of depth={maxDepth - currentDepth},\n\tMinimum depth is {minDepthToLeaf}";
        }

        //* Copy constructor
        public new NumericValue DeepCopy()
        {
            return this switch
            {
                ArithmeticOperation arithmeticOperation => arithmeticOperation.DeepCopy(),
                NumericConstant         numericConstant =>     numericConstant.DeepCopy(),
                NumericNegation         numericNegation =>     numericNegation.DeepCopy(),
                NumericVariable         numericVariable =>     numericVariable.DeepCopy(),
                _ => throw new System.ArgumentException($"Cannot copy NumericValue of type {GetType().Name}")
            };
        }


        //! ---------- PROPERTIES ----------
        public abstract double Value { get; }
    }
}