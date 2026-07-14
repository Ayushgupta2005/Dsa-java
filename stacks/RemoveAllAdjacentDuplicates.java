package stacks;

import java.util.Stack;

/*
 * Problem: Remove All Adjacent Duplicates In String (LeetCode 1047)
 *
 * Push each char; if it equals the stack top, pop instead - removing a pair
 * can make new neighbours adjacent, and the stack top is always the most
 * recent survivor, so cascading removals happen naturally. Pop everything
 * out and reverse to rebuild the answer.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class RemoveAllAdjacentDuplicates {
    public String removeDuplicates(String s) {

        if(s.length()==1){
            return s;
        }

        Stack<Character> stk = new Stack<>();

        for(int i=0; i<s.length(); i++){
            if(stk.size()==0){
                stk.push(s.charAt(i));
            }

            else if(stk.peek()==s.charAt(i)){
                stk.pop();
            }
            else{
                stk.push(s.charAt(i));
            }
        }

        StringBuilder str = new StringBuilder();

        while(stk.size()>0){
            str.append(stk.pop());
        }

        str.reverse();

        String ans = str.toString();
        return ans;

        }

    public static void main(String[] args) {
        RemoveAllAdjacentDuplicates obj = new RemoveAllAdjacentDuplicates();
        System.out.println(obj.removeDuplicates("abbaca")); // Expected: ca
        System.out.println(obj.removeDuplicates("azxxzy")); // Expected: ay
    }
}
