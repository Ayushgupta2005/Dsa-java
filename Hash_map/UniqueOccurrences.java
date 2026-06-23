package Hash_map;

import java.util.HashMap;
import java.util.HashSet;

/*
 * Problem: Unique Number of Occurrences (LeetCode 1207)
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class UniqueOccurrences {
    public boolean uniqueOccurrences(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i],1);
            }
            else{
                map.put(arr[i], map.get(arr[i])+1);
            }
        }
        HashSet<Integer> set = new HashSet<>();
        for(Integer key: map.keySet()){
            if(!set.contains(map.get(key))){
                set.add(map.get(key));
            }
            else{
                return false;
            }

        }
        return true;

    }

    public static void main(String[] args) {
        UniqueOccurrences obj = new UniqueOccurrences();
        System.out.println(obj.uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3})); // Expected: true
        System.out.println(obj.uniqueOccurrences(new int[]{1, 2}));             // Expected: false
    }
}
