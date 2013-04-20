package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.Vector;

/**
 * Return causes the virtual machine to return to the previous
 * location in the bytecode program and continue execution
 * @author Ramin
 */
public class ReturnCode extends PrintableByteCode {
    String label;
    
    @Override
    public void execute(VirtualMachine M) {
        M.returnToLastAddr();
    }

    @Override
    public void init(Vector<String> v) {
        if (v.size() == 1)
            label = v.firstElement();
        else 
            label = "";
    }
    @Override
    public String showByteCode() {
        String temp = String.format("RETURN");
        if (!label.matches("")) {
            int index = label.indexOf("<");
            if (index == -1)
                index = label.length();
            String funcname = label.substring(0, index);
            temp += String.format(" %s   exit %s: ", label, funcname);
        }
        return temp;
    }
}
