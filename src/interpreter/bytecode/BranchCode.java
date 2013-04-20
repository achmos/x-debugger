package interpreter.bytecode;

import java.util.Vector;

/**
 * BranchCode implements whats needed for branching bytecodes, 
 * but leaves out the execute and showByteCode methods, as 
 * that is bytecode specific.
 * @author Ramin
 */
public abstract class BranchCode extends PrintableByteCode {
    protected String label;
    protected int addr;
    
    public String getLabel() {
        return label;
    }
    @Override
    public void init(Vector<String> v) {
        try {
            addr = Integer.parseInt(v.firstElement());
        } catch (Exception e) {
            label = v.firstElement();
        }
    }
}
