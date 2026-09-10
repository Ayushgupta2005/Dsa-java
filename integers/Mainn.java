package integers;

import java.util.*;

public class Mainn{

    static int ans=-1;

    static int check(ArrayList<Integer> list, int k){
        int sum =0;
        for(int i=0; i<list.size(); i++){
            sum = sum+list.get(i);
        }
        if(sum%k==0){
            return list.size();
        }
        else{
            return -1;
        }
    }

    public static void dp(ArrayList<Integer> list,int i, int[] arr, int k){

        if(i==arr.length){
            if(list.size()==0){
            return;}
            else{
                int a = check(list,k);
                ans = Math.max(a,ans);
            }

            }

        list.add(i);
        dp(list,i+1,arr,k);
        list.remove(list.size()-1);
        dp(list,i+1,arr,k);

    
    }

    public static void main(String[] args) {

        int arr[] = {1,2,3,4,5};
        int k=3;
        ArrayList<Integer> list = new ArrayList<>();

        dp(new ArrayList<>(),0,arr,k);

        System.out.println(ans);
    }
}


