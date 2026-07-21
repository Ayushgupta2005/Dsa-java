package Linked_List;

import java.util.Arrays;

/*
 * Problem: Spiral Matrix IV (LeetCode 2326)
 *
 * Fill an m x n matrix in spiral order with the linked list's values;
 * remaining cells stay -1. Classic four-boundary spiral (top row, right
 * column, bottom row, left column, then shrink the boundaries), returning
 * early the moment the list runs out.
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(1)  (excluding the output matrix)
 */
public class SpiralMatrixIV {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public int[][] spiralMatrix(int m, int n, ListNode head) {

        int[][] sol = new int[m][n];

        for (int i = 0; i < sol.length; i++) {
            Arrays.fill(sol[i], -1);
        }

        int fc = 0;
        int fr = 0;

        int lr = m - 1;
        int lc = n - 1;
        ListNode temp = head;

        while (fr <= lr && fc <= lc) {

            if (fr > lr || fc > lc) {
                break;
            } else {

                for (int i = fc; i <= lc; i++) {
                    sol[fr][i] = temp.val;
                    temp = temp.next;
                    if (temp == null) {
                        return sol;
                    }
                }
            }

            fr++;

            if (fr > lr || fc > lc) {
                break;
            } else {
                for (int i = fr; i <= lr; i++) {
                    sol[i][lc] = temp.val;
                    temp = temp.next;
                    if (temp == null) {
                        return sol;
                    }
                }
            }

            lc--;

            if (fr > lr || fc > lc) {
                break;
            } else {
                for (int i = lc; i >= fc; i--) {
                    sol[lr][i] = temp.val;
                    temp = temp.next;
                    if (temp == null) {
                        return sol;
                    }
                }
            }

            lr--;

            if (fr > lr && fc > lc) {
                break;
            } else {
                for (int i = lr; i >= fr; i--) {
                    sol[i][fc] = temp.val;
                    temp = temp.next;
                    if (temp == null) {
                        return sol;
                    }
                }
            }
            fc++;
        }
        return sol;
    }

    public static void main(String[] args) {
        SpiralMatrixIV obj = new SpiralMatrixIV();

        // List: 3 -> 0 -> 2 -> 6 -> 8 -> 1 -> 7 -> 9 -> 4 -> 2 -> 5 -> 5 -> 0 , m=3, n=5
        int[] vals = {3, 0, 2, 6, 8, 1, 7, 9, 4, 2, 5, 5, 0};
        ListNode head = new ListNode(vals[0]);
        ListNode t = head;
        for (int i = 1; i < vals.length; i++) { t.next = new ListNode(vals[i]); t = t.next; }

        int[][] res = obj.spiralMatrix(3, 5, head);
        for (int[] row : res) System.out.println(Arrays.toString(row));
        // Expected:
        // [3, 0, 2, 6, 8]
        // [5, 0, -1, -1, 1]
        // [5, 2, 4, 9, 7]

        // List: 0 -> 1 -> 2 , m=1, n=4
        ListNode head2 = new ListNode(0);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(2);

        int[][] res2 = obj.spiralMatrix(1, 4, head2);
        for (int[] row : res2) System.out.println(Arrays.toString(row));
        // Expected: [0, 1, 2, -1]
    }
}
