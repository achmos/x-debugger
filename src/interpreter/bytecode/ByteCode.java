package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.Vector;
/**
 * Bytecode is an abstract base class for all the bytecode 
 * that run on the X virtual machine.
 * @author Ramin
 */
public abstract class ByteCode {
    public abstract void execute( VirtualMachine M);
    public abstract void init( Vector<String> v);
}