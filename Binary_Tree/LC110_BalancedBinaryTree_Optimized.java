package Binary_Tree;

// Time Complexity: O(n)
// Space Complexity: O(h)

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class LC110_BalancedBinaryTree_Optimized {

    static boolean flag = true;

    public static int level(TreeNode root) {
        if (root == null) return 0;

        int a = level(root.left);
        int b = level(root.right);

        if (Math.abs(a - b) > 1) flag = false;

        return 1 + Math.max(a, b);
    }

    public static boolean isBalanced(TreeNode root) {
        flag = true;
        level(root);
        return flag;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(isBalanced(root));
    }
}
