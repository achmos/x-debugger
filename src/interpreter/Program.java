package interpreter;

import interpreter.bytecode.BranchCode;
import interpreter.bytecode.ByteCode;
import interpreter.bytecode.LabelCode;
import interpreter.bytecode.debuggerByteCodes.LineCode;
import java.util.HashMap;
import java.util.Vector;

/**
 * Program stores the bytecodes of a bytecode program.
 * Program also performs address resolution on all program
 * jumps.
 * @author Ramin
 */
public class Program {
    private Vector<ByteCode> programCodes;    
/**
 * Create a program object
 */        
    public Program() {
        programCodes = new Vector<ByteCode>();
    }
/**
 * Store a bytecode into the program object.
 * @param b object to be added
 */    
    public void AddCode(ByteCode b) {
            programCodes.add(b);
    }
/**
 * Return the bytecode at index i of the program.
 * @param i index of the bytecode needed
 * @return a ByteCode object
 */    
    public ByteCode getCode(int i) {
        return programCodes.get(i);
    }
/**
 * Resolve address for all the branching bytecodes.
 */    
    public void ResolveAddresses() {
    HashMap<String,Integer> labels = new HashMap<String,Integer>();
    Vector<BranchCode> branches = new Vector<BranchCode>();

        for (ByteCode b: programCodes) {
            if (b instanceof LabelCode) {
                LabelCode lcode = (LabelCode) b;
                String labelName = lcode.getLabelName();
                labels.put(labelName,programCodes.indexOf(b));
            } else if (b instanceof BranchCode)
                branches.add((BranchCode)b);
        }
        
        for (BranchCode bcode: branches) {
            String label;
            Vector<String> vec = new Vector<String>();
            label = bcode.getLabel();
            String num = Integer.toString(labels.get(label));
            vec.add(num);
            bcode.init(vec);
        }
    }
    /**
     * Creates a HashMap of all the breakable lines in a program
     * @return a HashMap containing Integer keys and Boolean objects.
     */
    public HashMap<Integer,Boolean> getBreakableLines() {
        HashMap<Integer,Boolean> lines = new HashMap<Integer,Boolean>();
        
        for (ByteCode b: programCodes) {
            if (b instanceof LineCode) {
                LineCode lcode = (LineCode) b;
                int line = lcode.getNumber();
                if (line != -1)
                    lines.put(line, Boolean.TRUE);
            }
        }
        return lines;
    }
}