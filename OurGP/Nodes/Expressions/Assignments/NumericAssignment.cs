using System.ComponentModel.DataAnnotations;
using OurGP.Nodes.Values.NumericValues;

namespace OurGP.Nodes.Expressions.Assignments
{
    public class NumericAssignment : Assignment
    {
        internal static new readonly int minDepth = 2;
        private NumericVariable _variable;
        private NumericValue _value;

        
        //! ---------- CONSTRUCTORS ----------
        // TODO: Copy constructor
        // public NumericAssignment(NumericAssignment assignment)

        //* Parameterized constructor
        public NumericAssignment(NumericVariable variable, NumericValue value)
        {
            _variable = variable;
            _value = value;
        }

        //* Grow constructor
        public NumericAssignment(int currentDepth, int maxDepth, Node? parent)
            : base(currentDepth, parent)
        {
            // Console.WriteLine($"NumericAssignment: {currentDepth} {maxDepth}");
            if (maxDepth - currentDepth < minDepth)
                throw new System.ArgumentException(GrowErrorMessage(currentDepth, maxDepth));

            _variable = new NumericVariable(currentDepth + 1, maxDepth, this);
            _value = NumericValue.Random(currentDepth + 1, maxDepth, this);
        }

        static string GrowErrorMessage(int currentDepth, int maxDepth)
        {
            return $"From node NumericAssignment on depth={currentDepth}:\n\tCannot grow NumericAssignment Node of depth={maxDepth - currentDepth},\n\tMinimum depth is {minDepth}";
        }


        //! ---------- RUN ----------
        public override void Run()
        {
            _variable.Assign(_value);
        }


        //! ---------- TO STRING ----------
        public override string ToString(string indent = "")
        {
            return $"{indent}{_variable} = {_value}";
        }
    }
}