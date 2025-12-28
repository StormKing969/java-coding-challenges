package LeetCode.Word_Search_Two;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//public List<String> findWords(char[][] board, String[] words) {
//    List<String> res = new ArrayList<>();
//    TrieNode root = buildTrie(words);
//    for (int i = 0; i < board.length; i++) {
//        for (int j = 0; j < board[0].length; j++) {
//            dfs (board, i, j, root, res);
//        }
//    }
//    return res;
//}
//
//public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
//    char c = board[i][j];
//    if (c == '#' || p.next[c - 'a'] == null) return;
//    p = p.next[c - 'a'];
//    if (p.word != null) {   // found one
//        res.add(p.word);
//        p.word = null;     // de-duplicate
//    }
//
//    board[i][j] = '#';
//    if (i > 0) dfs(board, i - 1, j ,p, res);
//    if (j > 0) dfs(board, i, j - 1, p, res);
//    if (i < board.length - 1) dfs(board, i + 1, j, p, res);
//    if (j < board[0].length - 1) dfs(board, i, j + 1, p, res);
//    board[i][j] = c;
//}
//
//public TrieNode buildTrie(String[] words) {
//    TrieNode root = new TrieNode();
//    for (String w : words) {
//        TrieNode p = root;
//        for (char c : w.toCharArray()) {
//            int i = c - 'a';
//            if (p.next[i] == null) p.next[i] = new TrieNode();
//            p = p.next[i];
//        }
//        p.word = w;
//    }
//    return root;
//}
//
//class TrieNode {
//    TrieNode[] next = new TrieNode[26];
//    String word;
//}

public class WordSearchTwo {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        System.out.println("['eat', 'oath'] => " + findWords(board, new String[]{"oath", "pea", "eat", "rain"}));
    }


    public static List<String> findWords(char[][] board, String[] words) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        Set<String> res = new HashSet<>();
        for (String word : words) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (dfs(board, i, j, visited, 0, word)) {
                        res.add(word);
                    }
                }
            }
        }

        return new ArrayList<>(res);
    }

    private static boolean dfs(char[][] board, int row, int col, boolean[][] visited, int index, String word) {
        if (index == word.length()) return true;
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) return false;
        if (visited[row][col]) return false;
        if (board[row][col] != word.charAt(index)) return false;

        visited[row][col] = true;
        boolean found = dfs(board, row - 1, col, visited, index + 1, word)
                || dfs(board, row + 1, col, visited, index + 1, word)
                || dfs(board, row, col - 1, visited, index + 1, word)
                || dfs(board, row, col + 1, visited, index + 1, word);
        visited[row][col] = false;

        return found;
    }
}
