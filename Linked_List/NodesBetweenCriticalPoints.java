package Linked_List;

import java.util.ArrayList;

/*
 * Problem: Find the Minimum and Maximum Number of Nodes Between Critical
 * Points (LeetCode 2058)
 *
 * A critical point is a local maxima or minima (strictly greater/less than
 * both neighbours) - endpoints can never qualify since they only have one
 * neighbour. Copy values into a list, scan the interior positions for
 * critical points, and record their 1-indexed positions. With fewer than
 * two critical points there's no pair, so return [-1,-1]. Otherwise the
 * minimum distance is the smallest gap between CONSECUTIVE critical points
 * (they're found in list order, so adjacent entries are automatically the
 * closest pair), and the maximum distance is simply first-to-last.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class NodesBetweenCriticalPoints {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public int[] nodesBetweenCriticalPoints(ListNode head) {

        ArrayList<Integer> l = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();

        ListNode temp = head;
        while(temp!=null){
            list.add(temp.val);
            temp = temp.next;
        }

        int count =0;
        for(int i=0; i<list.size();i++){

            if(i==0 || i==list.size()-1) continue;

            if(list.get(i)>list.get(i-1) && list.get(i)>list.get(i+1)){
                l.add(i+1);
            }
            else if(list.get(i)<list.get(i-1) && list.get(i)<list.get(i+1)){
                l.add(i+1);
            }
        }

        if(l.size()<2){
            int[] arr = {-1,-1};
            return arr;
        }

        int min=Integer.MAX_VALUE;
        for(int i=0; i<l.size()-1; i++){
            int a = l.get(i+1)-l.get(i);
            min=Math.min(min,a);
        }


        int max= l.get(l.size()-1)-l.get(0);

        int ans[] ={min,max};
        return ans;
    }

    static ListNode build(int... vals) {
        ListNode dummy = new ListNode(-1);
        ListNode t = dummy;
        for (int v : vals) { t.next = new ListNode(v); t = t.next; }
        return dummy.next;
    }

    public static void main(String[] args) {
        NodesBetweenCriticalPoints obj = new NodesBetweenCriticalPoints();
        System.out.println(java.util.Arrays.toString(obj.nodesBetweenCriticalPoints(build(3,1)))); // Expected: [-1, -1]
        System.out.println(java.util.Arrays.toString(obj.nodesBetweenCriticalPoints(build(5,3,1,2,5,1,2)))); // Expected: [1, 3]
        System.out.println(java.util.Arrays.toString(obj.nodesBetweenCriticalPoints(build(1,3,2,2,3,2,2,2,7)))); // Expected: [3, 3]
    }
}
