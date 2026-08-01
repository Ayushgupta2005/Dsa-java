package Binary_Tree;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class InorderTraversal {

    public static void inorderTraversall(TreeNode root, ArrayList<Integer> list) {

        if (root == null) {
            return;
        }

        inorderTraversall(root.left, list);
        list.add(root.val);
        inorderTraversall(root.right, list);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<>();
        inorderTraversall(root, list);

        return list;
    }

    public static void main(String[] args) {

        /*
                1
               / \
              2   3
             / \   \
            4   5   6
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.println(inorderTraversal(root));
    }
}