package Hash_map;

import java.util.HashMap;

/*
 * Problem: K-diff Pairs in an Array (LeetCode 532)
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class KdiffPairs {
    public int findPairs(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }
            else{
                map.put(nums[i],map.get(nums[i])+1);
            }
        }
        int count =0;

        if(k==0){
            for(Integer key: map.keySet()){
                int a = key+k;
                if(map.containsKey(a) && map.get(a)>1){
                    count = count +1;
                    map.put(a,map.get(a)-1);
                }
            }

        }
        else{
            for(Integer key: map.keySet()){
                int a = key+k;
                if(map.containsKey(a)){
                    count = count +1;
                }
            }
        }

        return count;

    }

    public static void main(String[] args) {
        KdiffPairs obj = new KdiffPairs();
        System.out.println(obj.findPairs(new int[]{3, 1, 4, 1, 5}, 2)); // Expected: 2
        System.out.println(obj.findPairs(new int[]{1, 2, 3, 4, 5}, 1)); // Expected: 4
        System.out.println(obj.findPairs(new int[]{1, 3, 1, 5, 4}, 0)); // Expected: 1
    }
}
