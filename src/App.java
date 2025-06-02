import java.util.Scanner;
import java.io.FileNotFoundException;

public class App {

    /** runs the flashcard app and user instructions */
    public void start() {
        Scanner scanner = new Scanner(System.in);
        Printer printer = new Printer();
        Flashcard[] flashcards = new Flashcard[0];

        try {
        /** loads lines from file using the printer's generic method */
            String[] lines = printer.readAllLines("flashcard.txt");
            flashcards = parseFlashcards(lines); /**https://runestone.academy/ns/books/published/GradedIBCS2024HL/Unit7-ArrayList/topic-input-files.htmlParsing and https://youtu.be/SRPayhD1QnE */
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return;  /**exit if file not found*/
        }

        shuffleFlashcards(flashcards); /**shuffle the array*/

        for (Flashcard card : flashcards) {
            printer.output("Word: " + card.getWord());
            printer.output("Press Enter to see the definition...");
            scanner.nextLine();
            printer.output("Definition: " + card.getDefinition());
            printer.output("Mark as studied? (yes/no)");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("yes")) {
                card.setStudied(true);
            }
        }

        // Convert Flashcard array into one big string for saving
        String allFlashcardsString = flashcardsToString(flashcards);

        // Use Printer to write the big string to file
        printer.writeStringToFile("flashcard.txt", allFlashcardsString);

        printer.output("Session complete. Flashcards saved.");
    }

    /** Parses String array lines into Flashcard array */
    private Flashcard[] parseFlashcards(String[] lines) { /**splits the line by ":" to separate the word, definition, and studied status. This breaks the text into parts so we can create Flashcard objects from it. */
        Flashcard[] temp = new Flashcard[lines.length];
        int count = 0;

        for (String line : lines) {
            String[] parts = line.split(":", 3);
            if (parts.length >= 2) {
                String word = parts[0].trim();
                String definition = parts[1].trim();
                boolean studied = parts.length == 3 && parts[2].trim().equalsIgnoreCase("true");
                temp[count++] = new Flashcard(word, definition, studied);
            }
        }

        Flashcard[] flashcards = new Flashcard[count];
        for (int i = 0; i < count; i++) {
            flashcards[i] = temp[i];
        }
        return flashcards;
    }

    /** Convert Flashcard array into one big string for saving */
    private String flashcardsToString(Flashcard[] flashcards) {
        String result = "";  
        for (int i = 0; i < flashcards.length; i++) {
            result = result + flashcards[i].toFileString() + "\n";  /**concatenate each line and the new line*/
        }
        return result;
    }

    /** shuffles cards with math.random */
    private void shuffleFlashcards(Flashcard[] cards) {
        for (int i = 0; i < cards.length; i++) {
            int randomIndex = (int) (Math.random() * cards.length);
            Flashcard temp = cards[i];
            cards[i] = cards[randomIndex];
            cards[randomIndex] = temp;
        }
    }

    public static void main(String[] args) {
        new App().start();
    }
}
