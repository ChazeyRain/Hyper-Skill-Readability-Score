package readability.tests;

import readability.basicOperations.Text;

public class AutomatedReadabilityIndex extends TestParent {

    public AutomatedReadabilityIndex (Text text) {
        super(text);
    }

    private double calculateScore() {
        return 4.71 * averageCharactersPerWord() + 0.5 * averageWordsPerSentence() - 21.43;
    }

    public String getScore() {
        if (score == -1) {
            score = calculateScore();
        }
        return String.format("Automated Readability Index: %.2f (about %s-year-olds) \n", score, getAge((int) Math.ceil(score)));
    }

    void calculateAge() {
        age = "24+".equals(getAge((int) Math.ceil(score))) ? 24 : Integer.parseInt(getAge((int) Math.ceil(score)));
    }

}
