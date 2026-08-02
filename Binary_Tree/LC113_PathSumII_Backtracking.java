package Binary_Tree;

import java.util.*;

// Time Complexity: O(n * h)
// Space Complexity: O(h)

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class LC113_PathSumII_Backtracking {

    public static void dfs(List<List<Integer>> ans, List<Integer> list, TreeNode root, int sum) {

        if (root == null) return;

        if (root.left == null && root.right == null && sum - root.val == 0) {
            list.add(root.val);
            ans.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }

        list.add(root.val);
        dfs(ans, list, root.left, sum - root.val);
        dfs(ans, list, root.right, sum - root.val);
        list.remove(list.size() - 1);
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        dfs(ans, list, root, sum);
        return ans;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        List<List<Integer>> ans = pathSum(root, 22);

        System.out.println(ans);
    }
}
