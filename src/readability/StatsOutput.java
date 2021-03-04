package readability;

import readability.basicOperations.Text;
import readability.tests.AutomatedReadabilityIndex;
import readability.tests.ColemanLiauIndex;
import readability.tests.FleshKincaidReadabilty;
import readability.tests.SimpleMeasureOfGobbledygook;

public class StatsOutput {
    Text text;

    StatsOutput(String text) {
        this.text = new Text(text);
        System.out.println("The text is:");
        System.out.println(text);
    }

    public String getStats() {
        return "Words: " + text.getWordsCount() + "\n" +
                "Sentences: " + text.getSentencesCount() + "\n" +
                "Characters: " + text.getCharacterCount() + "\n" +
                "Polysyllables: " + text.getPolysyllableCount() + "\n" +
                "Syllables: " + text.getSyllableCount() + "\n";
    }

    public String getIndex(String key) {
        String output;
        AutomatedReadabilityIndex ARI = new AutomatedReadabilityIndex(text);
        FleshKincaidReadabilty FK = new FleshKincaidReadabilty(text);
        SimpleMeasureOfGobbledygook SMOG = new SimpleMeasureOfGobbledygook(text);
        ColemanLiauIndex CL = new ColemanLiauIndex(text);

        switch (key) {
            case "ARI":
                return ARI.getScore();
            case "FK":
                return FK.getScore();
            case "SMOG":
                return SMOG.getScore();
            case "CL":
                return CL.getScore();
            case "all":
                return ARI.getScore() + FK.getScore() + SMOG.getScore() + CL.getScore() + "\n" +
                        String.format("This text should be understood in average by %.2f-year-olds.", (double) (ARI.getAge() + FK.getAge() + SMOG.getAge() + CL.getAge()) / 4);
            default:
                return "There is no such test";
        }
    }
}

