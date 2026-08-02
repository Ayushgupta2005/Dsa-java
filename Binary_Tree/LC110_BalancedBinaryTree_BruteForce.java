package Binary_Tree;

// Time Complexity: O(n²)
// Space Complexity: O(h)

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class LC110_BalancedBinaryTree_BruteForce {

    public static int level(TreeNode root) {
        if (root == null) return 0;

        return 1 + Math.max(level(root.left), level(root.right));
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        int l1 = level(root.left);
        int l2 = level(root.right);

        if (Math.abs(l1 - l2) > 1) return false;

        return isBalanced(root.left) && isBalanced(root.right);
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