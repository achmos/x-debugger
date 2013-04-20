package interpreter;

import interpreter.bytecode.ByteCode;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 * Creates a Program object loaded with the bytecodes of the program.
 */
public class ByteCodeLoader {
    private BufferedReader bcFile;
/**
 * Construct a new ByteCodeLoader
 * 
 * @param codeFile contains the name of the bytecode file
 * @exception IOException - thrown for an IO error when reading the bytecode file
 */    
    public ByteCodeLoader(String codeFile) throws IOException {
        bcFile = new BufferedReader( new FileReader(codeFile) );
    }
/**
 * Reads the bytecode file and construct the bytecodes appropriately. 
 * Then returns a Program object representing the bytecode file
 * 
 * @return A Program object. 
 */    
    public Program loadCodes() {
        Program prog = new Program();
        ByteCode code;
        StringTokenizer tokenizer;
        String ClassName, codeName, line; 
        Vector<String> args;
        
         do {
            try {
                //break from loop if end of file
                if (!bcFile.ready())
                    break;

                line = bcFile.readLine();
                tokenizer = new StringTokenizer(line);
                
                //get the byecode name and create the bytecode
                codeName = tokenizer.nextToken();
                ClassName = getClassName(codeName);
                code = (ByteCode)(Class.forName("interpreter.bytecode."+ClassName).newInstance());
                
                //get the auguments for the bytecode
                args = new Vector<String>();
                while (tokenizer.hasMoreTokens()) 
                    args.add(tokenizer.nextToken()); 

                code.init(args);
                prog.AddCode(code);
            } catch (Exception e) {
                //System.out.println("Error in ByteCodeLoader: " + e.getMessage());
            }
        } while (true);
        
        prog.ResolveAddresses();
        return prog;
    }
    /**
     * Get the class name of this bytecode.
     * @param codeName name of the ByteCode
     * @return the name of the class representing 
     * the bytecode in the interpreter.
     */
    public String getClassName(String codeName) {
        return CodeTable.get(codeName);
    }
}
