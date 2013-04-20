package interpreter.bytecode.debuggerByteCodes;

import interpreter.VirtualMachine;
import interpreter.bytecode.PopCode;
import interpreter.debugger.DebugVirtualMachine;

/**
 * Version of the Pop Bytecode used by the Debugger. 
 * @author Ramin
 */
public class PopCodeDebug extends PopCode {
    @Override
    public void execute(VirtualMachine vm){ 
        super.execute(vm);
        DebugVirtualMachine dvm = (DebugVirtualMachine)vm;
        dvm.removeSymbols(n);
    }
}
