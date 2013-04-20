package interpreter;

import java.util.HashMap;

/**
 * CodeTable maps bytecode names to classes that 
 * represent the bytecodes in the interpreter.
 */
public class CodeTable {    
    private static HashMap<String,String> codes;
    
    private CodeTable() {}
/**
 * initialize the CodeTable in order for it to be usable
 */
    public static void init() {
        codes = new HashMap<String,String>();
        
        codes.put("ARGS", "ArgsCode");
        codes.put("BOP", "BopCode");
        codes.put("CALL", "CallCode");
        codes.put("FALSEBRANCH", "FalseBranchCode");
        codes.put("GOTO", "GotoCode");
        codes.put("HALT", "HaltCode");
        codes.put("LABEL", "LabelCode");
        codes.put("LIT", "LitCode");
        codes.put("LOAD", "LoadCode");
        codes.put("POP", "PopCode");
        codes.put("READ", "ReadCode");
        codes.put("RETURN", "ReturnCode");
        codes.put("STORE", "StoreCode");
        codes.put("WRITE", "WriteCode");
        codes.put("DUMP", "DumpCode");
        codes.put("LINE", "LineCode");
        codes.put("FUNCTION", "FunctionCode");
        codes.put("FORMAL", "FormalCode");
    }
/**
 * Retrieve the bytecode class name associated with a bytecode.
 * 
 * @param bytecode representing the bytecode name
 * @return String containing the name of the bytecode class
 */
    public static String get(String bytecode) {
        return codes.get(bytecode);
    }
}