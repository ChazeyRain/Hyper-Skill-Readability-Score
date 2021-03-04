package readability;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = getTextFromFile(args[0]);
        StatsOutput stats = new StatsOutput(text);
        System.out.println(stats.getStats());
        System.out.println("Enter the score you want to calculate (ARI, FK, SMOG, CL, all):");
        String input = scanner.next();
        System.out.println(stats.getIndex(input));

    }

    public static String getTextFromFile(String path) {
        File file = new File(path);
        try {
            Scanner scanner = new Scanner(file);
            StringBuilder output = new StringBuilder();
            while (scanner.hasNextLine()) {
                output.append(scanner.nextLine()).append("\n");
            }
            scanner.close();
            return output.toString();
        } catch (Exception e) {
            return null;
        }
    }
}