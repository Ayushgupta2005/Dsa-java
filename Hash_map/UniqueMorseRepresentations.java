package Hash_map;

import java.util.HashMap;
import java.util.HashSet;

/*
 * Problem: Unique Morse Code Words (LeetCode 804)
 * Time Complexity: O(n * k)  n = words, k = avg word length
 * Space Complexity: O(n * k)
 */
public class UniqueMorseRepresentations {

    public static String generate(String str, HashMap<Character, String> map){
        StringBuilder strr = new StringBuilder();
        for(int i=0; i<str.length(); i++){
            strr.append(map.get(str.charAt(i)));
        }
        return strr.toString();

    }
    public int uniqueMorseRepresentations(String[] words) {

        HashMap<Character, String> mp = new HashMap<>();
        mp.put('a', ".-");
        mp.put('b', "-...");
        mp.put('c', "-.-.");
        mp.put('d', "-..");
        mp.put('e', ".");
        mp.put('f', "..-.");
        mp.put('g', "--.");
        mp.put('h', "....");
        mp.put('i', "..");
        mp.put('j', ".---");
        mp.put('k', "-.-");
        mp.put('l', ".-..");
        mp.put('m', "--");
        mp.put('n', "-.");
        mp.put('o', "---");
        mp.put('p', ".--.");
        mp.put('q', "--.-");
        mp.put('r', ".-.");
        mp.put('s', "...");
        mp.put('t', "-");
        mp.put('u', "..-");
        mp.put('v', "...-");
        mp.put('w', ".--");
        mp.put('x', "-..-");
        mp.put('y', "-.--");
        mp.put('z', "--..");

        HashSet<String> set = new HashSet<>();

        for(int i=0; i<words.length; i++){
            String str = generate(words[i],mp);
            set.add(str);
        }
        return set.size();
    }

    public static void main(String[] args) {
        UniqueMorseRepresentations obj = new UniqueMorseRepresentations();
        System.out.println(obj.uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"})); // Expected: 2
        System.out.println(obj.uniqueMorseRepresentations(new String[]{"a"}));                         // Expected: 1
    }
}
