package strings;

/*
 * Problem: Remove Consecutive Duplicates from a String (GeeksforGeeks)
 *
 * Collapse every run of repeated adjacent characters into a single
 * occurrence: append the run's char once, then skip past the whole run.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class RemoveConsecutiveDuplicates {
    public String removeDuplicates(String s) {
        int n = s.length();

        if(n==0 || n==1){
            return s;
        }

        StringBuilder str = new StringBuilder();

        int i=0;

        while(i<n){
            char ch = s.charAt(i);
            str.append(ch);

            while(i<n && s.charAt(i)==ch){
                i++;
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        RemoveConsecutiveDuplicates obj = new RemoveConsecutiveDuplicates();
        System.out.println(obj.removeDuplicates("aabbcc"));   // Expected: abc
        System.out.println(obj.removeDuplicates("aabaa"));    // Expected: aba
        System.out.println(obj.removeDuplicates("geeksforgeeks")); // Expected: geksforgeks
    }
}
