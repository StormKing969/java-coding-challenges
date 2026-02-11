package LeetCode.Generate_Parentheses;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(2));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(0, 0, "", n, res);
        return res;
    }

    private static void dfs(int left, int right, String cur, int n, List<String> res) {
        if (left == n && right == n) {
            res.add(cur);
            return;
        }

        if (left < n) {
            dfs(left + 1, right, cur + "(", n, res);
        }

        if (right < left) {
            dfs(left, right + 1, cur + ")", n, res);
        }
    }
}
