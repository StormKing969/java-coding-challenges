import Question02.Q2_Attempt_1;
import Question02.Q2_Attempt_2;
import Question02.Q2_Attempt_3;
import Question03.Q3_Attempt_1;
import Question04.Q4_Attempt_1;
import Question04.Q4_Attempt_2;
import Question06.Q6_Attempt_1;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String question = askQuestion();

        while (true) {
            switch (question) {
                case "Q1":
                    System.out.println("Question 01 is not implemented yet.");
                    question = askQuestion();
                    break;
                case "Q2":
                    runQuestion02();
                    break;
                case "Q3":
                    runQuestion03();
                    break;
                case "Q4":
                    runQuestion04();
                    break;
                case "Q5":
                    System.out.println("Question 05 is not implemented yet.");
                    question = askQuestion();
                    break;
                case "Q6":
                    runQuestion06();
                    break;
                default:
                    System.out.println("Invalid question number. Please try again.");
                    question = askQuestion();
                    break;
            }
        }
    }

    private static String askQuestion() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Do you want to use the program? Yes or No: ");
        String useProgram = scanner.nextLine().toLowerCase();
        System.out.println();

        if (useProgram.equals("no") || useProgram.equals("n")) {
            System.out.println("Exiting the program...");
            System.out.println("Thank you for using the program!");
            scanner.close();
            System.exit(0);
        }

        System.out.println("Available options: Q1, Q2, Q3, Q4, Q5");
        System.out.print("Which question do you want to run? ");
        String answer = scanner.nextLine().toUpperCase();
        System.out.println();
        return answer;
    }

    private static void runQuestion02() {
        String[] words = {
                "ad1",
                "a8f",
                "cb34",
                "abc",
                "23vs3",
                "234",
                "a23f343gt3rg4d1",
                "a23f3er4rgd3gt3rg4d1daw",
                ""
        };

        for (String word : words) {
            System.out.println("Original Word: " + word);
            System.out.println("New Word using V1: " + clearDigitsV1(word));
            System.out.println("New Word using V2: " + clearDigitsV2(word));
            System.out.println("New Word using V3: " + clearDigitsV3(word));
            System.out.println();
        }
    }

    private static String clearDigitsV1(String word) {
        return Q2_Attempt_1.clearDigitsV1(word);
    }

    private static String clearDigitsV2(String word) {
        return Q2_Attempt_2.clearDigitsV2(word);
    }

    private static String clearDigitsV3(String word) {
        return Q2_Attempt_3.clearDigitsV3(word);
    }

    private static void runQuestion03() {
        List<List<Integer>> grid = List.of(
                List.of(0, 0, 1, 0, 0),
                List.of(0, 0, 0, 0, 1),
                List.of(1, 0, 0, 1, 0),
                List.of(0, 1, 0, 0, 0),
                List.of(0, 0, 1, 0, 1)
        );

        System.out.println("Grid: " + grid);
        int minInconvenience = Q3_Attempt_1.getMinInconvenience(grid);
        System.out.println("Minimum Inconvenience: " + minInconvenience);
    }

    private static void runQuestion04() {
        List<Integer> server = List.of(1, 2, 3, 4, 5);
        List<Integer> replaceId = List.of(2, 3);
        List<Integer> newId = List.of(6, 7);

        System.out.println("Server: " + server);
        System.out.println("Replace IDs: " + replaceId);
        System.out.println("New IDs: " + newId);
        System.out.println();

        List<Integer> TempResult = Q4_Attempt_1.calculateDailyServerCapacity(server, replaceId, newId);

        List<Integer> result = Q4_Attempt_2.calculateDailyServerCapacity(server, replaceId, newId);

        System.out.println("Daily Server Capacity: " + result);
    }

    private static void runQuestion06() {
        String inputWord = "saippuakivikauppias";

        List<String> result = Q6_Attempt_1.allPalindromes(inputWord);
        System.out.println(result);
    }
}
