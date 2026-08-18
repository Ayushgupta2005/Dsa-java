package Hash_map;

import java.util.ArrayList;
import java.util.HashSet;

/*
 * Problem: Count Number of Distinct Integers After Reverse Operations (LeetCode 2442)
 *
 * Add every number and its digit-reverse to a HashSet; the set size is the
 * count of distinct values in the final array.
 *
 * Time Complexity: O(n * d)  d = digits per number
 * Space Complexity: O(n)
 */
public class CountDistinctIntegersAfterReverse {

    public int reverse(int n){

        int a=0;

        while(n>0){
            a=a*10+n%10;
            n=n/10;
        }
        return a;
    }

    public int countDistinctIntegers(int[] nums) {

        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
            int a = reverse(nums[i]);
            set.add(a);
        }
        return set.size();

    }

    public static void main(String[] args) {
        CountDistinctIntegersAfterReverse obj = new CountDistinctIntegersAfterReverse();
        System.out.println(obj.countDistinctIntegers(new int[]{1,13,10,12,31})); // Expected: 6
        System.out.println(obj.countDistinctIntegers(new int[]{2,2,2}));         // Expected: 1
    }
}
