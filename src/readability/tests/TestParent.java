package readability.tests;

import readability.basicOperations.Text;

public abstract class TestParent {
    Text text;
    double score = -1;
    int age = -1;

    public TestParent (Text text) {
        this.text = text;
    }

    public String getAge(int index) {
        index--;
        String[] output = {"6", "7", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "24", "24+"};

        return output[index];
    }

    double averageCharactersPerWord() {
        return (double) text.getCharacterCount() / text.getWordsCount();
    }

    double averageWordsPerSentence() {
        return (double) text.getWordsCount() / text.getSentencesCount();
    }

    double averageSyllablesPerWords() {
        return (double) text.getSyllableCount() / text.getWordsCount();
    }

    void calculateAge(){}

    public int getAge() {
        if (age == -1) {
            calculateAge();
        }
        return age;
    }

}
