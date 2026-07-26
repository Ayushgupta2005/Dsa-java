package Linked_List;
import java.math.BigInteger;

class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class AddtwoNumber {
    public static ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }

    // Time Complexity: O(n + m)
    // n = length of first list
    // m = length of second list

    // Space Complexity: O(max(n, m))
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1.val == 0) {
            return l2;
        }

        if (l2.val == 0) {
            return l1;
        }

        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ZERO;

        ListNode temp1 = l1;
        ListNode temp2 = l2;

        while (temp1 != null) {
            a = a.multiply(BigInteger.TEN).add(BigInteger.valueOf(temp1.val));
            temp1 = temp1.next;
        }

        while (temp2 != null) {
            b = b.multiply(BigInteger.TEN).add(BigInteger.valueOf(temp2.val));
            temp2 = temp2.next;
        }

        BigInteger res = a.add(b);

        ListNode dummy = new ListNode(-1);
        ListNode t = dummy;

        while (!res.equals(BigInteger.ZERO)) {
            int n = res.mod(BigInteger.TEN).intValue();

            ListNode node = new ListNode(n);
            t.next = node;
            t = t.next;

            res = res.divide(BigInteger.TEN);
        }

        t.next = null;

        t = dummy.next;
        t = reverseList(t);

        return t;
    }

    // Helper function to create a linked list
    public static ListNode createList(int[] arr) {

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        for (int x : arr) {
            temp.next = new ListNode(x);
            temp = temp.next;
        }

        return dummy.next;
    }

    // Helper function to print a linked list
    public static void printList(ListNode head) {

        while (head != null) {
            System.out.print(head.val);

            if (head.next != null)
                System.out.print(" -> ");

            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

         AddtwoNumber obj = new AddtwoNumber();

        // Example Input
        int[] arr1 = {2, 4, 3};
        int[] arr2 = {5, 6, 4};

        ListNode l1 = createList(arr1);
        ListNode l2 = createList(arr2);

        System.out.print("List 1: ");
        printList(l1);

        System.out.print("List 2: ");
        printList(l2);

        ListNode ans = obj.addTwoNumbers(l1, l2);

        System.out.print("Result: ");
        printList(ans);
    }
}

