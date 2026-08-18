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
 * Problem: Bottom View of Binary Tree (GeeksforGeeks)
 *
 * Same horizontal-distance BFS as the top view, but ALWAYS overwrite the
 * value at each level - so the last node reached at a given horizontal
 * distance (the lowest one) is what survives. TreeMap keeps levels ordered
 * left to right.
 *
 * Time Complexity: O(n log n)  (TreeMap operations)
 * Space Complexity: O(n)
 */
public class BottomViewOfBinaryTree {
    public ArrayList<Integer> bottomView(Node root) {

        ArrayList<Integer> ans = new ArrayList<>();

        Queue<Pair> q = new LinkedList<>();

        Pair p = new Pair(root,0);
        q.add(p);

        TreeMap<Integer, Integer> map = new TreeMap<>();
        while(q.size()>0){
            Pair a = q.remove();

                map.put(a.level, a.node.data);

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
        BottomViewOfBinaryTree obj = new BottomViewOfBinaryTree();

        //          20
        //         /  \
        //        8    22
        //       / \     \
        //      5   3     25
        //         / \
        //        10  14
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        root.right.right = new Node(25);

        System.out.println(obj.bottomView(root)); // Expected: [5, 10, 3, 14, 25]

        //      1
        //     / \
        //    2   3
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        System.out.println(obj.bottomView(root2)); // Expected: [2, 1, 3]
    }
}
