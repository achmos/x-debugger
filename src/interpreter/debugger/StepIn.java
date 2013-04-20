package interpreter.debugger;

/**
 * StepIn causes the DebugVirtualMachine to break as son as we
 * step into a function. If there is no function call on this line, 
 * then we just perform a step over. 
 * @author Ramin
 */
public class StepIn extends StepObject {
    private int stackSize;
    private int lineNum; 
    
    StepIn(int currSize, int line) {
        lineNum = line;
        stackSize = currSize;
    }
    
    @Override
    public void CheckBreakCondition(DebugVirtualMachine DebugVM) {
        int size = DebugVM.getRecordsSize();
        boolean hasHeaders = DebugVM.isNextCodeFuncHeader();
        
        //check for stepping in
        if (stackSize < size && !hasHeaders)
            DebugVM.setBreak();
        //or should we just step over?
        else if (lineNum != DebugVM.getCurrentLine()&& !hasHeaders)
            DebugVM.setBreak();
    }
}
