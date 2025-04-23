import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class App {
    /*loads the flashcards from flashcard.txt*/
    private List<Flashcard> loadFlashcards(String filename) {
        List<Flashcard> flashcards = new ArrayList<>();/*stores flashcard object*/
        try {
            Scanner fileScanner = new Scanner(new File(filename));
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine(); 
                String[] parts = line.split(":", 3); /*splits the line in the txt by :, separating word, definition, and studied */

                if (parts.length >= 2) {
                    String word = parts[0].trim(); /*https://www.w3schools.com/java/ref_string_trim.asp --> parts[0] is the word, trim removes the white space from the string*/
                    String definition = parts[1].trim();
                    String studiedStatus = parts.length == 3 ? parts[2].trim() : "false";
                    boolean studied = Boolean.parseBoolean(studiedStatus);
                    flashcards.add(new Flashcard(word, definition, studied));
                }
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");/*In case there isn't a file to read */
        }

        return flashcards;/*returns the list of flashcards */
    }
    /*Runs the actual flashcard and user input */
    public void start() {
        Scanner scanner = new Scanner(System.in);
        Printer printer = new Printer();
        List<Flashcard> flashcards = loadFlashcards("flashcard.txt");
        Collections.shuffle(flashcards); /*I used the shuffle method instead of Math.Random https://www.geeksforgeeks.org/collections-shuffle-method-in-java-with-examples/ */
        
        for (Flashcard card : flashcards) { /* for loop that runs user input */
            printer.output("Word: " + card.getWord());
            printer.output("Press Enter to see the definition...");
            scanner.nextLine();
            printer.output("Definition: " + card.getDefinition());
            printer.output("Mark as studied? (yes/no)");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("yes")) { /*doesnt matter is uppercase or lowercase and if yes, it changes the txt file to true */
                card.setStudied(true);
            }
        }

        printer.saveFlashcards("flashcard.txt", flashcards); /*saves the new txt file of flashcards */
        printer.output("Session complete. Flashcards saved.");
    }

    public static void main(String[] args) {
        new App().start();
    }
}
