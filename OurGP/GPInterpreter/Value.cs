namespace GPInterpreter;

public class Value
{
    private double numVal;
    private bool boolVal;

    public Value()
    {
        this.numVal = 0;
        this.boolVal = false;
    }
    public Value(double numVal)
    {
        this.numVal = numVal;
        if (numVal == 0)
            this.boolVal = false;
        else
            this.boolVal = true;
    }

    public Value(bool boolVal)
    {
        this.boolVal = boolVal;
        if (boolVal)
            this.numVal = 1;
        else
            this.numVal = 0;
    }

    public double GetNum()
    {
        return numVal;
    }

    public bool GetBool()
    {
        return boolVal;
    }
    
    public static Value Add(Value val1, Value val2)
    { 
        return new Value(val1.numVal + val2.numVal);
    }
    
    public static Value Substract(Value val1, Value val2)
    { 
        return new Value(val1.numVal - val2.numVal);
    }
    public static Value Multiply(Value val1, Value val2)
    { 
        return new Value(val1.numVal * val2.numVal);
    }
    
    public static Value Divide(Value val1, Value val2)
    { 
        return new Value(val1.numVal / val2.numVal);
    }
    
    public static Value Modulo(Value val1, Value val2)
    { 
        return new Value(val1.numVal % val2.numVal);
    }

    public static Value Equal(Value val1, Value val2)
    {
        if (Math.Abs(val1.numVal - val2.numVal) < 0.00001)
            return new Value(true);
        else
            return new Value(false);
    }
    
    public static Value NotEqual(Value val1, Value val2)
    { 
        if (Math.Abs(val1.numVal - val2.numVal) > 0.00001)
            return new Value(true);
        else
            return new Value(false);
    }
    
    public static Value Less(Value val1, Value val2)
    { 
        return new Value(val1.numVal < val2.numVal);
    }
    
    public static Value LessOrEqual(Value val1, Value val2)
    { 
        return new Value(val1.numVal <= val2.numVal);
    }
    
    public static Value Greater(Value val1, Value val2)
    { 
        return new Value(val1.numVal > val2.numVal);
    }
    
    public static Value GreaterOrEqual(Value val1, Value val2)
    { 
        return new Value(val1.numVal >= val2.numVal);
    }

    
    public static Value Or(Value val1, Value val2)
    { 
        return new Value(val1.boolVal || val2.boolVal);
    }
    
    public static Value And(Value val1, Value val2)
    { 
        return new Value(val1.boolVal && val2.boolVal);
    }
    
    public static Value Not(Value val1)
    { 
        return new Value(!val1.boolVal);
    }
}