package Linked_List;

import java.util.ArrayList;

/*
 * Problem: Reverse Linked List (LeetCode 206) - ArrayList approach
 *
 * Collect all node references into a list, reverse the list with two
 * pointers, then relink node.next along the new order and null-terminate.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class ReverseLinkedListArrayList {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseList(ListNode head) {

        if(head==null){
            return null;
        }

        ListNode temp = head;
        ArrayList<ListNode> list = new ArrayList<>();

        while(temp!=null){
            list.add(temp);
            temp = temp.next;
        }

        int i=0;
        int j=list.size()-1;
        while(i<j){
            ListNode a = list.get(i);
            list.set(i, list.get(j));
            list.set(j,a);
            i++;
            j--;
        }


        for(int l=0; l<list.size()-1; l++){
            ListNode a = list.get(l);
            a.next = list.get(l+1);
        }

        list.get(list.size()-1).next=null;
        return list.get(0);

    }

    static void print(ListNode head) {
        ListNode t = head;
        while (t != null) {
            System.out.print(t.val + (t.next != null ? " -> " : "\n"));
            t = t.next;
        }
    }

    public static void main(String[] args) {
        ReverseLinkedListArrayList obj = new ReverseLinkedListArrayList();

        // List: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        print(obj.reverseList(head)); // Expected: 5 -> 4 -> 3 -> 2 -> 1
    }
}
