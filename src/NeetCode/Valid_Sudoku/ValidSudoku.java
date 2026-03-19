package NeetCode.Valid_Sudoku;

import java.util.HashMap;
import java.util.Map;

public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board = {
                {'1','2','.','.','3','.','.','.','.'},
                {'4','.','.','5','.','.','.','.','.'},
                {'.','9','8','.','.','.','.','.','3'},
                {'5','.','.','.','6','.','.','.','4'},
                {'.','.','.','8','.','3','.','.','5'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','.','.','.','.','.','2','.','.'},
                {'.','.','.','4','1','9','.','.','8'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(isValidSudoku(board));

        char[][] board2 = {
                {'1','2','.','.','3','.','.','.','.'},
                {'4','.','.','5','.','.','.','.','.'},
                {'.','9','1','.','.','.','.','.','3'},
                {'5','.','.','.','6','.','.','.','4'},
                {'.','.','.','8','.','3','.','.','5'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','.','.','.','.','.','2','.','.'},
                {'.','.','.','4','1','9','.','.','8'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(isValidSudoku(board2));
    }

    public static boolean isValidSudoku(char[][] board) {
        // Check rows
        for (char[] chars : board) {
            if (checkInValidity(chars)) {
                return false;
            }
        }

        // Get the columns
        char[][] columns = new char[board.length][board.length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                columns[j][i] = board[i][j];
            }
        }

        // Check columns
        for (char[] chars : columns) {
            if (checkInValidity(chars)) {
                return false;
            }
        }

        // Get the subBoxes
        char[][] subBox = new char[board.length][board.length];
        int currentRow = 0;
        int currentColumn = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                subBox[currentRow][currentColumn] = board[i][j];
                if ((j + 1) % 3 == 0) {
                    currentRow++;
                    if (currentColumn / 3 != 0) {
                        currentColumn = currentColumn / 3 * 3;
                    } else {
                        currentColumn = 0;
                    }
                } else {
                    currentColumn++;
                }
            }

            if ((i + 1) % 3 == 0) {
                currentRow = (i + 1) / 3 * 3;
                currentColumn = 0;
            } else {
                currentRow -= 3;
                currentColumn += 3;
            }
        }

        for (char[] chars : subBox) {
            if (checkInValidity(chars)) {
                return false;
            }
        }

        return true;
    }

    private static boolean checkInValidity(char[] row) {
        Map<Character, Boolean> numberRange = new HashMap<>();
        for (int i = 1; i < 10; i++) { numberRange.put((char) ('0' + i), false); }

        for (Character ele : row) {
            if (numberRange.containsKey(ele)) {
                if (numberRange.get(ele).equals(true)) {
                    return true;
                } else {
                    numberRange.put(ele, true);
                }
            }
        }

        return false;
    }
}
