package interpreter.bytecode.debuggerByteCodes;
import interpreter.VirtualMachine;
import interpreter.bytecode.ByteCode;
import interpreter.debugger.DebugVirtualMachine;

/**
 * HeaderCode is an Abstract class that is used to tell the 
 * difference between Header ByteCodes of a Function and 
 * the regular ByteCodes.
 * @author Ramin
 */
abstract public class HeaderCode extends ByteCode {
    @Override
    public void execute(VirtualMachine VM) {
        DebugVirtualMachine DVM = (DebugVirtualMachine) VM;
        DVM.CheckStepBreaks();
    }
}
