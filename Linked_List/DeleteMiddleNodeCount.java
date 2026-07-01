package Linked_List;

/*
 * Problem: Delete the Middle Node of a Linked List (LeetCode 2095) - count then walk
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class DeleteMiddleNodeCount {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteMiddle(ListNode head) {
        if(head==null || head.next==null){
            return null;
        }
        int count =0;

        ListNode temp = head;

        while(temp!=null){
            count++;
            temp=temp.next;
        }

        count = count/2;
        temp =head;

        for(int i=1; i<count; i++){
            temp=temp.next;
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
    }

    public static void main(String[] args) {
        DeleteMiddleNodeCount obj = new DeleteMiddleNodeCount();

        // List: 1 -> 2 -> 3 -> 4 -> 5 -> 6 , delete middle (index 3 -> value 4)
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        print(obj.deleteMiddle(head));
    }
}
