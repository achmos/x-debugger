package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.Vector;

/**
 * BOP evaluates a binary operator on the top two items
 * of the runtime stack. Order of the two items matter 
 * for the operator.
 * @author Ramin
 */
public class BopCode extends PrintableByteCode {
    String op;
    
    @Override
    public void execute(VirtualMachine M) {
        int secondLevel, topLevel;
        
        topLevel = M.popRunStack();
        secondLevel = M.popRunStack();
        
        //addition
        if ("+".equals(op)) {
            M.pushRunStack(secondLevel + topLevel);
        }
        //subtraction
        if ("-".equals(op)) {
            M.pushRunStack(secondLevel - topLevel);
        }
        //multiplication
        if ("*".equals(op)) {
            M.pushRunStack(secondLevel * topLevel);
        }
        //division
        if ("/".equals(op)) {
            M.pushRunStack(secondLevel / topLevel);
        }
        //equality
        if ("==".equals(op)) {
            if (secondLevel == topLevel)
                M.pushRunStack(1);
            else 
                M.pushRunStack(0);
        }
        //not equal
        if ("!=".equals(op)) {
            if (secondLevel != topLevel)
                M.pushRunStack(1);
            else 
                M.pushRunStack(0);
        }
        //less than or equal
        if ("<=".equals(op)) {
            if (secondLevel <= topLevel)
                M.pushRunStack(1);
            else 
                M.pushRunStack(0);
        }
        //greater than
        if (">".equals(op)) {
            if (secondLevel > topLevel)
                M.pushRunStack(1);
            else 
                M.pushRunStack(0);
        }
        //greater than or equal
        if (">=".equals(op)) {
            if (secondLevel >= topLevel)
                M.pushRunStack(1);
            else 
                M.pushRunStack(0);
        }
        //less than
        if ("<".equals(op)) {
            if (secondLevel < topLevel)
                M.pushRunStack(1);
            else 
                M.pushRunStack(0);
        }
        //or
        if ("|".equals(op)) {
            if (secondLevel > 0 || topLevel > 0)
                M.pushRunStack(1);
            else 
                M.pushRunStack(0);
        }
        //and
        if ("&".equals(op)) {
            if (secondLevel > 0 && topLevel > 0)
                M.pushRunStack(1);
            else 
                M.pushRunStack(0);
        }
    }

    @Override
    public void init(Vector<String> v) {
        op = v.firstElement();
    }
    @Override
    public String showByteCode() {
        return String.format("BOP %s", op);
    }
}
