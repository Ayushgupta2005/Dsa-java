package Binary_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

class Pair{
    TreeNode node;
    int lvl;

    Pair(TreeNode node, int lvl){
        this.node = node;
        this.lvl = lvl;
    }
}

/*
 * Problem: Maximum Level Sum of a Binary Tree (LeetCode 1161)
 *
 * BFS with each node tagged by its level. Whenever the level changes, close
 * off the previous level's list and start a new one, so ans ends up holding
 * one list of values per level. Then scan the lists for the max sum and
 * report its 1-indexed level.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class MaximumLevelSum {
    public int maxLevelSum(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<List<Integer>> ans = new ArrayList<>();
        int curLevel=0;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));

        while(q.size()>0){

            Pair front = q.remove();

            if(curLevel!=front.lvl){

                ans.add(new ArrayList<>(list));
                list=new ArrayList<>();
                curLevel++;
            }

           list.add(front.node.val);


            if(front.node.left!=null){
                q.add(new Pair(front.node.left,front.lvl+1));
            }

            if(front.node.right!=null){
                q.add(new Pair(front.node.right,front.lvl+1));
            }
        }

       ans.add(new ArrayList<>(list));

       int max=Integer.MIN_VALUE;
       int level=0;

       for(int i=0; i<ans.size(); i++){
        int sum =0;
        for(int j=0; j<ans.get(i).size(); j++){
            sum=sum+ans.get(i).get(j);
        }

        if(sum>max){
            max=sum;
            level = i+1;
        }
       }
       return level;

    }

    public static void main(String[] args) {
        MaximumLevelSum obj = new MaximumLevelSum();

        //        1
        //      /   \
        //     7     0
        //    / \     \
        //   7  -8      0
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(-8);
        root.right.right = new TreeNode(0);

        System.out.println(obj.maxLevelSum(root)); // Expected: 2

        //     989
        //     /
        //   10250
        //     \
        //    98693
        //     /
        //  -89388
        //      \
        //     -32127
        TreeNode root2 = new TreeNode(989);
        root2.left = new TreeNode(10250);
        root2.left.right = new TreeNode(98693);
        root2.left.right.left = new TreeNode(-89388);
        root2.left.right.left.right = new TreeNode(-32127);
        System.out.println(obj.maxLevelSum(root2)); // Expected: 3
    }
}
