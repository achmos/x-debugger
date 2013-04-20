package interpreter.debugger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

/**
 * SourceLoader loads the source file into the debugger as 
 * a vector of LineEntries.
 * @author Ramin
 */
public class SourceLoader {
    private BufferedReader sourceFile;
    /**
     * Construct a new SourceLoader
     * @param source Name of the source file to load
     * @throws IOException - Thrown if the file does not exist.
     */
    public SourceLoader(String source) throws IOException {
        sourceFile = new BufferedReader(new FileReader(source));
    }
    /**
     * Loads the source file.
     * @return a Vector of LineEntry objects, each containing
     * a line of the source file. 
     */
    public Vector<LineEntry> loadSource() {
        Vector<LineEntry> srcEntries = new Vector<LineEntry>();
        try {
            while(sourceFile.ready()) {
                String line = sourceFile.readLine();
                LineEntry entry = new LineEntry(line);
                srcEntries.addElement(entry);
            }
        } catch (IOException e) {
            System.out.println("Error in reading source file.");
        }    
        return srcEntries;
    }
}
