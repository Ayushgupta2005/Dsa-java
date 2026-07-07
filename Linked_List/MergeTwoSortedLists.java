package Linked_List;

/*
 * Problem: Merge Two Sorted Lists (LeetCode 21)
 *
 * Two-pointer merge off a dummy node: repeatedly append the smaller head to
 * the tail t, then append whichever list has leftovers. Same merge as merge
 * sort, on nodes instead of array cells.
 *
 * Time Complexity: O(n + m)
 * Space Complexity: O(1)
 */
public class MergeTwoSortedLists {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(-1);
        ListNode t = dummy;

        ListNode i = list1;
        ListNode j = list2;

        while(i!=null && j!= null){
            if(i.val <= j.val){
                t.next = i;
                t= t.next;
                i = i.next;
            }
            else{
                t.next = j;
                t=t.next;
                j = j.next;
            }

        }

        if(i==null){
            while(j!=null){
                t.next = j;
                t=t.next;
                j=j.next;
            }
        }
        else{
            while(i!=null){
                t.next = i;
                t=t.next;
                i=i.next;
            }
        }
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
        MergeTwoSortedLists obj = new MergeTwoSortedLists();

        // list1: 1 -> 2 -> 4 , list2: 1 -> 3 -> 4
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        print(obj.mergeTwoLists(l1, l2)); // Expected: 1 -> 1 -> 2 -> 3 -> 4 -> 4
    }
}
