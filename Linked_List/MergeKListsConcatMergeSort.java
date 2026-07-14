package Linked_List;

/*
 * Problem: Merge k Sorted Lists (LeetCode 23 - Hard) - concatenate + merge sort
 *
 * Chain all k lists into one long (unsorted) list, then run merge sort on
 * it (LeetCode 148 machinery: slow/fast split + two-pointer merge).
 *
 * Time Complexity: O(N log N)  where N = total number of nodes
 * Space Complexity: O(log N) recursion stack
 */
public class MergeKListsConcatMergeSort {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode mergeSort(ListNode head){

        if(head == null || head.next == null){
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast= fast.next.next;
        }

        ListNode head2 = slow.next;
        slow.next = null;

        head = mergeSort(head);
        head2 = mergeSort(head2);


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


    public ListNode mergeKLists(ListNode[] lists) {

        ListNode dummy = new ListNode(-1);

        ListNode t = dummy;

        for(int i=0; i<lists.length; i++){
            ListNode a = lists[i];

            while(a!=null){
                t.next = a;
                t=t.next;
                a=a.next;
            }
        }

        t.next = null;

        ListNode temp = dummy.next;

        ListNode sol = mergeSort(temp);
        return sol;

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
        MergeKListsConcatMergeSort obj = new MergeKListsConcatMergeSort();

        ListNode[] lists = {
            build(1, 4, 5),
            build(1, 3, 4),
            build(2, 6)
        };

        print(obj.mergeKLists(lists)); // Expected: 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6
    }
}
