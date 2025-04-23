import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {

    public void start() {
        try {
            Scanner fileScanner = new Scanner(new File("flashcards.txt"));
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine(); 
                String[] parts = line.split(":", 3); 
                if (parts.length >= 2) {
                    String word = parts[0].trim();
                    String definition = parts[1].trim();
                    String studiedStatus = parts.length == 3 ? parts[2].trim() : "false";
                    System.out.println("Word: " + word + ", Definition: " + definition + ", Studied: " + studiedStatus);
                }
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    public static void main(String[] args) {
        new App().start();
    }
}