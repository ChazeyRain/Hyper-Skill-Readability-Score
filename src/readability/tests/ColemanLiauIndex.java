package readability.tests;

import readability.basicOperations.Text;

public class ColemanLiauIndex extends TestParent {

    public ColemanLiauIndex (Text text) {
        super(text);
    }

    private double calculateScore() {
        return 0.0588 * text.getCharacterCount() / text.getWordsCount() * 100 - 0.296 * text.getSentencesCount() / text.getWordsCount() * 100 - 15.8;
    }

    public String getScore() {
        if (score == -1) {
            score = calculateScore();
        }
        return String.format("Coleman–Liau index: %.2f (about %s-year-olds)\n", score, getAge((int) Math.ceil(score * 14 / 40)));
    }

    void calculateAge() {
        age = "+24".equals(getAge((int) Math.ceil(score * 14 / 40))) ? 24 : Integer.parseInt(getAge((int) Math.ceil(score * 14 / 40)));
    }
}
