package Sorting_Algos;

/*
 * Problem: Merge Sort in Linked List - Sort List (LeetCode 148)
 *
 * Merge sort on a linked list: find the middle with slow/fast pointers
 * (fast.next / fast.next.next guard so slow stops BEFORE the middle),
 * cut the list in two, recursively sort both halves, then merge the two
 * sorted lists with the dummy-node two-pointer merge (LeetCode 21).
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(log n) recursion stack
 */
public class MergeSortInLinkedList {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode sortList(ListNode head) {

        if(head==null || head.next == null){
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next!= null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;

        head = sortList(head);
        head2 = sortList(head2);

        return merge(head,head2);

    }

     public static ListNode merge(ListNode list1, ListNode list2) {

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
        MergeSortInLinkedList obj = new MergeSortInLinkedList();

        // List: 4 -> 2 -> 1 -> 3
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        print(obj.sortList(head)); // Expected: 1 -> 2 -> 3 -> 4

        // List: -1 -> 5 -> 3 -> 4 -> 0
        ListNode head2 = new ListNode(-1);
        head2.next = new ListNode(5);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(0);

        print(obj.sortList(head2)); // Expected: -1 -> 0 -> 3 -> 4 -> 5
    }
}
