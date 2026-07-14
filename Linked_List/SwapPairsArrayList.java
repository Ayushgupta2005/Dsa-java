package Linked_List;

import java.util.ArrayList;

/*
 * Problem: Swap Nodes in Pairs (LeetCode 24) - ArrayList approach
 *
 * Collect the nodes into a list, swap adjacent pairs (leaving the last node
 * alone when the count is odd), then rebuild the chain off a dummy node.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class SwapPairsArrayList {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode swapPairs(ListNode head) {

        ListNode temp = head;
        ArrayList<ListNode> list = new ArrayList<>();

        if(head==null || head.next==null){
            return head;
        }

        while(temp!=null){
            list.add(temp);
            temp=temp.next;
        }
        if(list.size()%2==0){
        for(int i=0; i<list.size(); i=i+2){
            ListNode a = list.get(i);
            list.set(i,list.get(i+1));
            list.set(i+1, a);
        }

    }
    else{
        for(int i=0; i<list.size()-1; i=i+2){
            ListNode a = list.get(i);
            list.set(i,list.get(i+1));
            list.set(i+1, a);
        }
    }

    ListNode dummy = new ListNode(-1);
    ListNode t = dummy;

    for(int i=0; i<list.size(); i++){
        ListNode a = list.get(i);
        t.next =a;
        t=t.next;
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
    }

    public static void main(String[] args) {
        SwapPairsArrayList obj = new SwapPairsArrayList();

        // List: 1 -> 2 -> 3 -> 4
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        print(obj.swapPairs(head)); // Expected: 2 -> 1 -> 4 -> 3

        // List: 1 -> 2 -> 3  (odd length, last node stays)
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);

        print(obj.swapPairs(head2)); // Expected: 2 -> 1 -> 3
    }
}
