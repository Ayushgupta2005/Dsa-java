// Counting Frequency of All Elements Using HashMap

package Hash_map;
import java.util.HashMap;

public class Frequency {

    public static HashMap<Integer, Integer> countFrequency(int[] arr){
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<arr.length ; i++){
            if (map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }
            else{
                map.put(arr[i], 1);
            }
        }
        return map;
        
    }

    public static void main(String[] args) {
        int arr[]= {1,2,2,3,3,3,4};

        HashMap<Integer, Integer> freqMap = countFrequency(arr);
        System.out.println(freqMap);
    }

    
}
