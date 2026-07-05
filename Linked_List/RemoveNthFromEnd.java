package Linked_List;

/*
 * Problem: Remove Nth Node From End of List (LeetCode 19)
 * Time Complexity: O(L)
 * Space Complexity: O(1)
 */
public class RemoveNthFromEnd {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head==null || head.next == null){
            return null;
        }

        int count=0;

        ListNode temp = head;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
           if(n==count){
            head=head.next;
            return head;
        }

        count = count-n;
        temp = head;

        for(int i=1; i<count; i++){
            temp = temp.next;
        }
        if(n==1){
            temp.next = null;
            return head;
        }

        temp.next = temp.next.next;
        return head;

    }

    static void print(ListNode head) {
        ListNode t = head;
        while (t != null) {
            System.out.print(t.val + (t.next != null ? " -> " : "\n"));
            t = t.next;
        }
        if (head == null) System.out.println("empty");
    }

    public static void main(String[] args) {
        RemoveNthFromEnd obj = new RemoveNthFromEnd();

        // List: 1 -> 2 -> 3 -> 4 -> 5 , remove 2nd from end (value 4)
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        print(obj.removeNthFromEnd(head, 2)); // Expected: 1 -> 2 -> 3 -> 5
    }
}
