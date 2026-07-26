package stacks;
import java.util.Stack;
public class RemoveKdigits {

public class Main {

    // Time Complexity: O(n)
    // Space Complexity: O(n)

    public static String removeKdigits(String num, int k) {

        if (num.length() == k) {
            return "0";
        }

        Stack<Character> stk = new Stack<>();

        stk.push(num.charAt(0));

        for (int i = 1; i < num.length(); i++) {

            while (stk.size() > 0 && k > 0 && stk.peek() > num.charAt(i)) {
                stk.pop();
                k--;
            }

            stk.push(num.charAt(i));
        }

        while (k > 0) {
            stk.pop();
            k--;
        }

        StringBuilder str = new StringBuilder();

        while (stk.size() > 0) {
            str.append(stk.pop());
        }

        str.reverse();

        while (str.length() > 0 && str.charAt(0) == '0') {
            str.deleteCharAt(0);
        }

        String ans = str.toString();

        if (ans.length() == 0) {
            return "0";
        }

        return ans;
    }

    public static void main(String[] args) {

        String num1 = "1432219";
        int k1 = 3;
        System.out.println(removeKdigits(num1, k1)); 

        String num2 = "10200";
        int k2 = 1;
        System.out.println(removeKdigits(num2, k2)); 

        String num3 = "10";
        int k3 = 2;
        System.out.println(removeKdigits(num3, k3)); 
    }
}
    
}
