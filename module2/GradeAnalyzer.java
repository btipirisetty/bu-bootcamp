import java.io.*; 
import java.util.ArrayList;

public class GradeAnalyzer {

    public static void main(String[] args) {
        // --- Step 2: Test calculateAverage with a hardcoded list ---
        ArrayList<Integer> testScores = new ArrayList<>();
        testScores.add(80);
        testScores.add(90);
        testScores.add(100);
        System.out.println("----------------------------------------");
        System.out.println("Hardcoded Test Average (Expected 90.0): " + calculateAverage(testScores));
        System.out.println("----------------------------------------");
        String inputFile = "D:\\Boston_Univ\\Courses\\Module2\\scores.txt";
        String outputFile = "D:\\Boston_Univ\\Courses\\Module2\\report.txt";
        
        // Step 3: read scores from file
        ArrayList<Integer> scores = readScores(inputFile);
        System.out.println("Scores loaded: " + scores);

        // Step 4: calculate statistics
        double avg = calculateAverage(scores);
        System.out.println("Calculated Average: " + avg);

        // Step 5: Find Highest and Lowest Scores
        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;
        if (!scores.isEmpty()) {
            for (int score : scores) {
                if (score > highest) {
                    highest = score;
                }
                if (score < lowest) {
                    lowest = score;
                }
            }
        } else {
            highest = 0;
            lowest = 0;
        }

        System.out.println("Highest Score: " + highest);
        System.out.println("Lowest Score: " + lowest);
        // Step 6: Count the Grade Bands
        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;
        int countF = 0;

        for (int score : scores) {
            if (score >= 90) {
                countA++;
            } else if (score >= 80) {
                countB++;
            } else if (score >= 70) {
                countC++;
            } else if (score >= 60) {
                countD++;
            } else {
                countF++;
            }
        }
        // Step 7: write and print report
        writeReport(scores, avg, highest, lowest,countA, countB, countC, countD, countF, outputFile);
    }


    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {
        ArrayList<Integer> scores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim(); // Remove whitespace

                if (line.isEmpty()) {
                    continue; // Skip blank lines
                }

                try {
                    int score = Integer.parseInt(line);
                    scores.add(score);
                } catch (NumberFormatException e) {
                    System.err.println("Warning: Invalid number format '" + line + "'. Skipping line.");
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found at " + filename);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return scores;
    }


    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        // 1. If the scores list is empty, return 0.0 immediately
        if (scores == null || scores.isEmpty()) {
            return 0.0;
        }

        // 2. Loop through all scores and accumulate total
        double total = 0.0;
        for (int score : scores) {
            total += score;
        }

        // 3. Return total divided by scores.size()
        return total / scores.size();
    }
    public static void writeReport(ArrayList<Integer> scores,
                                   double avg, int high, int low,
                                   int countA, int countB, int countC, int countD, int countF,
                                   String outputFile) {
        String reportText = String.format(
            "===========================\n" +
            "     GRADE REPORT          \n" +
            "===========================\n" +
            "Total Students Processed: %d\n" +
            "Average Score: %.2f\n" +
            "Highest Score: %d\n" +
            "Lowest Score:  %d\n" +
            "---------------------------\n" +
            "GRADE DISTRIBUTION:\n" +
            "  A (90-100) : %d\n" +
            "  B (80-89)  : %d\n" +
            "  C (70-79)  : %d\n" +
            "  D (60-69)  : %d\n" +
            "  F (<60)    : %d\n" +
            "===========================",
            scores.size(), avg, high, low, countA, countB, countC, countD, countF
        );
        System.out.println("\n" + reportText);
        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {
            writer.println(reportText);
            System.out.println("\nSuccessfully saved report to: " + outputFile);
        } catch (IOException e) {
            System.err.println("Error writing report to file: " + e.getMessage());
        }
    }
}