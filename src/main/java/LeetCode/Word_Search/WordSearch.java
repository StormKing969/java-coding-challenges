package LeetCode.Word_Search;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println("true => " + exist(board, "ABCCED"));
        System.out.println("true => " + exist(board, "SEE"));
        System.out.println("true => " + exist(board, "ABCB"));
    }

    public static boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean dfs(char[][] board, String word, int index,
                               int r, int c, boolean[][] visited) {
        if (index == word.length()) return true;
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length) return false;
        if (visited[r][c]) return false;
        if (board[r][c] != word.charAt(index)) return false;

        visited[r][c] = true;
        boolean found = dfs(board, word, index + 1, r + 1, c, visited)
                || dfs(board, word, index + 1, r - 1, c, visited)
                || dfs(board, word, index + 1, r, c + 1, visited)
                || dfs(board, word, index + 1, r, c - 1, visited);

        visited[r][c] = false; // backtrack

        return found;
    }
}
