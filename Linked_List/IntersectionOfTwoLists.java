package Linked_List;

import java.util.HashSet;

/*
 * Problem: Intersection of Two Linked Lists (LeetCode 160) - HashSet approach
 * Time Complexity: O(n + m)
 * Space Complexity: O(n)
 */
public class IntersectionOfTwoLists {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        HashSet<ListNode> set= new HashSet<>();

        ListNode temp = headA;

        while(temp!=null){
            set.add(temp);
            temp=temp.next;
        }

        temp = headB;

        while(temp!=null){
            if(set.contains(temp)){
                return temp;
            }
            else{
                temp = temp.next;
            }
        }

        return null;

    }

    public static void main(String[] args) {
        IntersectionOfTwoLists obj = new IntersectionOfTwoLists();

        ListNode shared = new ListNode(8);
        shared.next = new ListNode(4);
        shared.next.next = new ListNode(5);

        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = shared;

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = shared;

        ListNode ans = obj.getIntersectionNode(headA, headB);
        System.out.println(ans != null ? ans.val : "null"); // Expected: 8
    }
}
