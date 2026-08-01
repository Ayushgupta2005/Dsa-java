package Binary_Tree;
import java.util.*;

// Tree Node
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

// Pair Class
class Pair {
    TreeNode node;
    int level;

    Pair(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }
}

public class LevelOrderTraversal {

    public static List<List<Integer>> levelOrder(TreeNode root) {

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
            [[3], [9, 20], [15, 7]]
        */

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> ans = levelOrder(root);

        System.out.println(ans);
    }
}
