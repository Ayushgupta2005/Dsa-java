package Binary_Tree;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

/*
 * Problem: Maximum Binary Tree (LeetCode 654)
 *
 * The root of any subarray is its maximum element; everything to the left
 * of that maximum recursively forms the left subtree, everything to the
 * right forms the right subtree. Find the max in [i, j], build a node for
 * it, and recurse on the two sides split around its index.
 *
 * Time Complexity: O(n^2) worst case (sorted input keeps re-scanning long
 * ranges); O(n log n) average
 * Space Complexity: O(n) recursion stack worst case
 */
public class MaximumBinaryTree {

    public static TreeNode construct(int i, int j, int[] nums){

        if(i==j){
            TreeNode nn = new TreeNode(nums[i]);
            nn.left=null;
            nn.right=null;
            return nn;
        }

        if(j<0 || i>j) return null;
        int a=0;
        int max=0;

        for(int c=i; c<=j; c++){
            if(nums[c]>max){
                max=nums[c];
                a=c;
            }
        }

        TreeNode node = new TreeNode(max);
        node.left = construct(i,a-1,nums);
        node.right = construct(a+1, j,nums);

        return node;


    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {


        return construct(0,nums.length-1,nums);

    }

    static void preorder(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val).append(" ");
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    public static void main(String[] args) {
        MaximumBinaryTree obj = new MaximumBinaryTree();

        TreeNode t1 = obj.constructMaximumBinaryTree(new int[]{3,2,1,6,0,5});
        StringBuilder sb1 = new StringBuilder();
        preorder(t1, sb1);
        System.out.println(sb1.toString().trim()); // Expected preorder: 6 3 2 1 5 0

        TreeNode t2 = obj.constructMaximumBinaryTree(new int[]{3,2,1});
        StringBuilder sb2 = new StringBuilder();
        preorder(t2, sb2);
        System.out.println(sb2.toString().trim()); // Expected preorder: 3 2 1
    }
}
