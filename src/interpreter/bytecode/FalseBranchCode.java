package interpreter.bytecode;

import interpreter.VirtualMachine;

/**
 * Falsebranch jumps to a different location in the 
 * program if the top of the stack evaluates to false. 
 * @author Ramin
 */
public class FalseBranchCode extends BranchCode {
    @Override
    public void execute(VirtualMachine M) {
        int temp = M.popRunStack();
        if (temp == 0)
            M.branchTo(addr);
    } 
    @Override
    public String showByteCode() {
        return String.format("FALSEBRANCH %s", label);
    }
}
