package stacks;

import java.util.Stack;

/*
 * Problem: Remove Consecutive Duplicates from a String (GeeksforGeeks) - stack approach
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class RemoveConsecutiveDuplicatesStack {
    public String removeDuplicates(String s) {


        Stack<Character> stk = new Stack<>();

        for(int i=0; i<s.length(); i++){
            if(stk.size() ==0 || stk.peek()!=s.charAt(i)){
                stk.push(s.charAt(i));
            }
        }

        StringBuilder str = new StringBuilder();

        while(stk.size()>0){
            str.append(stk.pop());
        }

        str.reverse();
        return str.toString();
    }

    public static void main(String[] args) {
        RemoveConsecutiveDuplicatesStack obj = new RemoveConsecutiveDuplicatesStack();
        System.out.println(obj.removeDuplicates("aabbcc"));        
        System.out.println(obj.removeDuplicates("aabaa"));        
        System.out.println(obj.removeDuplicates("geeksforgeeks"));     }
}
