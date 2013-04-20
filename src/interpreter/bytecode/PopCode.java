package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.Vector;

/**
 * Pop removes the top N items from the run time stack
 * @author Ramin
 */
public class PopCode extends PrintableByteCode {
    protected int n;
    
    @Override
    public void execute(VirtualMachine M) {
        for (int i = 0; i < n; i++)
            M.popRunStack();
    }
    @Override
    public void init(Vector<String> v) {
        n = Integer.parseInt(v.firstElement());
    }
    @Override
    public String showByteCode() {
        return String.format("POP %d", n);
    }
}
