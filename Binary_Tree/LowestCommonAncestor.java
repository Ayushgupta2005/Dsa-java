package Binary_Tree;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

/*
 * Problem: Lowest Common Ancestor of a Binary Tree (LeetCode 236)
 *
 * At each node, search whether p is in the left subtree and whether q is in
 * the right subtree. If they are split across the two sides (or the node is
 * p or q itself), this node is the LCA; otherwise recurse into the side
 * that contains both.
 *
 * Time Complexity: O(n^2) worst case (a search runs at each level)
 * Space Complexity: O(h) recursion stack
 */
public class LowestCommonAncestor {

    public static boolean search(TreeNode root, int key) {

        if(root==null) return false;

        if(root.val == key) return true;

        boolean a = search(root.left,key);
        boolean b = search(root.right,key);

        return a||b;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val==p.val || root.val==q.val) return root;

        boolean pil = search(root.left, p.val);
        boolean qir = search(root.right, q.val);

        if(pil==true && qir == true){
            return root;
        }

        else if(pil==false && qir==true){
            return lowestCommonAncestor(root.right,p,q);
        }
        else if(pil==true && qir==false){
            return lowestCommonAncestor(root.left, p,q);
        }
        else{
            return root;
        }


    }

    public static void main(String[] args) {
        LowestCommonAncestor obj = new LowestCommonAncestor();

        //        3
        //      /   \
        //     5     1
        //    / \   / \
        //   6   2 0   8
        //      / \
        //     7   4
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        System.out.println(obj.lowestCommonAncestor(root, root.left, root.right).val);       // Expected: 3
        System.out.println(obj.lowestCommonAncestor(root, root.left, root.left.right.right).val); // Expected: 5
        System.out.println(obj.lowestCommonAncestor(root, root.left.left, root.left.right.left).val); // Expected: 5
    }
}
