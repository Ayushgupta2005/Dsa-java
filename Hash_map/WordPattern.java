package Hash_map;

import java.util.HashMap;

/*
 * Problem: Word Pattern (LeetCode 290)
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class WordPattern {

    public static boolean wordPattern(String pattern, String s) {

        HashMap<Character, String> map1 = new HashMap<>();
        HashMap<String, Character> map2 = new HashMap<>();

        char[] ch1 = pattern.toCharArray();
        String[] ch2 = s.split(" ");

        if (ch1.length != ch2.length) return false;

        for (int i = 0; i < ch1.length; i++) {
            if (!map1.containsKey(ch1[i])) {
                map1.put(ch1[i], ch2[i]);
            }

            if (!map2.containsKey(ch2[i])) {
                map2.put(ch2[i], ch1[i]);
            }

            if (!ch2[i].equals(map1.get(ch1[i])) ||
                map2.get(ch2[i]) != ch1[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog")); 
        System.out.println(wordPattern("abba", "dog cat cat fish")); 
        System.out.println(wordPattern("aaaa", "dog cat cat dog"));  
    }
}
