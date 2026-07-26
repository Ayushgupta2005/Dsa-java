package stacks;

import java.util.ArrayList;
import java.util.Stack;

// GFG practice solved

public class PreviousGreaterElement {

    class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        
        if(arr.length==1){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(1);
            return list;
        }
        
        ArrayList<Integer> sol = new ArrayList<>();
        
        Stack<Integer> stk = new Stack<>();
        sol.add(1);
        stk.push(0);
        
        for(int i=1; i<arr.length; i++){
            
            while(stk.size()>0 && arr[stk.peek()]<=arr[i]){
                stk.pop();
            }
            
            if(stk.size()==0){
                sol.add(i+1);
            }
            else{
                sol.add(i-stk.peek());
            }
            
            stk.push(i);
        }
        
        return sol;
        
    }
}
    
}
