package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.Vector;

/**
 * Lit stores a literal value on top of the run time stack.
 * @author Ramin
 */
public class LitCode extends PrintableByteCode {
    protected int value; 
    protected String id;
    
    @Override
    public void execute(VirtualMachine M) {
        M.pushRunStack(value);
    }

    @Override
    public void init(Vector<String> v) {
        value = Integer.parseInt(v.firstElement());
        if (v.size() == 2)
            id = v.elementAt(1);
        else 
            id = "";
    }
    @Override
    public String showByteCode() {
        String temp = String.format("LIT %d",value);
        if (!id.matches(""))
            temp += String.format(" %s   int %s",id,id);
        return temp;
    }
}
