package Binary_Tree;

import java.util.*;


class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTreePaths {

    public static void binaryTreePathss(TreeNode root, String str, List<String> ans) {

        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            str = str + root.val;
            ans.add(str);
            return;
        }

        binaryTreePathss(root.left, str + root.val + "->", ans);
        binaryTreePathss(root.right, str + root.val + "->", ans);
    }

    // Returns all root-to-leaf paths
    public static List<String> binaryTreePaths(TreeNode root) {

        List<String> ans = new ArrayList<>();

        binaryTreePathss(root, "", ans);

        return ans;
    }

    public static void main(String[] args) {

        /*
                    1
                   / \
                  2   3
                   \
                    5

            Output:
            [1->2->5, 1->3]
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        List<String> paths = binaryTreePaths(root);

        System.out.println(paths);
    }
}