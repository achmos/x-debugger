package interpreter;

import java.util.Stack;
import java.util.Vector;

/**
 * RunTimeStack contains and keeps track of the stack
 * for the x virtual machine.
 */
public class RunTimeStack {
    private Stack<Integer> framePointers;
    private Vector<Integer> runStack;
/*
 * Create a new runTimeStack object
 */
    public RunTimeStack() {
        runStack = new Vector<Integer>();
        framePointers = new Stack<Integer>();
        framePointers.push(0);
    }
/**
 * Dump the contents of the runtime stack to the screen.
 */
    public void dump() {
        int i, j = 0;

        System.out.printf("[");        
        for (i = 0; i < runStack.size(); i++) {
            if (j < framePointers.size() - 1) {
                if (framePointers.elementAt(j) == framePointers.elementAt(j+1)) {
                    System.out.printf("] [");
                    j++;
                }
            }
            System.out.printf("%d",runStack.elementAt(i).intValue());
            if ( (j < framePointers.size() - 1  ) &&
                    (framePointers.elementAt(j+1) == (i+1))) 
            {
                System.out.printf("] [");
                j++;
            } else if (i != runStack.size() - 1 ) {
                System.out.printf(",");
            }
        }   
        System.out.printf("] \n");
    }
    /**
     * Return the value at the top of the RunTimeStack.
     * @return value at the top of the stack.
     */
    public int peek() {
        return runStack.lastElement().intValue();
    }
    /**
     * Remove the top item of the RunTimeStack.
     * @return the value just removed from the stack.
     */
    public int pop() {
        if (!runStack.isEmpty()) {
            if (framePointers.peek() != runStack.size())
                return runStack.remove(runStack.size() - 1).intValue();
            else {
                System.out.println("Error: cannot pop past frame boundary.");
                return -1;
            }
        } else {
            System.out.println("Error: Stack is empty, cannot pop");
            return -1;
        }
    }
    /**
     * Push an int onto the RunTimeStack.
     * @param i The int to be pushed.
     * @return The int just pushed onto the stack.
     */
    public int push(int i) {
        return push(Integer.valueOf(i)).intValue();
    }
    /**
     * Push an Integer onto the RunTimeStack.
     * @param i The Integer to be pushed.
     * @return The Integer just pushed onto the stack.
     */
    public Integer push(Integer i) {
        runStack.add(i);
        return runStack.lastElement();
    }
    /**
     * Start a new frame at the offset given.
     * @param offset The offset where the new frame will start.
     */
    public void newFrameAt(int offset) {
        framePointers.add(runStack.size() - offset);
    }
    /**
     * Returns the size of the top frame on the RunTimeStack.
     * @return an integer size of the current frame.
     */
    public int getCurrentFrameSize() {
        return runStack.size() - framePointers.peek();
    }
    /**
     * Remove the top frame of the RunTimeStack.
     */
    public void popFrame() { 
        int temp = pop();
        
        while (framePointers.peek() < runStack.size()) 
            pop();
        framePointers.pop();        
        push(temp);
    }
    /**
     * Store the top of the RunTimeStack into the 
     * location specified by offset. 
     * @param offset location to store the value.
     * @return the value just stored.
     */
    public int store(int offset) {
        int temp = pop();
        runStack.setElementAt(temp, framePointers.peek() + offset);
        return temp;
    }
    /**
     * Load a value onto the top of the RunTimeStack 
     * from the specified location.
     * @param offset location to load from.
     * @return the value just loaded.
     */
    public int load(int offset) {
        int temp = runStack.elementAt(framePointers.peek() + offset);
        return push(temp);
    }
    /**
     * Returns the value of the RunTimeStack at the offset of the 
     * current frame. 
     * @param offset location to get the value from. 
     * @return the value at the specified offset. 
     */
    public int valueAtOffset(int offset) {
        return runStack.elementAt(framePointers.peek() + offset).intValue();
    }
}
