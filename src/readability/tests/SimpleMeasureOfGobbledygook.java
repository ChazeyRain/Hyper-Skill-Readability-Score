package readability.tests;

import readability.basicOperations.Text;

public class SimpleMeasureOfGobbledygook extends TestParent{
    public SimpleMeasureOfGobbledygook (Text text) {
        super(text);
    }

    private double calculateScore() {
        return 1.043 * Math.sqrt((double) text.getPolysyllableCount() * 30 / text.getSentencesCount()) + 3.1291;
    }

    public String getScore() {
        if (score == -1) {
            score = calculateScore();
        }
        return String.format("Simple Measure of Gobbledygook: %.2f (about %s-year-olds)\n", score, getAge((int) Math.ceil(score * 14 / 30)));
    }

    void calculateAge() {
        age = "+24".equals(getAge((int) Math.ceil(score * 14 / 30))) ? 24 : Integer.parseInt(getAge((int) Math.ceil(score * 14 / 30)));
    }
}
