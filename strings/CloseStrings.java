package strings;
import java.util.*;
   /*
Problem: Determine if Two Strings Are Close (LeetCode 1657)

Time Complexity: O(n + k log k)
Space Complexity: O(k)

where:
n = length of string
k = number of distinct characters
*/
public class CloseStrings {

    public static boolean closeStrings(String word1, String word2) {

        if (word1.length() != word2.length()) {
            return false;
        }

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for (char ch : word1.toCharArray()) {
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }

        for (char ch : word2.toCharArray()) {
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }

        if (!map1.keySet().equals(map2.keySet())) {
            return false;
        }

        ArrayList<Integer> freq1 = new ArrayList<>(map1.values());
        ArrayList<Integer> freq2 = new ArrayList<>(map2.values());

        Collections.sort(freq1);
        Collections.sort(freq2);

        return freq1.equals(freq2);
    }

    public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "bca";

        System.out.println(closeStrings(word1, word2));
    }
}
    
