package stacks;

import java.util.Stack;

public class NextGreaterElement2 {

    public static int search(int arr[], int i, int num){
        for(int k=0; k<i; k++){
            if(arr[k]>num){
                return arr[k];
            }

        }
        return -1;

    }
    public int[] nextGreaterElements(int[] arr) {

        Stack<Integer> stk = new Stack<>();

        int sol[] = new int[arr.length];
        sol[arr.length-1]=-1;
        
        if(arr.length==1){
            int sol2[] = new int[1];
            sol2[0]=-1;
            return sol2; 
        }
        
        stk.push(arr[arr.length-1]);
        
        for(int i=arr.length-2; i>=0; i--){
            int a = arr[i];
             
            while(stk.size()>0 && stk.peek()<=a){
                stk.pop();
            }
            
            if(stk.size()==0){
                stk.push(a);
                int b = search(arr,i,a);
                sol[i]=b;

            }
            else{
                sol[i]=stk.peek();
                stk.push(a);
            }
        }

        int c = search(arr, arr.length, arr[arr.length-1]);
        sol[arr.length-1]=c;
        return sol;
        
    }
}