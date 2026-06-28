package sliding_window;

import java.util.HashMap;

/*
 * Problem: Permutation in String (LeetCode 567)
 *
 * Fixed-size sliding window of length s1: keep a frequency map of s1 and a
 * frequency map of the current window in s2. Slide the window across s2,
 * adding the entering char and removing the leaving char; whenever the two
 * maps are equal, the window is a permutation of s1.
 *
 * Time Complexity: O(n + m)
 * Space Complexity: O(1)  (at most 26 keys per map)
 */
public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {

        if(s1.length()>s2.length()){
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s1.length(); i++){
            if(!map.containsKey(s1.charAt(i))){
                map.put(s1.charAt(i), 1);
            }
            else{
                map.put(s1.charAt(i),map.get(s1.charAt(i))+1);
            }
        }
        HashMap<Character, Integer> map2 = new HashMap<>();

        for(int i=0; i<s1.length(); i++){
            if(!map2.containsKey(s2.charAt(i))){
                map2.put(s2.charAt(i), 1);
            }
            else{
                map2.put(s2.charAt(i), map2.get(s2.charAt(i))+1);
            }
        }

        if(map.equals(map2)){
            return true;
        }

        for(int i=s1.length(); i<s2.length(); i++){
            if(!map2.containsKey(s2.charAt(i))){
                map2.put(s2.charAt(i), 1);
            }
            else{
                map2.put(s2.charAt(i),map2.get(s2.charAt(i))+1);
            }

            if(map2.get(s2.charAt(i-s1.length()))==1){
                map2.remove(s2.charAt(i-s1.length()));
            }
            else{
                map2.put(s2.charAt(i-s1.length()),map2.get(s2.charAt(i-s1.length()))-1);
            }

            if(map.equals(map2)){
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        PermutationInString obj = new PermutationInString();
        System.out.println(obj.checkInclusion("ab", "eidbaooo")); // Expected: true
        System.out.println(obj.checkInclusion("ab", "eidboaoo")); // Expected: false
    }
}
