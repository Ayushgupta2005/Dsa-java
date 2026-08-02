package Binary_Tree;

// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

class Pair {
    TreeNode node;
    int level;

    Pair(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }
}

public class LC199_BinaryTreeRightSideView_BFS {

    public static List<List<Integer>> bfs(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        int cur = 0;
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<List<Integer>> ans = new ArrayList<>();

        while (q.size() > 0) {
            Pair front = q.remove();

            if (cur != front.level) {
                ans.add(list);
                list = new ArrayList<>();
                cur++;
            }

            list.add(front.node.val);

            if (front.node.left != null) {
                q.add(new Pair(front.node.left, front.level + 1));
            }

            if (front.node.right != null) {
                q.add(new Pair(front.node.right, front.level + 1));
            }
        }

        ans.add(list);
        return ans;
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> list = bfs(root);

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            ans.add(list.get(i).get(list.get(i).size() - 1));
        }

        return ans;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        System.out.println(rightSideView(root));
    }
}