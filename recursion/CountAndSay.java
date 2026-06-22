/*
 * Problem: Count and Say (LeetCode 38)
 * Time Complexity: O(n * m)  m = length of the generated string
 * Space Complexity: O(m)
 */
public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1) return "1";

        String prev = countAndSay(n - 1);
        StringBuilder res = new StringBuilder();

        int i = 0;
        while (i < prev.length()) {
            int count = 1;
            while (i + 1 < prev.length() && prev.charAt(i) == prev.charAt(i + 1)) {
                i++;
                count++;
            }
            res.append(count).append(prev.charAt(i));
            i++;
        }

        return res.toString();
    }

    public static void main(String[] args) {
        CountAndSay obj = new CountAndSay();
        for (int n = 1; n <= 5; n++) {
            System.out.println(n + " -> " + obj.countAndSay(n));
        }
    }
}
