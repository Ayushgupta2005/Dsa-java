package Binary_Tree;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
    }
}

public class FindTheMinDist {

    public static TreeNode lca(TreeNode root, int p, int q) {
        if (root == null) return null;

        if (root.data == p || root.data == q)
            return root;

        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);

        if (left != null && right != null)
            return root;

        return (left != null) ? left : right;
    }

    public static int search(TreeNode root, int target, int level) {

        if (root == null)
            return -1;

        if (root.data == target)
            return level;

        int left = search(root.left, target, level + 1);

        if (left != -1)
            return left;

        return search(root.right, target, level + 1);
    }

    public static int findDist(TreeNode root, int a, int b) {

        TreeNode lcaNode = lca(root, a, b);

        int dist1 = search(lcaNode, a, 0);
        int dist2 = search(lcaNode, b, 0);

        return dist1 + dist2;
    }

    public static void main(String[] args) {

        /*
                  1
                /   \
               2     3
              / \   / \
             4   5 6   7
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(findDist(root, 4, 5)); 
        System.out.println(findDist(root, 4, 6)); 
        System.out.println(findDist(root, 3, 7));
        System.out.println(findDist(root, 2, 7)); 
    }
}
