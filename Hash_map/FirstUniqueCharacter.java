package Hash_map;

/*
 * Problem: First Unique Character in a String (LeetCode 387)
 * Time Complexity: O(n)
 * Space Complexity: O(1)  (fixed 26-size count array)
 */
public class FirstUniqueCharacter {
    public int firstUniqChar(String s) {

        int count[] = new int[26];

        for(int i=0; i<s.length(); i++){
            count[s.charAt(i) - 'a']++;

        }

        for(int i=0; i<s.length(); i++){
            if(count[s.charAt(i)-'a']==1){
                return i;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        FirstUniqueCharacter obj = new FirstUniqueCharacter();
        System.out.println(obj.firstUniqChar("leetcode"));   // Expected: 0
        System.out.println(obj.firstUniqChar("loveleetcode")); // Expected: 2
        System.out.println(obj.firstUniqChar("aabb"));       // Expected: -1
    }
}
