package Binary_Tree;

import java.util.HashSet;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

/*
 * Problem: Second Minimum Node In a Binary Tree (LeetCode 671)
 *
 * Collect every distinct value with a DFS, then scan once tracking the
 * smallest and second smallest. Extra guards handle the case where
 * Integer.MAX_VALUE is a real node value rather than the "not found"
 * sentinel: all-MAX_VALUE means no second minimum, but MAX_VALUE alongside
 * a smaller value genuinely IS the second minimum.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class SecondMinimumNode {

    public static void dfs(TreeNode root, HashSet<Integer> list){
        if(root==null) return;

        list.add(root.val);

        dfs(root.left,list);
        dfs(root.right,list);
    }
    public int findSecondMinimumValue(TreeNode root) {

        HashSet<Integer> list = new HashSet<>();

        dfs(root,list);

        int min=Integer.MAX_VALUE;
        int secMin =Integer.MAX_VALUE;

        for(Integer i: list){

            if(i<min){
                secMin = min;
                min = i;
            }
            else if(i<secMin){
                secMin = i;
            }

        }
        HashSet<Integer> set = new HashSet<>();
        set.add(2147483647);
        set.add(2147483647);
        set.add(2147483647);

        if(list.equals(set)) return -1;

        if(list.contains(Integer.MAX_VALUE) && secMin==Integer.MAX_VALUE) return Integer.MAX_VALUE;

        if(secMin==Integer.MAX_VALUE) return -1;
        return secMin;
    }

    public static void main(String[] args) {
        SecondMinimumNode obj = new SecondMinimumNode();

        //     2
        //    / \
        //   2   5
        //      / \
        //     5   7
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        System.out.println(obj.findSecondMinimumValue(root)); // Expected: 5

        //     2
        //    / \
        //   2   2
        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        System.out.println(obj.findSecondMinimumValue(root2)); // Expected: -1

        // all MAX_VALUE -> no second minimum
        TreeNode root3 = new TreeNode(2147483647);
        root3.left = new TreeNode(2147483647);
        root3.right = new TreeNode(2147483647);
        System.out.println(obj.findSecondMinimumValue(root3)); // Expected: -1

        // MAX_VALUE is genuinely the second minimum
        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(1);
        root4.right = new TreeNode(2147483647);
        System.out.println(obj.findSecondMinimumValue(root4)); // Expected: 2147483647
    }
}
