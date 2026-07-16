package stacks;

import java.util.Stack;

/*
 * Problem: Remove Nodes From Linked List (LeetCode 2487)
 *
 * Remove every node that has a strictly greater value anywhere to its right.
 * Reverse the list, then walk it keeping only nodes >= the last kept node
 * (stack top) - i.e. the running maximum from the original right side.
 * Popping the stack rebuilds the survivors in original order.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class RemoveNodesFromLinkedList {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode reversee(ListNode temp){
        ListNode t = null;

        ListNode curr = temp;

        while(curr!=null){
            ListNode a= curr.next;
            curr.next = t;
            t=curr;
            curr = a;

        }
        return t;

    }
    public ListNode removeNodes(ListNode head) {

        if(head.next ==null){
            return head;
        }

        ListNode temp = head;

        temp = reversee(temp);
        ListNode temp2= temp;

        Stack<ListNode> stk = new Stack<>();

        while(temp2!=null){
            if(stk.size()==0){
                stk.push(temp2);
            }

            ListNode b = stk.peek();
            int a = b.val;
            if(a>temp2.val){
                //skip
            }
            else{
                stk.push(temp2);
            }
            temp2 = temp2.next;
        }

        temp = stk.pop();
        temp2 = temp;

        while(stk.size()>0){
            temp.next = stk.pop();
            temp = temp.next;
        }

        temp.next = null;
        return temp2;

    }

    static void print(ListNode head) {
        ListNode t = head;
        while (t != null) {
            System.out.print(t.val + (t.next != null ? " -> " : "\n"));
            t = t.next;
        }
    }

    public static void main(String[] args) {
        RemoveNodesFromLinkedList obj = new RemoveNodesFromLinkedList();

        // List: 5 -> 2 -> 13 -> 3 -> 8
        ListNode head = new ListNode(5);
        head.next = new ListNode(2);
        head.next.next = new ListNode(13);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(8);

        print(obj.removeNodes(head)); // Expected: 13 -> 8

        // List: 1 -> 1 -> 1 -> 1
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(1);
        head2.next.next.next = new ListNode(1);

        print(obj.removeNodes(head2)); // Expected: 1 -> 1 -> 1 -> 1
    }
}
