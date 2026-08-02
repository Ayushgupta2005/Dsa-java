package Binary_Tree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BuildTree {

    public static TreeNode construct(int inLo, int inHi, int preLo, int preHi, xint[] inorder, int[] preorder) {

        if (inLo > inHi || preLo > preHi) return null;

        int val = preorder[preLo];

        TreeNode root = new TreeNode(val);

        int r = 0;

        for (int i = inLo; i <= inHi; i++) {
            if (inorder[i] == val) {
                r = i;
                break;
            }
        }

        int count = r - inLo;

        root.left = construct(inLo, r - 1,preLo + 1, preLo + count,inorder, preorder);

        root.right = construct(r + 1, inHi,preLo + count + 1, preHi,inorder, preorder);

        return root;
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        int n = inorder.length - 1;
        return construct(0, n, 0, n, inorder, preorder);
    }

    public static void display(TreeNode root) {
        if (root == null) return;

        System.out.print(root.val + " ");
        display(root.left);
        display(root.right);
    }

    public static void main(String[] args) {

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode root = buildTree(preorder, inorder);

        System.out.println("Preorder Traversal of Constructed Tree:");
        display(root);
    }
}
