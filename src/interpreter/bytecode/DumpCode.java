package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.Vector;

/**
 * Dump either sets or removes the dump flag on the 
 * virtual machine
 * @author Ramin
 */
public class DumpCode extends ByteCode {
    String dump;
    
    @Override
    public void execute(VirtualMachine M) {
        if ("ON".equals(dump))
            M.dumpOn();
        else
            M.dumpOff();
    }

    @Override
    public void init(Vector<String> v) {
        dump = v.firstElement();
    }
}
