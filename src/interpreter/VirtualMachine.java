package interpreter;

import interpreter.bytecode.*;
import java.util.Stack;

/**
 * VirtualMachine is a virtual computer used to run X
 * bytecode programs.
 */
public class VirtualMachine {
    protected RunTimeStack runStack;
    protected int pc;
    protected Stack<Integer> returnAddr;
    protected boolean isRunning;
    protected Program program; 
    private boolean dump;
/**
 * Construct a new Virtual Machine object
 * @param p Program object to run
 */    
    public VirtualMachine(Program p) {
        program = p;
    }
/**
 * Executes the Program object that was passed in
 * to constructor for this Virtual Machine
 */    
    public void executeProgram() {
        dump = false;
        pc = 0;
        runStack = new RunTimeStack();
        returnAddr = new Stack<Integer>();
        isRunning = true;
        while (isRunning) {
            ByteCode code = program.getCode(pc);
            code.execute(this);
            if (dump){
                dumpCode(code);
                runStack.dump();
            }
            pc++;
        }
    }
/**
 * Dump dumps the current state of the virtual machine to the screen. 
 * @param bc Bytecode currently executing.
 */
    private void dumpCode(ByteCode bc) {
        if (bc instanceof PrintableByteCode) {
            PrintableByteCode pbc = (PrintableByteCode)bc;
            String str = pbc.showByteCode();
            
            /*
             * horrible to use this, but can't figure out how to
             * print all the information for these specific 
             * bytecodes without access to the VM somehow.
             */
            if (pbc instanceof CallCode) {
                str += String.format("(");
                int count = runStack.getCurrentFrameSize();
                
                //output the function arguments
                for (int i = 0; i < count; i++) {
                    str += String.format("%s", runStack.valueAtOffset(i));
                    if (i != (count - 1))
                        str += String.format(",");
                }
                str += String.format(")");
            }
            else if (pbc instanceof StoreCode) {
                str += String.format("%d",runStack.peek());
            }
            else if (pbc instanceof ReturnCode) {
                if (str.length() > 6)
                    str += String.format("%d",runStack.peek());
            }
            System.out.println(str);
        }
    } 
/**
 * Tells the virtual machine to stop running
 * the program.
 */
    public void StopProgram() {
        isRunning = false;
    }
/**
 * request the virtual machine to pop the top
 * of the runtime stack.
 * @return the top of the run time stack before it is popped
 */
    public int popRunStack() {
        return runStack.pop();
    }
/**
 * push an integer value onto the virtual machine's
 * run time stack.
 * @param i value to push onto the stack
 * @return the value just pushed
 */
    public int pushRunStack(int i) {
        return runStack.push(i);
    }
/**
 * request the virtual machine's run time stack
 * to create a new activation record with n number
 * of arguments for the new record
 * @param argsCount the number of arguments needed for a new record
 */
    public void newFrame(int argsCount) {
        runStack.newFrameAt(argsCount);
    }
/**
 * @param offset
 * @return the value  loaded into the stack
 */
    public int loadStack(int offset) {
        return runStack.load(offset);
    }
/**
 * returns the current value of the top of the virtual
 * machine's run time stack
 * @return integer value of the top of the stack
 */
    public int getTopRunStack() {
        return runStack.peek();
    }
/**
 * Branch to a new function in the program currently running.
 * @param addr
 */
    public void FuncBranch(int addr){
        returnAddr.push(pc);
        branchTo(addr);
    }
/**
 * Branch to another part of the program currently running.
 * @param addr
 */
    public void branchTo(int addr) {
        pc = addr - 1;
    }
/**
 * returnToLastAddr goes back to the previous address before this
 * current function was called.
 */
    public void returnToLastAddr() {
        pc = returnAddr.pop();
        runStack.popFrame();
    }
/**
 * Request the virtual machine to dump debug
 * information after each bytecode execution.
 */
    public void dumpOn() {
        dump = true;
    }
/**
 * Request the virtual machine to stop debug output.
 */
    public void dumpOff() {
        dump = false;
    }
/**
 * Tell the virtual machine to store a value into the 
 * run time stack. 
 * @param offset location to store data
 */
    public void store(int offset) {
        runStack.store(offset);
    }
}