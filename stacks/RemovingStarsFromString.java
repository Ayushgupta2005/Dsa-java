package stacks;

/*
 * Problem: Removing Stars From a String (LeetCode 2390)
 *
 * Each '*' removes the closest non-star character to its left - classic
 * stack behaviour, using the StringBuilder itself as the stack:
 * append = push, deleteCharAt(length-1) = pop. No final reverse needed.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class RemovingStarsFromString {
    public String removeStars(String s) {

        StringBuilder str = new StringBuilder();

        for(int i=0; i<s.length();i++){
            if(s.charAt(i)=='*'){
                str.deleteCharAt(str.length()-1);
            }
            else
            str.append(s.charAt(i));
        }

        return str.toString();

    }

    public static void main(String[] args) {
        RemovingStarsFromString obj = new RemovingStarsFromString();
        System.out.println(obj.removeStars("leet**cod*e")); // Expected: lecoe
        System.out.println(obj.removeStars("erase*****")); // Expected: (empty)
    }
}
