import java.util.Scanner;

public class Flashcard { 
    private String word;
    private String definition;
    private boolean studied; 
    
    public String toFileString() {
        return word + ":" + definition + ":" + studied;
    }


    // Constructor to initialize word and definition
    public Flashcard(String word, String definition) {
        this.word = word;
        this.definition = definition;
        this.studied = false;
        
    }

    // Getter for word
    public String getWord() {
        return word;
    }

    // Getter for definition
    public String getDefinition() {
        return definition;
    }

    // Getter for if it was studied 
    public boolean isStudied() {
        return studied;
    }

    // Setter for if it was studied 
    public void setStudied(boolean studied) {
        this.studied = studied;
    }

    public String fromString() {
        return word + ": " + definition;
    }

    public class FlashcardView {
    private Scanner scanner = new Scanner(System.in);

    public void doFlashcard() {
        System.out.println("Welcome to Fla");
        System.out.println("1. Load flashcards");
        System.out.println("2. Study flashcards");
        System.out.println("3. View studied cards");
        System.out.println("4. Exit");
    }

    public int getUserInput() {
        return scanner.nextInt();
    }

    public String enterFilename() {
        System.out.println("Enter the filename to load flashcards from:");
        return scanner.next();
    }

    public void showFlashcard(Flashcard card) {
        System.out.println("Word: " + card.getWord());
        System.out.println("Press Enter to see definition...");
        scanner.nextLine();
        scanner.nextLine(); 
        System.out.println("Definition: " + card.getDefinition());
    }

    public boolean askIfStudied() {
        System.out.println("Mark as studied? (yes/no)");
        String input = scanner.next();
        return input.equalsIgnoreCase("yes");
    }

    public void printMessage(String msg) {
        System.out.println(msg);
    }
}
   
 }
    