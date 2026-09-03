package stacks;

import java.util.Stack;

/*
 * Problem: Evaluate Reverse Polish Notation (LeetCode 150)
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class EvaluateReversePolishNotation {

    public static int convert(String s){
        int num =0;
        boolean neg=false;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='-'){
             neg = true;
            }
            else{
            int a = s.charAt(i)-'0';
            num = num*10+a;
            }
        }
        if(neg==true){
            num = num*-1;
        }
        return num;
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        for(int i=0; i<tokens.length; i++){
            String ss = tokens[i];
            if(ss.equals("+")){
                int a=stk.pop();
                int b=stk.pop();
                stk.push(a+b);
            }
            else if(ss.equals("-")){
                int a=stk.pop();
                int b=stk.pop();
                stk.push(b-a);
            }
            else if(ss.equals("*")){
                int a=stk.pop();
                int b=stk.pop();
                stk.push(a*b);
            }
            else if(ss.equals("/")){
                int a=stk.pop();
                int b=stk.pop();
                stk.push(b/a);
            }
            else{
                stk.push(convert(tokens[i]));
            }
        }
        return stk.pop();
    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"2","1","+","3","*"})); // Expected: 9
        System.out.println(evalRPN(new String[]{"4","13","5","/","+"})); // Expected: 6
        System.out.println(evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"})); // Expected: 22
    }
}
