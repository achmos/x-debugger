package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.Vector;

/**
 * Load takes the value of the item at the offset 
 * of the current frame and copies it to the top
 * of the run time stack
 * @author Ramin
 */
public class LoadCode extends PrintableByteCode {
    private int offset;
    private String id;
    
    @Override
    public void execute(VirtualMachine M) {
        M.loadStack(offset);
    }
    @Override
    public void init(Vector<String> v) {
        offset = Integer.parseInt(v.firstElement());
        id = v.elementAt(1);
    }
    @Override
    public String showByteCode() {
        return String.format("LOAD %d %s   <load %s>", offset,id,id);
    }
}
