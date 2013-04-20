package interpreter.bytecode;

import interpreter.VirtualMachine;

/**
 * Goto jumps to a location in the program indicated
 * by label
 * @author Ramin
 */
public class GotoCode extends BranchCode {
    @Override
    public void execute(VirtualMachine M) {
        M.branchTo(addr);        
    }
    @Override
    public String showByteCode() {
        return String.format("GOTO %s", label);
    }
}
