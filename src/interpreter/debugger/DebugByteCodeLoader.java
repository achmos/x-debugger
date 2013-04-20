package interpreter.debugger;

import interpreter.ByteCodeLoader;
import interpreter.CodeTable;
import java.io.IOException;

/**
 * ByteCodeLoader used by the Debugger. 
 * @author Ramin
 */
public class DebugByteCodeLoader extends ByteCodeLoader {
    /**
     * Construct a new DebugByteCodeLoader.
     * @param bcfile contains the name of the bytecode file
     * @throws IOException - thrown for an IO error when reading the bytecode file
     */
    public DebugByteCodeLoader(String bcfile) throws IOException {
        super(bcfile);
    }
    
    @Override
    public String getClassName(String codeName) {
        String className = CodeTable.get(codeName);
        
        if (codeName.matches("FORMAL|LINE|FUNCTION|POP|LIT|RETURN")) {
            className = "debuggerByteCodes." + className;
            if (codeName.matches("POP|LIT|RETURN"))
                className += "Debug";
        }
        return className;
    }
}
