package interpreter.bytecode;

/**
 * PrintableByteCode is an abstract base class that used 
 * is to tell the difference from a dump-able bytecode and 
 * a non-dump-able bytecode.
 * @author Ramin
 */
public abstract class PrintableByteCode extends ByteCode {
    public abstract String showByteCode();
}
