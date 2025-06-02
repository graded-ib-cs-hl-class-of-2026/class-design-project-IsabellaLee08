import java.io.File; 
import java.io.FileNotFoundException; 
import java.io.PrintWriter; 
import java.io.IOException; 
import java.util.Scanner; 

/** Edits the txt file */
public class Printer {
    private Scanner in = new Scanner(System.in); /**reads user input*/
    private Scanner fileInput;  /**reads from the file*/
    private File file;  // represents the file

    /**opens the file and prepares to read from it*/
    public void openFile(String filename) throws FileNotFoundException {
        file = new File(filename);  /** new file object */
        fileInput = new Scanner(file);  /**links the scanner to the object */
    }

    /** closes and clears file */
    public void closeFile() {
        if (fileInput != null) {
            fileInput.close();  // stop reading file
        }
        file = null;  // clear file object
        fileInput = null;  // clear scanner
    }

    /** checks if file has more lines to read */
    public boolean fileHasNextLine() {
        return fileInput != null && fileInput.hasNextLine();
    }

    /**gets the next line from the file */ 
    public String getNextLine() {
        if (fileHasNextLine()) {
            return fileInput.nextLine();  
        } else {
            return ""; 
        }      
    }

    /** prints a message to the console */ 
    public void output(String s) {
        System.out.println(s);  
    }

    /** gets input from the user */
    public String input() {
        return in.nextLine();/**returns what user typed */
    }

    /** reads all lines from the txt file and returns them as an array of Strings */
    public String[] readAllLines(String filename) throws FileNotFoundException {
        openFile(filename); 

        /** count how many lines there are*/
        int count = 0;
        while (fileHasNextLine()) {
            getNextLine(); 
            count++;  
        }
        closeFile();

        openFile(filename);  
        String[] lines = new String[count]; /** array for lines */
        int index = 0;
        while (fileHasNextLine()) {
            lines[index++] = getNextLine(); /** stores each line */
        }
        closeFile();  

        return lines;  
    }

    /** saves the full string into the file*/
    public void writeStringToFile(String filename, String content) {
        try (PrintWriter writer = new PrintWriter(new File(filename))) {
            writer.print(content);  // write everything to the file
        } catch (IOException e) {
            System.out.println("Error saving file.");  /** show error if it can't save for whatever reason*/
        }
    } 
    }

