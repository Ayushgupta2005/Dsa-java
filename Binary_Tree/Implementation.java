package Binary_Tree;

import java.util.*;
class Node{
    int val;
    Node left;
    Node right;

    Node(int val){
        this.val = val;
    }
}

 class Pair{
        Node node;
        int level;

        Pair(Node node, int level){
            this.node = node;
            this.level = level;
        }
    }

public class Implementation {

    public static void display(Node root){

        if(root==null){
            return;
        }
                System.out.print(root.val+ " ");
        display(root.left);
        display(root.right);


    }

    public static int size(Node root){
        if(root==null){
            return 0;
        }
        return 1+size(root.left) + size(root.right);
    }

    public static int sum(Node root){
        if(root==null) return 0;

        return root.val + sum(root.left)+ sum(root.right);
    }

    public static int prod(Node root){
        if(root==null) return 1;

        if(root.val==0){
            return 1*prod(root.left) * prod(root.right);
        }
        else{
            return root.val * prod(root.left) * prod(root.right);
        }


    }

    public static int max( Node root){
        if(root==null) return Integer.MIN_VALUE;
    

    return Math.max(root.val, Math.max(max(root.left), max(root.right)) );
    }


    public static int findLevel(Node root){
        if(root==null) return 0;

        return 1+ Math.max(findLevel(root.left), findLevel(root.right));
    }

    public static void bfs(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(q.size()>0){
            Node front = q.remove();
            System.out.println(front.val);
            if(front.left!=null){
                q.add(front.left);
            }
            if(front.right!=null){
                q.add(front.right);
            }
        }


    }

    public static void bfs2(Node root){
        int currLevel =0;

        Queue<Pair> q = new LinkedList<>();
        
        Pair n = new Pair(root,currLevel);
        q.add(n);

        while(q.size()>0){

            Pair front = q.remove();
            if(front.level>currLevel){
                System.out.println();
                currLevel++;
            }

            System.out.print(front.node.val);

            if(front.node.left!=null){
                q.add(new Pair(front.node.left, currLevel+1));
            }

            if(front.node.right!=null){
                q.add(new Pair(front.node.right, currLevel+1));
            }
        }


    }

    public static void printlevel(Node a, int level, int l){

        if(a==null) return;

        if(level==l){
            System.out.print(a.val+ " ");
            return;
        }

        printlevel(a.left, level, l+1);
        printlevel(a.right, level, l+1);
    }

    public static void main(String[] args) {

        Node a = new Node(3);
        Node b = new Node(3);
        Node c = new Node(4);
        Node d = new Node(0);
        Node e = new Node(1);
        Node f = new Node(0);
        Node g = new Node(9);

        a.left = b;
        a.right = c;

        b.left=d;
        b.right=e;

        c.left =f;
        c.right=g;

        printlevel(a,2, 0);


    }
    
}
