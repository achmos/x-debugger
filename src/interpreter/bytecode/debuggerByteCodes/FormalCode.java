package interpreter.bytecode.debuggerByteCodes;

import interpreter.VirtualMachine;
import interpreter.debugger.DebugVirtualMachine;
import java.util.Vector;

/**
 * FormalCode adds to the symbol table a variable that 
 * was passed into the current function.
 * @author Ramin
 */
public class FormalCode extends HeaderCode {
    private int offset; 
    private String id;
    
    @Override
    public void execute(VirtualMachine M) {
        DebugVirtualMachine dvm = (DebugVirtualMachine)M;
        
        dvm.addSymbol(id, offset);
        super.execute(M);
    }
    @Override
    public void init(Vector<String> v) {
        id = v.firstElement();
        offset = Integer.parseInt(v.elementAt(1));
    }
}
