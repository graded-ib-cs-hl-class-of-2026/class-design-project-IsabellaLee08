import java.util.Scanner;

public class Flashcard { 
    private String word;
    private String definition;
    private boolean studied; 
    

    public String toFileString() {
        return word + ":" + definition + ":" + studied;
    }


    /*Constructor to initialize word and definition */
    public Flashcard(String word, String definition,Boolean studied) {
        this.word = word;
        this.definition = definition;
        this.studied = false; 
    }

    /*Getter for word*/
    public String getWord() {
        return word;
    }
    /*setter for word */
    public String setWord() {
        return word;
    }

    /*Getter for definition */ 
    public String getDefinition() {
        return definition;
    }
    /*Setter for definition */ 
    public String setDefinition() {
        return definition;
    }

    /*Getter for if it was studied */
    public boolean getStudied() {
        return studied;
    }

    /*Setter for if it was studied*/ 
    public void setStudied(boolean studied) {
        this.studied = studied;
    }

    public String fromString() { /*Makes it so that the definition and word is separated by the :  */
        return word + ": " + definition;
    }

    public class FlashcardView {
    private Scanner scanner = new Scanner(System.in);

    public String toFileString() { /* updates the txt file */
        return word + ":" + definition + ":" + studied;
    }
}
 }
    