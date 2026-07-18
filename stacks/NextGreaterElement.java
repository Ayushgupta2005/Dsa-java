package stacks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class NextGreaterElement {

    public ArrayList<Integer> nextLargerElement(int[] arr) {
        
        Stack<Integer> stk = new Stack<>();
        
        ArrayList<Integer> sol = new ArrayList<>();
        
        if(arr.length==1){
            sol.add(-1);
            return sol;
            
        }
        
        stk.push(arr[arr.length-1]);
        
        for(int i=arr.length-2; i>=0; i--){
            int a = arr[i];
             
            while(stk.size()>0 && stk.peek()<=a){
                stk.pop();
            }
            
            if(stk.size()==0){
                stk.push(a);
                sol.add(-1);
            }
            else{
                sol.add(stk.peek());
                stk.push(a);
            }
        }
          Collections.reverse(sol);
          sol.add(-1);
          return sol;
    }
    
}
