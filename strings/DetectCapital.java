package strings;

/*
 * Problem: Detect Capital (LeetCode 520)
 *
 * Capital usage is correct in exactly three cases: all letters uppercase,
 * all lowercase, or only the first letter uppercase. Count the uppercase
 * letters once and check which case it falls into.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class DetectCapital {
    public boolean detectCapitalUse(String word) {


        int count =0;

        for(int i=0; i<word.length(); i++){
            if(Character.isUpperCase(word.charAt(i))) count++;
        }

        if(count==word.length()) return true;
        if(count==0) return true;

        if(count ==1 && Character.isUpperCase(word.charAt(0))){
            return true;
        }

        return false;

    }

    public static void main(String[] args) {
        DetectCapital obj = new DetectCapital();
        System.out.println(obj.detectCapitalUse("USA"));    // Expected: true
        System.out.println(obj.detectCapitalUse("FlaG"));   // Expected: false
        System.out.println(obj.detectCapitalUse("Google")); // Expected: true
        System.out.println(obj.detectCapitalUse("leetcode"));// Expected: true
    }
}
