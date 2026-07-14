package stacks;

import java.util.Stack;

/*
 * Problem: Baseball Game (LeetCode 682)
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class BaseballGame {


    public int calPoints(String[] operations) {

        Stack<String> stk = new Stack<>();

        for(int i=0; i<operations.length; i++){
            String str = operations[i];

            if(str.equals("C")){
                stk.pop();
            }
            else if(str.equals("D")){
                int a = Integer.parseInt(stk.peek());
                a = a*2;
                stk.push(Integer.toString(a));
            }
            else if(str.equals("+")){
                String a = stk.pop();
                String b = stk.pop();

                int c = Integer.parseInt(a);
                int d = Integer.parseInt(b);
                int e = c+d;

                stk.push(b);
                stk.push(a);
                stk.push(Integer.toString(e));
            }
            else{
                stk.push(str);
            }

        }

        int sum=0;

        while(stk.size()>0){
            int a = Integer.parseInt(stk.pop());
            sum = sum+a;
        }
        return sum;

    }

    public static void main(String[] args) {
        BaseballGame obj = new BaseballGame();
        System.out.println(obj.calPoints(new String[]{"5","2","C","D","+"}));      
        System.out.println(obj.calPoints(new String[]{"5","-2","4","C","D","9","+","+"})); 
        System.out.println(obj.calPoints(new String[]{"1","C"}));                   
    }
}
