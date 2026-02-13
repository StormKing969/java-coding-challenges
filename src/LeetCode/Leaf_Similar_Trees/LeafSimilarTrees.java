package LeetCode.Leaf_Similar_Trees;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {
    public static void main(String[] args) {
        TreeNode root1 =
            new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7)
                )
        );

        TreeNode root2 =
                new TreeNode(3,
                        new TreeNode(9),
                        new TreeNode(20,
                                new TreeNode(15),
                                new TreeNode(7)
                        )
                );

        System.out.println(leafSimilar(root1, root2));
    }

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> tree1 = new ArrayList<>();
        List<Integer> tree2 = new ArrayList<>();

        dfs(root1, tree1);
        dfs(root2, tree2);

        return tree1.equals(tree2);
    }

    public static void dfs(TreeNode root, List<Integer> tree1) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            tree1.add(root.val);
            return;
        }

        dfs(root.left, tree1);
        dfs(root.right, tree1);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
