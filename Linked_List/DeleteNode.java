package Linked_List;

/*
 * Problem: Delete Node in a Linked List (LeetCode 237)
 *
 * You are given only the node to be deleted (not the head), and it is
 * guaranteed not to be the last node. Trick: copy the next node's value
 * into this node, then unlink the next node - effectively "becoming" the
 * next node and dropping it.
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */
public class DeleteNode {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public void deleteNode(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;
    }

    static void print(ListNode head) {
        ListNode t = head;
        while (t != null) {
            System.out.print(t.val + (t.next != null ? " -> " : "\n"));
            t = t.next;
        }
    }

    public static void main(String[] args) {
        DeleteNode obj = new DeleteNode();

        // List: 4 -> 5 -> 1 -> 9 , delete the node with value 5
        ListNode head = new ListNode(4);
        ListNode toDelete = new ListNode(5);
        head.next = toDelete;
        toDelete.next = new ListNode(1);
        toDelete.next.next = new ListNode(9);

        obj.deleteNode(toDelete);
        print(head); 
    }
}
