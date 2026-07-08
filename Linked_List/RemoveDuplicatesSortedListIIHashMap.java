package Linked_List;

import java.util.HashMap;

/*
 * Problem: Remove Duplicates from Sorted List II (LeetCode 82) - HashMap approach
 *
 * Pass 1: count the frequency of every value. Pass 2: rebuild the list off a
 * dummy node, keeping only nodes whose value appears exactly once.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class RemoveDuplicatesSortedListIIHashMap {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteDuplicates(ListNode head) {

        ListNode temp = head;

        HashMap<Integer, Integer> map = new HashMap<>();

        while(temp!=null){
            if(!map.containsKey(temp.val)){
                map.put(temp.val, 1);
            }
            else{
                map.put(temp.val,map.get(temp.val)+1);
            }

            temp=temp.next;
        }

        ListNode dummy = new ListNode(-1);
        ListNode t=dummy;

        ListNode i=head;

        while(i!=null){
            if(map.get(i.val)==1){
                t.next = i;
                t=t.next;
                i=i.next;
            }
            else{
                i=i.next;
            }
        }
        t.next = null;
        return dummy.next;

    }

    static void print(ListNode head) {
        ListNode t = head;
        while (t != null) {
            System.out.print(t.val + (t.next != null ? " -> " : "\n"));
            t = t.next;
        }
        if (head == null) System.out.println("empty");
    }

    public static void main(String[] args) {
        RemoveDuplicatesSortedListIIHashMap obj = new RemoveDuplicatesSortedListIIHashMap();

        // List: 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

        print(obj.deleteDuplicates(head)); // Expected: 1 -> 2 -> 5

        // List: 1 -> 1 -> 1 -> 2 -> 3
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(1);
        head2.next.next.next = new ListNode(2);
        head2.next.next.next.next = new ListNode(3);

        print(obj.deleteDuplicates(head2)); // Expected: 2 -> 3
    }
}
