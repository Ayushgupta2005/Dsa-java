package strings;

public class Find_The_Difference{

    /*
LeetCode 389 - Find the Difference

Time Complexity: O(n)
Space Complexity: O(1)

Approach:
XOR all characters from both strings.
Matching characters cancel out because:

a ^ a = 0
0 ^ a = a

The remaining value after all XOR operations
is the extra character.
*/
    public static char findTheDifference(String s, String t) {
        char ans = 0;

        for (int i = 0; i < s.length(); i++) {
            ans ^= s.charAt(i);
        }

        for (int i = 0; i < t.length(); i++) {
            ans ^= t.charAt(i);
        }

        return ans;
    }

    public static void main(String[] args) {

        String s = "abcd";
        String t = "abcde";

        char result = findTheDifference(s, t);

        System.out.println("Extra Character: " + result);
    }
}