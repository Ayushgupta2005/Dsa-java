package Binary_Tree;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class InvertBinaryTree {

    static void mirror(TreeNode root) {

        if (root == null)
            return;

        mirror(root.left);
        mirror(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    static TreeNode invertTree(TreeNode root) {
        mirror(root);
        return root;
    }

    // Inorder Traversal
    static void inorder(TreeNode root) {
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {

        /*
                 4
               /   \
              2     7
             / \   / \
            1   3 6   9
        */

        TreeNode root = new TreeNode(4);

        root.left = new TreeNode(2);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        System.out.print("Inorder Before Inversion: ");
        inorder(root);

        invertTree(root);

        System.out.print("\nInorder After Inversion : ");
        inorder(root);
    }
}// time complexiyu : O(n)