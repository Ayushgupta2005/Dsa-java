package Hash_map;

import java.util.*;

public class TwoStringAnagram {

    public static int minSteps(String s, String t) {

        HashMap<Character, Integer> map1 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!map1.containsKey(s.charAt(i))) {
                map1.put(s.charAt(i), 1);
            } else {
                map1.put(s.charAt(i), map1.get(s.charAt(i)) + 1);
            }
        }

        HashMap<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            if (!map2.containsKey(t.charAt(i))) {
                map2.put(t.charAt(i), 1);
            } else {
                map2.put(t.charAt(i), map2.get(t.charAt(i)) + 1);
            }
        }

        int ans = 0;

        for (Character key : map2.keySet()) {

            if (map1.containsKey(key)) {

                int a = map1.get(key);
                int b = map2.get(key);

                if (b > a) {
                    ans = ans + Math.abs(a - b);
                }

            } else {
                ans = ans + map2.get(key);
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        String s = "bab";
        String t = "aba";

        System.out.println(minSteps(s, t));
    }
}