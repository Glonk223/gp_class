namespace OurGP.Nodes.Values.NumericValues
{
    public abstract class NumericValue : Value
    {
        static readonly Dictionary<string, int> possibleTransformations = new(){
            ["ArithmeticOperation"] = ArithmeticOperation.minDepth,
            ["NumericConstant"] = NumericConstant.minDepth,
            ["NumericNegation"] = NumericNegation.minDepth,
            ["NumericVariable"] = NumericVariable.minDepth,
        };

        internal static new readonly int minDepth = possibleTransformations.Values.Min();


        //! ---------- CONSTRUCTORS ----------
        //* Depth constructor
        protected NumericValue(int childrenCount, int depth = 0, Node? parent = null)
            : base(childrenCount, depth, parent) { }

        //* Grow constructor
        public static new NumericValue Grow(int maxDepth, int currentDepth = 0, Node? parent = null)
        {
            // Console.WriteLine($"NumericValue.Grow({currentDepth}, {maxDepth})");
            if (maxDepth-currentDepth < minDepth)
                throw new System.ArgumentException(GrowErrorMessage(maxDepth, currentDepth));

            return GetTransformationType(maxDepth-currentDepth, parent) switch
            {
                "ArithmeticOperation" => ArithmeticOperation.Grow(maxDepth, currentDepth, parent),
                "NumericConstant"     =>     NumericConstant.Grow(maxDepth, currentDepth, parent),
                "NumericNegation"     =>     NumericNegation.Grow(maxDepth, currentDepth, parent),
                "NumericVariable"     =>     NumericVariable.Grow(maxDepth, currentDepth, parent),
                _ => throw new System.ArgumentException(GrowErrorMessage(maxDepth, currentDepth))
            };
        }
        static string GetTransformationType(int requiredDepth, Node? parent = null)
        {
            var ptFiltered =
                possibleTransformations
                    .Where(x => x.Value <= requiredDepth)
                    .ToDictionary(x => x.Key, x => x.Value)
                    .Keys.ToList();

            if (parent is not NumericNegation)
                return ptFiltered[GP.rd.Next(ptFiltered.Count)];
            return ptFiltered.Where(x => x != "NumericNegation").ToList()[GP.rd.Next(ptFiltered.Count - 1)];
        }
        static string GrowErrorMessage(int maxDepth, int currentDepth)
        {
            return $"From node NumericValue on depth={currentDepth}:\n\tCannot grow NumericValue Node of depth={maxDepth - currentDepth},\n\tMinimum depth is {minDepth}";
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