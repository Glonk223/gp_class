using System.ComponentModel;
using OurGP.Nodes.Values.BooleanValues;

namespace OurGP.Nodes.Expressions.Assignments
{
    public class BooleanAssignment : Assignment
    {
        internal static new readonly int minDepth = 2;
        private BooleanVariable _variable;
        private BooleanValue _value;


        //! ---------- CONSTRUCTORS ----------
        // TODO: Copy constructor
        // public BooleanAssignment(BooleanAssignment assignment)

        //* Parameterized constructor
        public BooleanAssignment(BooleanVariable variable, BooleanValue value)
        {
            _variable = variable;
            _value = value;
        }

        //* Grow constructor
        public BooleanAssignment(int currentDepth, int maxDepth, Node? parent)
            : base(currentDepth, parent)
        {
            // Console.WriteLine($"BooleanAssignment: {currentDepth} {maxDepth}");
            if (maxDepth - currentDepth < minDepth)
                throw new System.ArgumentException(GrowErrorMessage(currentDepth, maxDepth));

            _variable = new BooleanVariable(currentDepth + 1, maxDepth, this);
            _value = BooleanValue.Random(currentDepth + 1, maxDepth, this);
        }

        static string GrowErrorMessage(int currentDepth, int maxDepth)
        {
            return $"From node BooleanAssignment on depth={currentDepth}:\n\tCannot grow BooleanAssignment Node of depth={maxDepth - currentDepth},\n\tMinimum depth is {minDepth}";
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