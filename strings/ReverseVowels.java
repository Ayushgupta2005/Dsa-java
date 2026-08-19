package strings;

/*
 * Problem: Reverse Vowels of a String (LeetCode 345)
 *
 * Convergent two pointers: advance left until it lands on a vowel, pull
 * right back until it lands on a vowel, swap the pair, and step both
 * inward. Non-vowels never move.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n) for the char array
 */
public class ReverseVowels {
    public String reverseVowels(String s) {
        char[] a = s.toCharArray();
        int left = 0, right = a.length - 1;

        while (left < right) {
            while (left < right && !isVowel(a[left]))
                left++;

            while (left < right && !isVowel(a[right]))
                right--;

            char temp = a[left];
            a[left] = a[right];
            a[right] = temp;

            left++;
            right--;
        }

        return new String(a);
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }

    public static void main(String[] args) {
        ReverseVowels obj = new ReverseVowels();
        System.out.println(obj.reverseVowels("IceCreAm")); // Expected: AceCreIm
        System.out.println(obj.reverseVowels("leetcode")); // Expected: leotcede
        System.out.println(obj.reverseVowels("hello"));    // Expected: holle
        System.out.println(obj.reverseVowels("bcdfg"));    // Expected: bcdfg (no vowels)
    }
}
