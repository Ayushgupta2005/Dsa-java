package Binary_Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
    int level;

    Pair(TreeNode node, int level){
        this.node = node;
        this.level = level;
    }
}

/*
 * Problem: Minimum Number of Operations to Sort a Binary Tree by Level (LeetCode 2471)
 *
 * BFS to group node values by level (same bucket-by-level technique as
 * Maximum Level Sum). For each level's array, compute the minimum number
 * of swaps needed to sort it: repeatedly place the correct value at index i
 * by swapping in whichever value currently sits where i's correct value
 * belongs (a HashMap tracks each value's current position so the swap
 * partner is found in O(1)). Sum the swap counts across all levels.
 *
 * Time Complexity: O(n log n)  (dominated by sorting each level)
 * Space Complexity: O(n)
 */
public class MinimumOperationsToSortByLevel {

    private int getMinSwaps(int[] original){
        int swaps=0;

        int[] target = original.clone();
        Arrays.sort(target);

        Map<Integer,Integer> pos = new HashMap<>();

        for(int i=0; i<original.length; i++){
            pos.put(original[i],i);
        }

    for(int i=0; i<original.length; i++){
        if(original[i]!=target[i]){
            swaps++;

            int pos2 = pos.get(target[i]);

            int temp = original[i];
            original[i]=target[i];
            original[pos2]=temp;
            pos.put(temp, pos2);
        }

    }
    return swaps;


    }
    public int minimumOperations(TreeNode root) {

        ArrayList<List<Integer>> ans = new ArrayList<>();


        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root,0));

        ArrayList<Integer> list = new ArrayList<>();
        int curLevel =0;

        while(q.size()>0){

            Pair front = q.remove();

            if(curLevel!=front.level){
                ans.add(list);
                list = new ArrayList<>();
                curLevel++;
            }

            list.add(front.node.val);

            if(front.node.left!=null){
                q.add(new Pair(front.node.left,front.level+1));
            }

            if(front.node.right!=null){
                q.add(new Pair(front.node.right,front.level+1));
            }

        }
        ans.add(list);

        int totalSwaps = 0;

        for(int i=0; i<ans.size(); i++){

            int arr[] = new int[ans.get(i).size()];

            for(int j=0; j<arr.length; j++){
                arr[j]= ans.get(i).get(j);
            }
            totalSwaps = totalSwaps+ getMinSwaps(arr);
        }

        return totalSwaps;

    }

    public static void main(String[] args) {
        MinimumOperationsToSortByLevel obj = new MinimumOperationsToSortByLevel();

        // [1,4,3,7,6,8,5,null,null,null,null,9,null,10]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(5);
        root.left.right.left = new TreeNode(9);
        root.right.left.right = new TreeNode(10);
        System.out.println(obj.minimumOperations(root)); // Expected: 3

        // [1,3,2,7,6,5,4]
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(2);
        root2.left.left = new TreeNode(7);
        root2.left.right = new TreeNode(6);
        root2.right.left = new TreeNode(5);
        root2.right.right = new TreeNode(4);
        System.out.println(obj.minimumOperations(root2)); // Expected: 3

        // [1,2,3,4,5,6]
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.right = new TreeNode(3);
        root3.left.left = new TreeNode(4);
        root3.left.right = new TreeNode(5);
        root3.right.left = new TreeNode(6);
        System.out.println(obj.minimumOperations(root3)); // Expected: 0
    }
}
