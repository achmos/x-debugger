package interpreter.bytecode;

import interpreter.VirtualMachine;

/**
 * Call makes the virtual machine jump to a new function in
 * the program.
 * @author Ramin
 */
public class CallCode extends BranchCode {
    @Override
    public void execute(VirtualMachine M) {
        M.FuncBranch(addr);
    }
    @Override
    public String showByteCode() {
        int index = label.indexOf("<");
        if (index == -1)
            index = label.length();
        String funcname = label.substring(0, index);
        return String.format("CALL %s   %s",label, funcname);
    }
}
