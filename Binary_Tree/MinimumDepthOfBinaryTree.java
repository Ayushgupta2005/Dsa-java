package Binary_Tree;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class MinimumDepthOfBinaryTree {
    public static void minDepthh(TreeNode root, ArrayList<Integer> list, int depth) {

        if (root == null) {
            return;
        }

        // Leaf node
        if (root.left == null && root.right == null) {
            list.set(0, Math.min(list.get(0), depth + 1));
            return;
        }

        minDepthh(root.left, list, depth + 1);
        minDepthh(root.right, list, depth + 1);
    }

    // Returns the minimum depth
    public static int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        ArrayList<Integer> list = new ArrayList<>();
        list.add(Integer.MAX_VALUE);

        minDepthh(root, list, 0);

        return list.get(0);
    }

    public static void main(String[] args) {

        /*
                    3
                  /   \
                 9     20
                      /  \
                     15   7

            Minimum Depth = 2
        */

        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int depth = minDepth(root);

        System.out.println("Minimum Depth: " + depth);
    }
}