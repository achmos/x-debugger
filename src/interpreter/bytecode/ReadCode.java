package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.Scanner;
import java.util.Vector;

/**
 * Read reads an input from the keyboard and stores 
 * it on the top of the run time stack. 
 * @author Ramin
 */
public class ReadCode extends PrintableByteCode {
    @Override
    public void execute(VirtualMachine M) {
        int input;
        Scanner scan = new Scanner(System.in);
        System.out.printf("=>: ");
        input = scan.nextInt();
        M.pushRunStack(input);
    }

    @Override
    public void init(Vector<String> v) {
        //read bytecode has no args
    }
    @Override
    public String showByteCode() {
        return String.format("READ");
    }
}
