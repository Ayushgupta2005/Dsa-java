package sliding_window;

import java.util.HashSet;

/*
 * Problem: Longest Substring Without Repeating Characters (LeetCode 3)
 *
 * Variable-size sliding window: expand j while chars are unique (tracked in
 * a HashSet); on a duplicate, shrink i from the left until the earlier copy
 * of s.charAt(j) is removed, then continue.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(min(n, charset))
 */
public class LongestSubstringWithoutRepeating {
    public int lengthOfLongestSubstring(String s) {

        if(s.length()==0 || s.length()==1){
            return s.length();
        }

       HashSet<Character> set = new HashSet<>();

        int i=0;
        int j=1;
        int max=1;

        set.add(s.charAt(i));
        while(j<s.length()){

            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                max = Math.max(max, j-i);

            }
            else{
                while(s.charAt(i)!=s.charAt(j)){
                    set.remove(s.charAt(i));
                    i++;
                }
                i++;
                j++;
            }

        }
        return max;

    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeating obj = new LongestSubstringWithoutRepeating();
        System.out.println(obj.lengthOfLongestSubstring("abcabcbb")); // Expected: 3
        System.out.println(obj.lengthOfLongestSubstring("bbbbb"));    // Expected: 1
        System.out.println(obj.lengthOfLongestSubstring("pwwkew"));   // Expected: 3
    }
}
