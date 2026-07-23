package stacks;
import java.util.*;

public class More_Practice {

    public static int[] finalPrices(int[] prices) {

        int n = prices.length;
        int[] ans = new int[n];

        Stack<Integer> stack = new Stack<>();

        ans[n - 1] = prices[n - 1];
        stack.push(prices[n - 1]);

        for (int i = n - 2; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek() > prices[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                ans[i] = prices[i];
            } else {
                ans[i] = prices[i] - stack.peek();
            }

            stack.push(prices[i]);
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] prices = {8, 4, 6, 2, 3};

        int[] result = finalPrices(prices);

        System.out.println(Arrays.toString(result));
    }
}
    
