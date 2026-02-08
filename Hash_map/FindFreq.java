package Hash_map;

import java.util.HashMap;

public class FindFreq {

    public static int findFreq(int arr[], int n){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i=0; i<arr.length; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i]+1));
            }
            else{
                map.put(arr[i], 1);
            }

        }

        if (map.containsKey(n)){
            return map.get(n);
        }
        else{
            return 0;
        }


    }

    public static void main(String[] args) {
        
        int arr[] = {1,2,2,4,5,6,3,4,5};
        int n=2;

        int ans = findFreq(arr, n);
        System.out.println(ans);
    }
    
}
