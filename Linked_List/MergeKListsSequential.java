package Linked_List;

/*
 * Problem: Merge k Sorted Lists (LeetCode 23 - Hard) - sequential two-list merges
 *
 * Merge the lists one at a time into a running result using the LeetCode 21
 * two-pointer merge: result = merge(result, lists[i]) for each i.
 *
 * Time Complexity: O(k * N)  where N = total nodes (result re-scanned each merge)
 * Space Complexity: O(1)
 */
public class MergeKListsSequential {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }

        ListNode curr = lists[0];

        for(int i=1; i<lists.length; i++){
            curr = mergeTwoLists(curr, lists[i]);

        }
        return curr;

    }

    static void print(ListNode head) {
        ListNode t = head;
        while (t != null) {
            System.out.print(t.val + (t.next != null ? " -> " : "\n"));
            t = t.next;
        }
        if (head == null) System.out.println("empty");
    }

    static ListNode build(int... vals) {
        ListNode dummy = new ListNode(-1);
        ListNode t = dummy;
        for (int v : vals) { t.next = new ListNode(v); t = t.next; }
        return dummy.next;
    }

    public static void main(String[] args) {
        MergeKListsSequential obj = new MergeKListsSequential();

        ListNode[] lists = {
            build(1, 4, 5),
            build(1, 3, 4),
            build(2, 6)
        };

        print(obj.mergeKLists(lists)); // Expected: 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6
    }
}
