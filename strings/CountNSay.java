/**
 * LeetCode 202 - Happy Number
 * Description:
 * A happy number is a number that eventually reaches 1 when replaced
 * by the sum of the squares of its digits repeatedly.
* Time Complexity: O(log n) in practice
 * Space Complexity: O(log n)
 */
package strings;

public class CountNSay {

    public static String countAndSay(int n) {

        if (n == 1) {
            return "1";
        }

        String current = "1";

        for (int step = 0; step < n - 1; step++) {

            StringBuilder next = new StringBuilder();

            int i = 0;

            while (i < current.length()) {

                char digit = current.charAt(i);
                int count = 1;
                i++;

                while (i < current.length() && current.charAt(i) == digit) {
                    count++;
                    i++;
                }
                next.append(count);
                next.append(digit);
            }

            current = next.toString();
        }

        return current;
    }

    public static void main(String[] args) {

        int[] testCases = {1, 2, 3, 4, 5, 6};

        for (int n : testCases) {
            System.out.println("n = " + n + countAndSay(n));
        }
    }
}

