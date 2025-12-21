package Companies.Walmart;

import java.util.ArrayList;
import java.util.List;

public class Question01Solution {
    public static void main(String[] argv) {
        String[] teleporters1 = {"3,1", "4,2", "5,10"};
        String[] teleporters2 = {"5,10", "6,22", "39,40", "40,49", "47,29"};
        String[] teleporters3 = {"6,18", "36,26", "41,21", "49,55", "54,52",
                "71,58", "74,77", "78,76", "80,73", "92,85"};
        String[] teleporters4 = {"97,93", "99,81", "36,33", "92,59", "17,3",
                "82,75", "4,1", "84,79", "54,4", "88,53",
                "91,37", "60,57", "61,7", "62,51", "31,19"};
        String [] teleporters5 = {"3,8", "8,9", "9,3"};

        outcome(teleporters1, 6, 0, 12);
        outcome(teleporters2, 6, 0, 12);
        outcome(teleporters3, 6, 0, 12);
        outcome(teleporters4, 6, 0, 12);
        outcome(teleporters5, 6, 0, 12);
    }

    public static void outcome(String[] teleporters, int dieSides, int start, int boardSize) {
        int[][] teleporterArray = new int[teleporters.length][];
        for (int i = 0; i < teleporters.length; i++) {
            String[] parts = teleporters[i].split(",");
            teleporterArray[i] = new int[]{Integer.parseInt(parts[0]), Integer.parseInt(parts[1])};
        }

        List<Integer> visited = new ArrayList<>();
        int current = start;

        for (int i = 1; i <= dieSides; i++) {
            current += i;
            if (current >= boardSize) {
                visited.add(boardSize);
            }

            for (int[] teleporter : teleporterArray) {
                if (current == teleporter[0]) {
                    current = teleporter[1];
                }
            }

            visited.add(current);
            current = start;
        }

        visited = visited.stream().distinct().toList();

        System.out.println("Visited: " + visited);
    }
}
