package Linked_List;

/*
 * Problem: Swap Nodes in Pairs (LeetCode 24) - split into two chains, interleave
 *
 * Phase 1: split the list by position parity into two chains built off two
 * dummy nodes (odd positions, even positions). Phase 2: rebuild by
 * interleaving the chains starting with the even-position chain, which
 * produces the pairwise-swapped order; attach whichever chain has leftovers.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class SwapPairsSplitInterleave {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode swapPairs(ListNode head) {

        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);

        ListNode t1 = dummy1;
        ListNode t2 = dummy2;
        ListNode curr = head;
        int idx =1;

        while(curr!=null){
            if(idx%2!=0){
                t1.next = curr;
                t1=t1.next;
                curr = curr.next;
                idx++;
            }
            else{
                t2.next =curr;
                t2=t2.next;
                curr =curr.next;
                idx++;
            }
        }

            t1.next =null;
            t2.next=null;

            ListNode head1= dummy1.next;
            ListNode head2 = dummy2.next;

            idx=1;

            ListNode ans = new ListNode(-1);
            ListNode current = ans;

            while(head1!=null && head2!=null){
                if(idx%2!=0){
                    current.next = head2;
                    current = current.next;
                    head2 = head2.next;
                    idx++;
                }
                else{
                    current.next = head1;
                    current = current.next;
                    head1=head1.next;
                    idx++;
                }
            }

            if(head2==null){
                current.next = head1;
            }
            else{
                current.next = head2;
            }
               ans= ans.next;
        return ans;

        }

    static void print(ListNode head) {
        ListNode t = head;
        while (t != null) {
            System.out.print(t.val + (t.next != null ? " -> " : "\n"));
            t = t.next;
        }
    }

    public static void main(String[] args) {
        SwapPairsSplitInterleave obj = new SwapPairsSplitInterleave();

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
