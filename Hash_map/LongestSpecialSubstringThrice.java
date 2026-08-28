package Hash_map;

import java.util.HashMap;

/*
 * Problem: Find Longest Special Substring That Occurs Thrice I (LeetCode 2981)
 *
 * A "special" substring is made of a single repeated character (e.g. "aaa").
 * Enumerate every substring, keep only the special ones, and count how many
 * times each occurs. The answer is the length of the longest special
 * substring whose count reaches 3, or -1 if none does.
 *
 * Time Complexity: O(n^3)  (n^2 substrings, each up to O(n) to build/check)
 * Space Complexity: O(n^2)
 */
public class LongestSpecialSubstringThrice {

    public static boolean check(String s){

        if(s.length()==1) return true;
        int ch = s.charAt(0);
        for(int i=1; i<s.length(); i++){
            char chh = s.charAt(i);
            if(ch!=chh) return false;
        }
        return true;
    }

    public int maximumLength(String s) {
        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){

            for(int j=i+1; j<=s.length(); j++){

                String str = s.substring(i,j);
                if(map.containsKey(str)){
                    map.put(str,map.get(str)+1);
                }
                else{
                if(check(str)){
                    map.put(str,1);
                }
            }
        }
    }
    int ans=-1;

    for(String key: map.keySet()){
        if(map.get(key)>=3 && key.length()>ans){
            ans =key.length();
        }
    }
    return ans;
}

    public static void main(String[] args) {
        LongestSpecialSubstringThrice obj = new LongestSpecialSubstringThrice();
        System.out.println(obj.maximumLength("aaaa"));   // Expected: 2
        System.out.println(obj.maximumLength("abcdef")); // Expected: -1
        System.out.println(obj.maximumLength("abcaba")); // Expected: 1
    }
}
