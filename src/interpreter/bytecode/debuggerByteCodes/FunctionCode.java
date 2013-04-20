package interpreter.bytecode.debuggerByteCodes;

import interpreter.VirtualMachine;
import interpreter.debugger.DebugVirtualMachine;
import java.util.Vector;

/**
 * FunctionCode sets the current function in the DebugVirtualMachine
 * @author Ramin
 */
public class FunctionCode extends HeaderCode {
    private String funcname;
    private int startLine;
    private int endLine;
    
    @Override
    public void execute(VirtualMachine M) {
        DebugVirtualMachine dvm = (DebugVirtualMachine)M;
        dvm.setCurrentFunction(funcname, startLine, endLine);
        
        if (dvm.CheckTrace())
            System.out.println(dvm.OutputTraceEntry());
        super.execute(M);
    }

    @Override
    public void init(Vector<String> v) {
        funcname = v.firstElement();
        startLine = Integer.parseInt(v.elementAt(1));
        endLine = Integer.parseInt(v.elementAt(2));
    }
    
}
