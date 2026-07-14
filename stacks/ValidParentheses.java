package stacks;

import java.util.Stack;

/*
 * Problem: Valid Parentheses (LeetCode 20)
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class ValidParentheses {
    public boolean isValid(String s) {

        Stack<Character> stk = new Stack<>();

        for(int i=0; i<s.length(); i++){

            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
                stk.push(s.charAt(i));
            }
            else if(s.charAt(i)==')' && stk.peek()!='('){
                return false;
            }
            else if(s.charAt(i)=='}' && stk.peek()!='{'){
                return false;
            }
            else if(s.charAt(i)==']' && stk.peek()!='['){
                return false;
            }
            else{
                stk.pop();
            }
        }

        if(stk.size()>0){
            return false;
        }
        return true;

    }

    public static void main(String[] args) {
        ValidParentheses obj = new ValidParentheses();
        System.out.println(obj.isValid("()"));    
        System.out.println(obj.isValid("()[]{}")); 
        System.out.println(obj.isValid("(]"));     
        System.out.println(obj.isValid("([])"));   
    }
}
