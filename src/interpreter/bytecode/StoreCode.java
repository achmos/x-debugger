package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.Vector;

/**
 * Store takes the top of the run time stack and store 
 * it at the offset of the current stack frame.
 * @author Ramin
 */
public class StoreCode extends PrintableByteCode {
    private int offset;
    private String id;
    
    @Override
    public void execute(VirtualMachine M) {
        M.store(offset);
    }
    @Override
    public void init(Vector<String> v) {
        offset = Integer.parseInt(v.firstElement());
        if (v.size() == 2)
            id = v.elementAt(1);
    }
    @Override
    public String showByteCode() {
        return String.format("STORE %d %s   %s = ",offset, id, id);
    }
}