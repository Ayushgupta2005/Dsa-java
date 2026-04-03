package Vector;

import java.util.Vector;

public class Addone {
    static Vector<Integer> addOne(int[] arr) {
        if(arr[arr.length-1]!=9){
            arr[arr.length-1]= arr[arr.length-1]+1;
            
            Vector<Integer> res = new Vector<>();
            for(int i=0; i<arr.length; i++){
                res.add(arr[i]);
        }
        return res;
        }
        
        int j=arr.length-1;
        while(j>=0){
            if(arr[j]==9){
                arr[j]=0;
                j--;
            }
            else{
                arr[j]=arr[j]+1;
                Vector<Integer> res = new Vector<>();
            for(int i=0; i<arr.length; i++){
                res.add(arr[i]);
        }
        return res;
            }
            
        }
        Vector<Integer> res = new Vector<>();
        res.add(1);
        for(int i=1; i<=arr.length; i++){
            res.add(0);
        }
        return res;
        
         
    }
    public static void main(String[] args) {
        int[] arr ={9,9,9};
        int[] arr2 ={5,6,7,8};
        Vector<Integer> res = addOne(arr);
        Vector<Integer> res2 = addOne(arr2);

        for(int i=0; i<res.size(); i++){
            System.out.print(res.get(i)+" ");
        }
        System.out.println();
        for(int i=0; i<res2.size(); i++){
            System.out.print(res2.get(i)+" ");
        }


    }
}
