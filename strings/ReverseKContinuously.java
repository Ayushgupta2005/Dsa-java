package strings;

class Solution {

    public static String reverse(String s) {
        char arr[] = s.toCharArray();

        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }

        return new String(arr);
    }

    public String reverseStr(String s, int k) {

        String rev = "";
        int a = 0;

        while (a < s.length()) {

            String str = "";
            int run = a + k;

            for (int i = a; i < run; i++) {
                if (i >= s.length()) {
                    break;
                }

                str = str + s.charAt(i);
                a++;
            }

            rev = rev + reverse(str);

            if (a == s.length()) {
                break;
            }

            run = a + k;

            for (int i = a; i < run; i++) {
                if (i >= s.length()) {
                    break;
                }

                a++;
                rev = rev + s.charAt(i);
            }
        }

        return rev;
    }
}


public class ReverseKContinuously {

    public static void main(String[] args) {

        Solution solution = new Solution();

        String s = "abcdefg";
        int k = 2;

        String answer = solution.reverseStr(s, k);

        System.out.println("Input:    " + s);
        System.out.println("k:        " + k);
        System.out.println("Output:   " + answer);
        System.out.println("Expected: bacdfeg");
    }
}
