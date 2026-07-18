package stacks;

import java.util.Stack;

public class Clear_Digit {
    public static String clearDigits(String s) {

        Stack<Character> stk= new Stack<>();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(!Character.isDigit(ch)){
                stk.push(ch);
            }
            else{
                if(stk.size()==0){
                    continue;
                }
                else{
                    stk.pop();

                }
            }
        }

    char arr[] = new char[stk.size()];

    for(int i=arr.length-1; i>=0; i--){
        arr[i]=stk.pop();
    }

    String ans = new String(arr);
    return ans;


        
    }

    public static void main(String[] args) {
        System.out.println(clearDigits("Ayush22"));
    }
}
    