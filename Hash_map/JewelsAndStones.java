package Hash_map;

import java.util.HashSet;

/*
 * Problem: Jewels and Stones (LeetCode 771)
 * Time Complexity: O(n + m)
 * Space Complexity: O(n)
 */
public class JewelsAndStones {
    public int numJewelsInStones(String jewels, String stones) {

       HashSet<Character> set = new HashSet<>();

       for(int i=0; i<jewels.length(); i++){
        set.add(jewels.charAt(i));
       }
       int count =0;

       for(int i=0; i<stones.length(); i++){

        if(set.contains(stones.charAt(i))){
            count++;
        }
       }
       return count;

    }

    public static void main(String[] args) {
        JewelsAndStones obj = new JewelsAndStones();
        System.out.println(obj.numJewelsInStones("aA", "aAAbbbb")); // Expected: 3
        System.out.println(obj.numJewelsInStones("z", "ZZ"));       // Expected: 0
    }
}
