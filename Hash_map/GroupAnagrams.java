package Hash_map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * Problem: Group Anagrams (LeetCode 49)
 *
 * Two words are anagrams exactly when their sorted forms match, so the
 * sorted string works as a signature key: Map<signature, list of words>.
 * Collect the map's values as the grouped answer.
 *
 * Time Complexity: O(n * k log k)  n words of length k
 * Space Complexity: O(n * k)
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String,ArrayList<String>> map = new HashMap<>();

        for(int i=0; i<strs.length; i++){

            String str = strs[i];
            char arr[] = str.toCharArray();
            Arrays.sort(arr);
            String s1 = new String(arr);

        if(!map.containsKey(s1)){
            map.put(s1, new ArrayList<String>());
        }
        map.get(s1).add(str);
        }

        List<List<String>> ans = new ArrayList<>();
        for(String key: map.keySet()){
            ans.add(map.get(key));
        }
        return ans;
    }

    public static void main(String[] args) {
        GroupAnagrams obj = new GroupAnagrams();
        System.out.println(obj.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
        // Expected (any order): [[eat, tea, ate], [tan, nat], [bat]]
        System.out.println(obj.groupAnagrams(new String[]{""}));   // Expected: [[]]
        System.out.println(obj.groupAnagrams(new String[]{"a"}));  // Expected: [[a]]
    }
}
