package Binary_Tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
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
    int time;
    Pair(TreeNode node, int time){
        this.node = node;
        this.time = time;
    }
}

/*
 * Problem: Amount of Time for Binary Tree to Be Infected (LeetCode 2385)
 *
 * Infection spreads to left child, right child AND parent - so the tree
 * must be treated as an undirected graph. Build a child -> parent map with
 * DFS, locate the start node, then BFS outward from it in all three
 * directions using a visited set. The answer is the largest time reached.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class AmountOfTimeToInfectTree {

    public static TreeNode find(TreeNode root,int start ){

        if(root==null) return null;

        if(root.val==start) return root;

        TreeNode left = find(root.left, start);
         if(left != null) return left;
        return find(root.right,start);

    }

    public static void dfs(TreeNode root, HashMap<TreeNode, TreeNode> map){

        if(root.left!=null){
            map.put(root.left,root);
            dfs(root.left,map);
        }
        if(root.right!=null){
            map.put(root.right,root);
            dfs(root.right,map);
        }

    }
    public int amountOfTime(TreeNode root, int start) {

        HashMap<TreeNode,TreeNode> map = new HashMap<>();

        HashSet<TreeNode> jalgaye = new HashSet<>();
        dfs(root,map);
        int a=root.val;


        Queue<Pair> q = new LinkedList<>();

        TreeNode i = find(root,start);

        q.add(new Pair(i,0));

        jalgaye.add(i);
        int ans =0;

        while(q.size()>0){

            Pair p = q.remove();

            ans = Math.max(ans,p.time);

            if(p.node.left!=null && !jalgaye.contains(p.node.left)){
                q.add(new Pair(p.node.left,p.time+1));
                jalgaye.add(p.node.left);
            }
            if(p.node.right!=null && !jalgaye.contains(p.node.right)){
                q.add(new Pair(p.node.right,p.time+1));
                jalgaye.add(p.node.right);
            }

            if(p.node.val==a){
                continue;
            }
            TreeNode parent = map.get(p.node);
            if(p.node.val!=a && !jalgaye.contains(parent)){
                q.add(new Pair(parent,p.time+1));
                jalgaye.add(parent);

            }


        }
        return ans;

    }

    public static void main(String[] args) {
        AmountOfTimeToInfectTree obj = new AmountOfTimeToInfectTree();

        //          1
        //        /   \
        //       5     3
        //        \   / \
        //         4 10   6
        //        / \
        //       9   2
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(5);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(9);
        root.left.right.right = new TreeNode(2);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(6);

        System.out.println(obj.amountOfTime(root, 3)); // Expected: 4

        // single node
        TreeNode root2 = new TreeNode(1);
        System.out.println(obj.amountOfTime(root2, 1)); // Expected: 0
    }
}
