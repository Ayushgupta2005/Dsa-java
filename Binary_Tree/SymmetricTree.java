package Binary_Tree;

// Tree Node
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class SymmetricTree {

    public static boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) return true;

        if (p == null || q == null) return false;

        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) &&
               isSameTree(p.right, q.right);
    }

    public static void mirror(TreeNode root) {

        if (root == null) return;

        mirror(root.left);
        mirror(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    // Check if tree is symmetric
    public static boolean isSymmetric(TreeNode root) {

        if (root == null) return true;

        mirror(root.right);

        return isSameTree(root.left, root.right);
    }

    public static void main(String[] args) {

        /*
                    1
                  /   \
                 2     2
                / \   / \
               3   4 4   3

            Output:
            true
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        boolean ans = isSymmetric(root);

        System.out.println(ans);
    }
}