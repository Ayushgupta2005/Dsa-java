package stacks;
import java.util.*;
public class LargestRectangleArea {

    /*
     * Time Complexity: O(n)
     * O(3n)
     * Space Complexity: O(n)
     * Overall Auxiliary Space: O(n)
     */

    public static int largestRectangleArea(int[] heights) {

        int nse[] = new int[heights.length];
        Stack<Integer> stk = new Stack<>();

        stk.push(heights.length - 1);
        nse[nse.length - 1] = heights.length;

        for (int i = nse.length - 2; i >= 0; i--) {

            while (stk.size() > 0 && heights[stk.peek()] >= heights[i]) {
                stk.pop();
            }

            if (stk.size() == 0) {
                nse[i] = nse.length;
            } else {
                nse[i] = stk.peek();
            }

            stk.push(i);
        }

        int pse[] = new int[heights.length];
        Stack<Integer> stk2 = new Stack<>();

        stk2.push(0);
        pse[0] = -1;

        for (int i = 1; i < pse.length; i++) {

            while (stk2.size() > 0 && heights[stk2.peek()] >= heights[i]) {
                stk2.pop();
            }

            if (stk2.size() == 0) {
                pse[i] = -1;
            } else {
                pse[i] = stk2.peek();
            }

            stk2.push(i);
        }

        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            int area = heights[i] * (nse[i] - pse[i] - 1);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public static void main(String[] args) {

        int[] heights = {2, 1, 5, 6, 2, 3};

        int ans =largestRectangleArea(heights);

        System.out.println("Largest Rectangle Area: " + ans);
    }
}