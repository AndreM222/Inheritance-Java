package Java.Semester2.Chapter11.Translator;

public class WordFunction {

    private String latinWord;
    private String englishWord;
    private String description;

    //-------------------- Setters -----------------------

    public void setLatinWord (String latinWord) { this.latinWord = latinWord; }
    public void setEnglishWord (String englishWord) { this.englishWord = englishWord; }
    public void setDescription (String description) { this.description = description; }

    //-------------------- Getters -----------------------

    public String getLatinWord () { return latinWord; }
    public String getEnglishWord () { return englishWord; }
    public String getDescription () { return description; }

    public void setupNewWord (String latinWord, String englishWord, String description) { 

        setLatinWord(latinWord); 
        setEnglishWord(englishWord); 
        setDescription(description);

    }

}