package stacks;

import java.util.Stack;

// solves LL Daily temperature

public class DailyTemperature {
    class Solution {
    public int[] dailyTemperatures(int[] arr) {

        if(arr.length==1){
            int arr2[]={1};
            return arr2;
        }

        int[] sol = new int[arr.length];
        Stack<Integer> stk = new Stack<>();

        sol[arr.length-1]=0;
        stk.push(arr.length-1);

        for(int i=arr.length-2; i>=0; i--){

            while(stk.size()>0 && arr[stk.peek()]<=arr[i]){
                stk.pop();
            }

            if(stk.size()==0){
                sol[i]=0;
            }
            else{
                sol[i] = stk.peek()-i;
            }

            stk.push(i);
            
        }
        return sol;
        
    }
}
    
}
