package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.Vector;

/**
 * ArgsCode requests the virtual machine to create a stack
 * frame of N items.
 * @author Ramin
 */
public class ArgsCode extends PrintableByteCode {
    private int argsCount;
    
    @Override
    public void execute(VirtualMachine M) {
        M.newFrame(argsCount);
    }

    @Override
    public void init(Vector<String> v) {
        argsCount = Integer.parseInt(v.firstElement());
    }
    @Override
    public String showByteCode() {
        return String.format("ARGS %d", argsCount);
    }
}
