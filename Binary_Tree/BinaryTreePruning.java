package Binary_Tree;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

/*
 * Problem: Binary Tree Pruning (LeetCode 814)
 *
 * Remove every subtree that contains no 1. check(node) tells whether a
 * subtree contains at least one 1 anywhere in it. dfs walks the tree and,
 * at each node, cuts off a child link whose subtree has no 1 before
 * recursing further. The top-level call handles the case where the whole
 * tree has no 1 at all.
 *
 * Time Complexity: O(n^2) worst case - check() re-walks a subtree from
 * scratch at every node dfs visits above it
 * Space Complexity: O(h) recursion stack
 */
public class BinaryTreePruning {

    public static boolean check(TreeNode root){

        if(root==null) return false;
        if(root.val==1) return true;
        boolean a= check(root.left);
        boolean b = check(root.right);

        return a||b;
    }

    public static void dfs(TreeNode root){
        if(root==null) return;

        if(!check(root.left)){
            root.left=null;
        }
        if(!check(root.right)){
            root.right=null;
        }

        dfs(root.left);
        dfs(root.right);
    }


    public TreeNode pruneTree(TreeNode root) {

        if(!check(root)){
            return null;
        }
        dfs(root);
        return root;

    }

    static void preorder(TreeNode root, StringBuilder sb) {
        if (root == null) { sb.append("# "); return; }
        sb.append(root.val).append(" ");
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    public static void main(String[] args) {
        BinaryTreePruning obj = new BinaryTreePruning();

        // [1,null,0,0,1] -> expected [1,null,0,null,1]
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(0);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        StringBuilder sb = new StringBuilder();
        preorder(obj.pruneTree(root), sb);
        System.out.println(sb.toString().trim()); // 1 # 0 # 1 # #

        // all zeros -> null
        TreeNode root2 = new TreeNode(0);
        root2.left = new TreeNode(0);
        root2.right = new TreeNode(0);
        System.out.println(obj.pruneTree(root2)); // null
    }
}
