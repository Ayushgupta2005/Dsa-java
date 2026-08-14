package Linked_List;

/*
 * Problem: Merge Nodes in Between Zeros (LeetCode 2181)
 *
 * The list starts and ends with 0, with zeros acting as separators. On each
 * zero, walk forward summing until the next zero, then append one node with
 * that sum to a dummy-headed result list.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)  (excluding the output list)
 */
public class MergeNodesInBetweenZeros {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeNodes(ListNode head) {

        ListNode dummy = new ListNode(-1);
        ListNode t = dummy;

        ListNode temp = head;

        while(temp!=null){
            if(temp.next==null) break;
            if(temp.val==0){
                temp=temp.next;
                int sum=0;
                while(temp!=null && temp.val!=0){
                    sum=sum+temp.val;
                    temp=temp.next;
                }

                ListNode n = new ListNode(sum);
                t.next =n;
                t=t.next;
            }
        }
        t.next=null;
        return dummy.next;



    }

    static void print(ListNode head) {
        ListNode t = head;
        while (t != null) {
            System.out.print(t.val + (t.next != null ? " -> " : "\n"));
            t = t.next;
        }
    }

    static ListNode build(int... vals) {
        ListNode dummy = new ListNode(-1);
        ListNode t = dummy;
        for (int v : vals) { t.next = new ListNode(v); t = t.next; }
        return dummy.next;
    }

    public static void main(String[] args) {
        MergeNodesInBetweenZeros obj = new MergeNodesInBetweenZeros();

        print(obj.mergeNodes(build(0,3,1,0,4,5,2,0)));   // Expected: 4 -> 11
        print(obj.mergeNodes(build(0,1,0,3,0,2,2,0)));   // Expected: 1 -> 3 -> 4
    }
}
