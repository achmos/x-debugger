package interpreter.bytecode.debuggerByteCodes;

import interpreter.VirtualMachine;
import interpreter.bytecode.ReturnCode;
import interpreter.debugger.DebugVirtualMachine;

/**
 * Version of ReturnCode used by the debugger.
 * @author Ramin
 */
public class ReturnCodeDebug extends ReturnCode {
    @Override
    public void execute(VirtualMachine VM) {
        DebugVirtualMachine DVM = (DebugVirtualMachine)VM;
        
        if (DVM.CheckTrace())
            System.out.println(DVM.OutputTraceExit());
        
        super.execute(VM);
        DVM.CheckStepBreaks(); //check if we need to break;
    }
}
