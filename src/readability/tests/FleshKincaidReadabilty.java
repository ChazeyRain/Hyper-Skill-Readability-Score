package readability.tests;

import readability.basicOperations.Text;

public class FleshKincaidReadabilty extends TestParent {

    public FleshKincaidReadabilty (Text text) {
        super(text);
    }

    private double calculateScore() {
        return 0.39 * averageWordsPerSentence() + 11.8 * averageSyllablesPerWords() - 15.59;
    }

    public String getScore() {
        if (score == -1) {
            score = calculateScore();
        }
        return String.format("Flesch–Kincaid readability tests: %.2f (about %s-year-olds)\n", score, getAge((int) Math.ceil(score * 14 / 100)));
    }

    void calculateAge() {
        age = "+24".equals(getAge((int) Math.ceil(score * 14 / 100))) ? 24 : Integer.parseInt(getAge((int) Math.ceil(score * 14 / 100)));
    }
}
