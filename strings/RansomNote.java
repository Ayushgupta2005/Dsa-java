package strings;

/*
 * Problem: Ransom Note (LeetCode 383)
 *
 * Count every letter available in the magazine, then spend them on the
 * ransom note: if any count drops below zero, a needed letter ran out.
 *
 * Time Complexity: O(n + m)
 * Space Complexity: O(1)  (fixed 26-size array)
 */
public class RansomNote {
    public boolean canConstruct(String a, String b) {

        int arr[] = new int[26];

        for(int i=0; i<b.length();i++){
            arr[b.charAt(i)-'a']++;
        }

        for(int i=0; i<a.length();i++){
             arr[a.charAt(i)-'a']--;

             if( arr[a.charAt(i)-'a']<0) return false;
        }
        return true;

    }

    public static void main(String[] args) {
        RansomNote obj = new RansomNote();
        System.out.println(obj.canConstruct("a", "b"));    // Expected: false
        System.out.println(obj.canConstruct("aa", "ab"));  // Expected: false
        System.out.println(obj.canConstruct("aa", "aab")); // Expected: true
    }
}
