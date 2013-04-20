package interpreter.bytecode.debuggerByteCodes;

import interpreter.VirtualMachine;
import interpreter.bytecode.LitCode;
import interpreter.debugger.DebugVirtualMachine;


/**
 * Version of the Lit Bytecode used by the debugger.
 * @author Ramin
 */
public class LitCodeDebug extends LitCode {
    @Override
    public void execute(VirtualMachine vm){ 
        super.execute(vm);
        DebugVirtualMachine dvm = (DebugVirtualMachine)vm;
        if (!id.equals(""))
            dvm.addLocal(id);
    }
}
