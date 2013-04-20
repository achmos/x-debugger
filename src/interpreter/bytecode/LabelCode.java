package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.Vector;

/**
 * Label puts a unique name to a location in the program. 
 * Branching bytecodes jump to label bytecodes.
 * @author Ramin
 */
public class LabelCode extends PrintableByteCode {
    private String labelName;
    
    @Override
    public void execute(VirtualMachine M) {
        //Empty bytecode execute body
    }

    @Override
    public void init(Vector<String> v) {
        labelName = v.firstElement();
    }
    
    public String getLabelName() {
        return labelName;
    }
    @Override
    public String showByteCode() {
        return String.format("LABEL %s", labelName);
    }
}
