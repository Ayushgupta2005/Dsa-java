package Binary_Tree;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class FlattenBInaryTree {

    public static void dfs(TreeNode root, ArrayList<TreeNode> list) {

        if (root == null)
            return;

        list.add(root);

        dfs(root.left, list);
        dfs(root.right, list);
    }

    public static void flatten(TreeNode root) {

        if (root == null)
            return;

        ArrayList<TreeNode> list = new ArrayList<>();

        dfs(root, list);

        for (int i = 0; i < list.size() - 1; i++) {

            TreeNode curr = list.get(i);

            curr.left = null;
            curr.right = list.get(i + 1);
        }

        TreeNode last = list.get(list.size() - 1);
        last.left = null;
        last.right = null;
    }

    public static void print(TreeNode root) {

        while (root != null) {
            System.out.print(root.val + " ");
            root = root.right;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        /*
                  1
                /   \
               2     5
              / \     \
             3   4     6
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.right = new TreeNode(6);

        flatten(root);

        System.out.println("Flattened Tree:");
        print(root);
    }
}