package stacks;
import java.util.Stack;

public class Maximal_Rectangle {

    public static int largestRectangleArea(int[] heights) {

        int[] nse = new int[heights.length];
        Stack<Integer> stk = new Stack<>();
        stk.push(heights.length - 1);
        nse[nse.length - 1] = heights.length;

        for (int i = nse.length - 2; i >= 0; i--) {

            while (!stk.isEmpty() && heights[stk.peek()] >= heights[i]) {
                stk.pop();
            }

            if (stk.isEmpty()) {
                nse[i] = nse.length;
            } else {
                nse[i] = stk.peek();
            }

            stk.push(i);
        }

        int[] pse = new int[heights.length];
        Stack<Integer> stk2 = new Stack<>();
        stk2.push(0);
        pse[0] = -1;

        for (int i = 1; i < pse.length; i++) {

            while (!stk2.isEmpty() && heights[stk2.peek()] >= heights[i]) {
                stk2.pop();
            }

            if (stk2.isEmpty()) {
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

    public static int maximalRectangle(char[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        for (int i = 0; i < matrix[0].length; i++) {

            int a = 0;

            for (int j = 0; j < matrix.length; j++) {

                if (matrix[j][i] != '0') {

                    int digit = matrix[j][i] - '0';
                    a += digit;
                    matrix[j][i] = (char) (a + '0');

                } else {
                    a = 0;
                }
            }
        }

        int max = 0;

        for (int i = 0; i < matrix.length; i++) {

            int[] arr = new int[matrix[0].length];

            for (int j = 0; j < matrix[0].length; j++) {
                arr[j] = matrix[i][j] - '0';
            }

            max = Math.max(max, largestRectangleArea(arr));
        }

        return max;
    }

    public static void main(String[] args) {

        char[][] matrix = {
                { '1', '0', '1', '0', '0' },
                { '1', '0', '1', '1', '1' },
                { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' }
        };

        int ans = maximalRectangle(matrix);

        System.out.println("Maximum Rectangle Area = " + ans);
    }
}
