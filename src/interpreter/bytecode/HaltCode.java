package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.Vector;

/**
 * Halt stops the virtual machine execution.
 * @author Ramin
 */
public class HaltCode extends PrintableByteCode {

    @Override
    public void execute(VirtualMachine M) {
        M.StopProgram();
    }

    @Override
    public void init(Vector<String> v) {
        //Halt takes no args
    }
    @Override
    public String showByteCode() {
        return String.format("HALT");
    }
}
