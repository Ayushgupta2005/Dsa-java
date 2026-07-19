package stacks;
import java.util.*;

public class CanSeePerson {

    /*
     * Time Complexity: O(n)
     *
     * Space Complexity: O(n)
     */

    public static int[] canSeePersonsCount(int[] heights) {

        if (heights.length == 1) {
            int ans[] = {0};
            return ans;
        }

        Stack<Integer> stk = new Stack<>();

        int ans[] = new int[heights.length];
        ans[ans.length - 1] = 0;

        stk.push(heights[heights.length - 1]);

        for (int i = heights.length - 2; i >= 0; i--) {

            int count = 0;

            while (stk.size() > 0 && stk.peek() <= heights[i]) {
                stk.pop();
                count++;
            }

            if (stk.size() == 0) {
                ans[i] = count;
            } else {
                ans[i] = count + 1;
            }

            stk.push(heights[i]);
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] heights = {10, 6, 8, 5, 11, 9};

        int[] ans = canSeePersonsCount(heights);

        System.out.println("Visible Persons Count:");
        System.out.println(Arrays.toString(ans));
    }
}
