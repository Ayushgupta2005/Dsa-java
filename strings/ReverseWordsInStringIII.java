package strings;

public class ReverseWordsInStringIII {

    public static String reverse(String s) {

        String rev = "";

        for (int i = s.length() - 1; i >= 0; i--) {
            rev = rev + s.charAt(i);
        }

        return rev;
    }

    public static String reverseWords(String s) {

        String ans = "";
        int i = 0;

        while (i < s.length()) {

            String word = "";

            while (i < s.length() && s.charAt(i) != ' ') {
                word = word + s.charAt(i);
                i++;
            }

            if (i == s.length()) {
                ans = ans + reverse(word);
                return ans;
            } else {
                ans = ans + reverse(word);
                ans = ans + ' ';
                i++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        String s = "Let's take LeetCode contest";

        System.out.println(reverseWords(s));
    }
}
