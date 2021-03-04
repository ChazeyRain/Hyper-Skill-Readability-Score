package readability.basicOperations;

import java.util.Locale;

public class Text {
    private final String text;
    
    private final String[] sentences;
    private final String[] words;

    private int syllableCount = -1;
    private int polysyllableCount = -1;
    
    public Text(String text) {
        this.text = text;
        this.sentences = text.split("[.!?]");
        this.words = text.replaceAll("[,.!?-]", "").split("[ ]");
    }

    public int getWordsCount() {
        return words.length;
    }

    public int getSentencesCount() {
        return sentences.length;
    }

    public int getCharacterCount() {
        return text.replaceAll("\\s", "").length();
    }

    public int getSyllableCount () {
        if (syllableCount == -1) {
            countSyllable();
        }
        return syllableCount;
    }

    public int getPolysyllableCount () {
        if (polysyllableCount == -1) {
            countSyllable();
        }
        return polysyllableCount;
    }

    public void countSyllable() {
        int syllableCount = text.replaceAll("e\\b", "").replaceAll("[aeiouy]{2}", "a").
                        replaceAll(" [^aeiouy]+ ", "a").replaceAll("[^aeiouy]", "").length();

        System.out.println();

        int polysyllableCount = text.replaceAll("e\\b", "").replaceAll("[aeiouy]{2}", "a").
                replaceAll("[^aeiouy ]", "").replaceAll("[aeiouy]{1,2} ", " ").
                replaceAll("[aieouy]+", "a").replaceAll(" ", "").length();

        this.syllableCount = syllableCount;
        this.polysyllableCount = polysyllableCount;
    }

}
