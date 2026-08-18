package Binary_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Pair{
    Node node;
    int level;

    Pair(Node node, int level){
        this.node=node;
        this.level = level;
    }
}

/*
 * Problem: Top View of Binary Tree (GeeksforGeeks)
 *
 * Give every node a horizontal distance (level): root is 0, left child is
 * level-1, right child is level+1. BFS guarantees the first node seen at
 * each level is the topmost one, so record it only if that level is unseen.
 * A TreeMap keeps the levels sorted left to right for the final answer.
 *
 * Time Complexity: O(n log n)  (TreeMap operations)
 * Space Complexity: O(n)
 */
public class TopViewOfBinaryTree {
    public ArrayList<Integer> topView(Node root) {

        ArrayList<Integer> ans = new ArrayList<>();

        Queue<Pair> q = new LinkedList<>();

        Pair p = new Pair(root,0);
        q.add(p);

        TreeMap<Integer, Integer> map = new TreeMap<>();
        while(q.size()>0){
            Pair a = q.remove();

            if(!map.containsKey(a.level)){
                map.put(a.level, a.node.data);
            }

            if(a.node.left!=null){
                q.add(new Pair(a.node.left,a.level-1));
            }

            if(a.node.right!=null){
                q.add(new Pair(a.node.right,a.level+1));
            }


        }

        for(Integer key: map.keySet()){
            ans.add(map.get(key));
        }

        return ans;


    }

    public static void main(String[] args) {
        TopViewOfBinaryTree obj = new TopViewOfBinaryTree();

        //        1
        //      /   \
        //     2     3
        //      \     \
        //       4     6
        //        \
        //         5
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.left.right.right = new Node(5);
        root.right.right = new Node(6);

        System.out.println(obj.topView(root)); // Expected: [2, 1, 3, 6]

        //      1
        //     / \
        //    2   3
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        System.out.println(obj.topView(root2)); // Expected: [2, 1, 3]
    }
}
