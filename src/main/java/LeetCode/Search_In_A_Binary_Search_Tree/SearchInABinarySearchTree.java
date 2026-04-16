package LeetCode.Search_In_A_Binary_Search_Tree;

public class SearchInABinarySearchTree {
    public static void main(String[] args) {
        // Build a sample BST:
        //        4
        //       / \
        //      2   7
        //     / \
        //    1   3

        TreeNode root = new TreeNode(4,
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)
                ),
                new TreeNode(7)
        );

        SearchInABinarySearchTree s = new SearchInABinarySearchTree();
        TreeNode result = s.searchBST(root, 2);

        if (result != null) {
            System.out.println("Found node with value: " + result.val);
        } else {
            System.out.println("Value not found");
        }
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;

        if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
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
