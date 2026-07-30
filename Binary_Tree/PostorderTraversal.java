package Binary_Tree;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class PostorderTraversal {

    public static void postorderTraversall(List<Integer> list, TreeNode root) {

        if (root == null) {
            return;
        }

        postorderTraversall(list, root.left);
        postorderTraversall(list, root.right);
        list.add(root.val);
    }

    // Returns the postorder traversal of the tree
    public static List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        postorderTraversall(list, root);

        return list;
    }

    public static void main(String[] args) {

        /*
                    1
                  /   \
                 2     3
                / \   / \
               4   5 6   7

            Postorder:
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<Integer> ans = postorderTraversal(root);

        System.out.println(ans);
    }
}