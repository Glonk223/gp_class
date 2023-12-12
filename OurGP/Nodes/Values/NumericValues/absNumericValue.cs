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

            return GetTransformationType(maxDepth-currentDepth) switch
            {
                "ArithmeticOperation" => ArithmeticOperation.Grow(maxDepth, currentDepth, parent),
                "NumericConstant"     =>     NumericConstant.Grow(maxDepth, currentDepth, parent),
                "NumericNegation"     =>     NumericNegation.Grow(maxDepth, currentDepth, parent),
                "NumericVariable"     =>     NumericVariable.Grow(maxDepth, currentDepth, parent),
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
            return $"From node NumericValue on depth={currentDepth}:\n\tCannot grow NumericValue Node of depth={maxDepth - currentDepth},\n\tMinimum depth is {minDepth}";
        }

        //* Copy constructor
        public static NumericValue DeepCopy(NumericValue other)
        {
            return other switch
            {
                ArithmeticOperation => ArithmeticOperation.DeepCopy((ArithmeticOperation)other),
                NumericConstant     =>     NumericConstant.DeepCopy((NumericConstant)    other),
                NumericNegation     =>     NumericNegation.DeepCopy((NumericNegation)    other),
                NumericVariable     =>     NumericVariable.DeepCopy((NumericVariable)    other),
                _ => throw new System.ArgumentException($"Cannot copy NumericValue of type {other.GetType()}")
            };
        }


        //! ---------- PROPERTIES ----------
        public abstract double Value { get; }
    }
}