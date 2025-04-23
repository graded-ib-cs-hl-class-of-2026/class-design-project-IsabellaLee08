import java.util.List;
import java.util.Scanner;
import java.io.*;
/* Edits and interacts with the txt file */
public class Printer {
    private Scanner in = new Scanner (System.in);
    private Scanner fileInput; 
    private File file;
    public void openFile(String filename) throws FileNotFoundException {/*Tries to open the file with the given filename so we can read from it. */
        file = new File(filename);
        fileInput = new Scanner(file);
    }

    public void closeFile() {/* Closes file by setting file and fileinput to null since we dont need it anymore */
        fileInput.close();
        file = null;
        fileInput = null;
    }
    /*checks if file has a next line to read */
    public boolean fileHasNextLine() {
        if (fileInput == null) {
            return false;
        }else {
            return fileInput.hasNextLine();
        }
    }
    /* Read next line in file */
    public String getNextLine() {
        if (fileHasNextLine()) {
            return fileInput.nextLine();
        }else {
            return "";
        }      
    }

    public void output(String s) {/*Print the message to terminal*/
        System.out.println(s);
    }
    /*reads user input */
    public String input() {
        return in.nextLine();
    }
    /*Saves edits to the file */
    public void saveFlashcards(String filename, List<Flashcard> flashcard) {
        try (PrintWriter writer = new PrintWriter(new File(filename))) {
            for (Flashcard card : flashcard) {/*Loops through the flashcards */
                writer.println(card.toFileString());/*Writes to the file */
            }
            System.out.println("Flashcards saved.");
        } catch (IOException e) {/*Prints error if there is one */
            System.out.println("Error saving flashcards.");
            
            
        }
        
        
    }
    

}
