package Hash_map;

import java.util.HashMap;

public class HighestFrequencyCharacter {

    public static void main(String[] args) {
        
          String str = "aabbbccdde";

        

        HashMap<Character, Integer> map = new HashMap<>();

        // Count frequency

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if (map.containsKey(ch)) {

                map.put(ch, map.get(ch) + 1);

            } else {

                map.put(ch, 1);

            }

        }

        // Find highest frequency character

        char maxChar = ' ';

        int maxFreq = 0;

        for (char key : map.keySet()) {

            if (map.get(key) > maxFreq) {

                maxFreq = map.get(key);

                maxChar = key;

            }

        }

        System.out.println("Highest frequency character: " + maxChar);

        System.out.println("Frequency: " + maxFreq);
    }
    
}
