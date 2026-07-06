package Linked_List;

import java.util.ArrayList;

/*
 * Problem: Swapping Nodes in a Linked List (LeetCode 1721) - ArrayList approach
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class SwapNodesArrayList {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode swapNodes(ListNode head, int k) {

        ArrayList<Integer> list = new ArrayList<>();

        ListNode temp = head;
        while(temp!=null){
            list.add(temp.val);
            temp = temp.next;
        }

        int a=list.get(k-1);

        list.set(k-1, list.get(list.size()-k));
        list.set(list.size()-k, a);

        temp = head;
         int i=0;

         while(temp!=null){
            temp.val=list.get(i);
            i++;
            temp = temp.next;
         }

         return head;

    }

    static void print(ListNode head) {
        ListNode t = head;
        while (t != null) {
            System.out.print(t.val + (t.next != null ? " -> " : "\n"));
            t = t.next;
        }
    }

    public static void main(String[] args) {
        SwapNodesArrayList obj = new SwapNodesArrayList();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        print(obj.swapNodes(head, 2));
    }
}
