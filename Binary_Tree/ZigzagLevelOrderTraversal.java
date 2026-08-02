package Binary_Tree;

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

public class ZigzagLevelOrderTraversal {

    // Reverse a particular level
    public static void reverse(List<List<Integer>> ans, int idx) {
        int i = 0;
        int j = ans.get(idx).size() - 1;

        while (i < j) {
            int temp = ans.get(idx).get(i);
            ans.get(idx).set(i, ans.get(idx).get(j));
            ans.get(idx).set(j, temp);
            i++;
            j--;
        }
    }

    // Zigzag Level Order Traversal
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> ans = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();

        int currLevel = 0;
        q.add(new Pair(root, 0));

        List<Integer> list = new ArrayList<>();

        while (!q.isEmpty()) {

            Pair front = q.remove();

            if (front.level != currLevel) {
                ans.add(list);
                list = new ArrayList<>();
                currLevel++;
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

        // Reverse every odd level
        for (int i = 1; i < ans.size(); i += 2) {
            reverse(ans, i);
        }

        return ans;
    }

    public static void main(String[] args) {

        /*
                    3
                  /   \
                 9     20
                      /  \
                     15   7

            Output:
            [[3], [20, 9], [15, 7]]
        */

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> ans = zigzagLevelOrder(root);

        System.out.println(ans);
    }
}