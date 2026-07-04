package Linked_List;

/*
 * Problem: Intersection of Two Linked Lists (LeetCode 160) - length difference
 *
 * Time Complexity: O(n + m)
 * Space Complexity: O(1)
 */
public class IntersectionOfTwoListsLenDiff {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {


        int lenA =0;
        int lenB=0;

        ListNode temp = headA;

        while(temp!=null){
            lenA++;
            temp = temp.next;
        }

        temp = headB;
        while(temp!=null){
            lenB++;
            temp = temp.next;
        }

        if(lenA>lenB){
            int diff = lenA-lenB;
            temp = headA;
            for(int i=0; i<diff; i++){
                temp = temp.next;
            }
            ListNode tempB = headB;
            while(temp!=tempB){
                temp = temp.next;
                tempB = tempB.next;
            }
        }
        else{
            int diff = lenB-lenA;
            temp = headB;
            for(int i=0; i<diff; i++){
                temp=temp.next;
            }

            ListNode tempA = headA;
            while(temp!=tempA){
                temp = temp.next;
                tempA = tempA.next;
            }

        }
        return temp;

    }

    public static void main(String[] args) {
        IntersectionOfTwoListsLenDiff obj = new IntersectionOfTwoListsLenDiff();

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
