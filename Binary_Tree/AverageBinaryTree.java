package Binary_Tree;

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


class Solution {

    public static int dfs(TreeNode root) {

        if (root == null) return 0;

        int a = root.val + dfs(root.left) + dfs(root.right);

        return a;
    }


    public static int dfs2(TreeNode root) {

        if (root == null) return 0;

        int a = 1 + dfs2(root.left) + dfs2(root.right);

        return a;
    }


    public int averageOfSubtree(TreeNode root) {

        if (root == null) return 0;

        if (root.left == null && root.right == null) {
            return 1;
        }

        int sum = dfs(root);
        int count = dfs2(root);

        int avg = sum / count;

        if (avg == root.val) {

            return 1
                    + averageOfSubtree(root.left)
                    + averageOfSubtree(root.right);

        } else {

            return averageOfSubtree(root.left)
                    + averageOfSubtree(root.right);
        }
    }
}


public class AverageBinaryTree {

    public static void main(String[] args) {

        /*
                     4
                   /   \
                  8     5
                 / \     \
                0   1     6

            LeetCode example:
            Expected answer = 5
        */

        TreeNode root = new TreeNode(4);

        root.left = new TreeNode(8);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);

        root.right.right = new TreeNode(6);


        Solution solution = new Solution();

        int answer = solution.averageOfSubtree(root);

        System.out.println("Answer: " + answer);
        System.out.println("Expected: 5");
    }
}