package strings;

/*
 * Problem: Check if the Sentence Is Pangram (LeetCode 1832)
 *
 * Count each letter with a 26-slot array indexed by ch - 'a'; the sentence
 * is a pangram only if every slot ended up non-zero.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)  (fixed 26-size array)
 */
public class CheckIfPangram {
    public boolean checkIfPangram(String sentence) {

        int check[] = new int[26];

        for(int i=0; i<sentence.length(); i++){

            char ch = sentence.charAt(i);
            check[ch-'a']=check[ch-'a']+1;
        }

        for(int i=0; i<check.length; i++){
            if(check[i]==0) return false;
        }
        return true;

    }

    public static void main(String[] args) {
        CheckIfPangram obj = new CheckIfPangram();
        System.out.println(obj.checkIfPangram("thequickbrownfoxjumpsoverthelazydog")); // Expected: true
        System.out.println(obj.checkIfPangram("leetcode"));                            // Expected: false
    }
}
