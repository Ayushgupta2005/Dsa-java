package Linked_List;

/*
 * Problem: Split Linked List in Parts (LeetCode 725)
 *
 * Split the list into k consecutive parts as equal as possible: each part
 * gets count/k nodes, and the first count%k parts get one extra. Walk j to
 * each part's last node, cut the link, store the part's head, and continue
 * from the next node. Parts beyond the list's length stay null.
 *
 * Time Complexity: O(n + k)
 * Space Complexity: O(1)  (excluding the output array)
 */
public class SplitListToParts {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode[] splitListToParts(ListNode head, int k) {

        ListNode ans[] = new ListNode[k];
        int count=0;

        ListNode temp = head;
        while(temp!=null){
            count++;
            temp= temp.next;
        }

        int n = count/k;
        int rem = count %k;
        int a =0;
        int index =0;

        ListNode i = head;
        ListNode j = head;

        for(int b=0; b<k && i!=null; b++){
            if(rem >0){
                a=1;
                rem--;
            }
            else{
                a=0;
            }
            int loop = 0;

            while(loop<n+a-1){
                j=j.next;
                loop++;
            }
            ListNode tempp = j.next;
            j.next =null;
            ans[index] = i;
            i=tempp;
            j= tempp;
            index++;
        }

        return ans;

    }

    static void print(ListNode head) {
        ListNode t = head;
        if (t == null) { System.out.print("null"); return; }
        System.out.print("[");
        while (t != null) {
            System.out.print(t.val + (t.next != null ? "," : ""));
            t = t.next;
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        SplitListToParts obj = new SplitListToParts();

        // List: 1 -> 2 -> 3 , k = 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        ListNode[] parts = obj.splitListToParts(head, 5);
        for (int p = 0; p < parts.length; p++) {
            print(parts[p]);
            System.out.print(p < parts.length - 1 ? " " : "\n");
        }
        // Expected: [1] [2] [3] null null

        // List: 1..10 , k = 3
        ListNode head2 = new ListNode(1);
        ListNode t2 = head2;
        for (int v = 2; v <= 10; v++) { t2.next = new ListNode(v); t2 = t2.next; }

        ListNode[] parts2 = obj.splitListToParts(head2, 3);
        for (int p = 0; p < parts2.length; p++) {
            print(parts2[p]);
            System.out.print(p < parts2.length - 1 ? " " : "\n");
        }
        // Expected: [1,2,3,4] [5,6,7] [8,9,10]
    }
}
