public class Flashcard { 
    private String word;
    private String definition;
    private boolean studied; 

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
    public void doFlashcard(){
        System.out.print("Welcome to my stupid flashcard program");
        
    }
   
 }
    