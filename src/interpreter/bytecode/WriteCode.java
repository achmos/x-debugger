package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.Vector;

/**
 * Write outputs the top of the run time stack to the screen
 * @author Ramin
 */
public class WriteCode extends PrintableByteCode {

    @Override
    public void execute(VirtualMachine M) {
        System.out.println(M.getTopRunStack());
    }

    @Override
    public void init(Vector<String> v) {
        //write has no arguments
    }
    @Override
    public String showByteCode() {
        return String.format("WRITE");
    }
}
