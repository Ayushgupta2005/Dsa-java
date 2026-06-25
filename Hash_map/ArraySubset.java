package Hash_map;

import java.util.HashMap;

/*
 * Problem: Array Subset of another array (GeeksforGeeks)
 * Check whether array b is a subset of array a (counting multiplicity).
 * Time Complexity: O(n + m)
 * Space Complexity: O(n)
 */
public class ArraySubset {
    public boolean isSubset(int a[], int b[]) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<a.length; i++){
            if(!map.containsKey(a[i])){
                map.put(a[i],1);
            }
            else{
                map.put(a[i], map.get(a[i])+1);
            }
        }

        for(int i=0; i<b.length; i++){

            if(!map.containsKey(b[i]) || map.get(b[i])==0){
                return false;
            }
            else{
                map.put(b[i],map.get(b[i])-1);
            }
        }

        return true;

    }

    public static void main(String[] args) {
        ArraySubset obj = new ArraySubset();
        System.out.println(obj.isSubset(new int[]{11, 1, 13, 21, 3, 7}, new int[]{11, 3, 7, 1})); 
        System.out.println(obj.isSubset(new int[]{1, 2, 3, 4, 5, 6}, new int[]{1, 2, 4}));         
        System.out.println(obj.isSubset(new int[]{10, 5, 2, 23, 19}, new int[]{19, 5, 3}));        
    }
}
