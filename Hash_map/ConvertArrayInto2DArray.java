package Hash_map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * Problem: Convert an Array Into a 2D Array With Conditions (LeetCode 2610)
 *
 * Each row must have distinct elements, and rows are built to be as few as
 * possible. Count how many times each value appears; a value that appears
 * c times must occupy c different rows. So the number of rows needed is
 * the highest frequency in the array. Build that many rows, and on each
 * pass add every value that still has copies left, decrementing its count.
 *
 * Time Complexity: O(n * d)  d = number of distinct values
 * Space Complexity: O(n)
 */
public class ConvertArrayInto2DArray {
    public List<List<Integer>> findMatrix(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }
            else{
                map.put(nums[i],map.get(nums[i])+1);
            }
        }

        int max=0;
        for(Integer key: map.keySet()){
            if(map.get(key)>max){
                max=map.get(key);
            }
        }

        ArrayList<List<Integer>> ans = new ArrayList<>();



        for(int i=0; i<max; i++){
            ArrayList<Integer> list = new ArrayList<>();
            for(Integer key: map.keySet()){
                if(map.get(key)>0){
                    list.add(key);
                    map.put(key,map.get(key)-1);
                }
            }

            if(list.size()>0){
                ans.add(list);
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        ConvertArrayInto2DArray obj = new ConvertArrayInto2DArray();
        System.out.println(obj.findMatrix(new int[]{1,3,4,1,2,3,1}));
        // Expected structure: one row of the 4 distinct values, one row with {1,3}, one row with {1}
        System.out.println(obj.findMatrix(new int[]{1,2,3,4}));
        // Expected: [[1, 2, 3, 4]]
    }
}
