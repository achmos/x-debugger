package interpreter;

import interpreter.debugger.DebugByteCodeLoader;
import interpreter.debugger.DebugVirtualMachine;
import interpreter.debugger.LineEntry;
import interpreter.debugger.SourceLoader;
import interpreter.debugger.ui.DebugUI;
import java.io.IOException;
import java.util.Vector;
/**
 * <pre>
 * 
 *  
 *   
 *     Interpreter class runs the interpreter:
 *     1. Perform all initializations
 *     2. Load the bytecodes from file
 *     3. Run the virtual machine
 *     
 *   
 *  
 * </pre>
 */
public class Interpreter {
	private ByteCodeLoader bcl;
        
	public Interpreter() {
            CodeTable.init();
	}

	void run(String args []) {
            try {
                if (args[0].matches("-d")) { 
                    //if we are to run in debug
                    String codeFile = args[1] + ".x.cod";
                    String sourceFile = args[1] + ".x";
                    
                    SourceLoader sl = new SourceLoader(sourceFile);
                    Vector<LineEntry> sources = sl.loadSource();
                    
                    bcl = new DebugByteCodeLoader(codeFile);
                    Program program = bcl.loadCodes();
                    DebugVirtualMachine dvm = new DebugVirtualMachine(program,sources);
                    
                    DebugUI ui = new DebugUI(dvm);
                    System.out.println("******Debugging " + sourceFile + " *******");
                    ui.debug();
                } else { 
                    //else we run in interpreter mode. 
                    bcl = new ByteCodeLoader(args[0]);
                    Program program = bcl.loadCodes();
                    VirtualMachine vm = new VirtualMachine(program);
                    vm.executeProgram();
                }
            } catch (IOException e) {
                System.out.println("**** " + e);
            }
	}

	public static void main(String args[]) {
		if (args.length == 0) {
			System.out.println("***Incorrect usage, try: java interpreter.Interpreter <file>");
                        System.out.println("or java interpreter.Interpreter -d <file> for debug mode");
			System.exit(1);
		}
                (new Interpreter()).run(args);   
	}
}