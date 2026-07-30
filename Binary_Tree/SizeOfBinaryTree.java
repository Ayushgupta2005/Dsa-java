package Binary_Tree;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class SizeOfBinaryTree {

    public static void gettSize(int[] count, Node root) {

        if (root == null) {
            return;
        }

        count[0]++;

        gettSize(count, root.left);
        gettSize(count, root.right);
    }

    public static int getSize(Node root) {

        int[] count = new int[1];

        gettSize(count, root);

        return count[0];
    }

    public static void main(String[] args) {

        /*
                1
               / \
              2   3
             / \   \
            4   5   6
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        System.out.println("Size of Binary Tree: " + getSize(root));
    }
}
