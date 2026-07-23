package stacks;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Problem: Next Greater Element I (LeetCode 496) - brute force
 *
 * For each value in nums1: locate it in nums2, then scan right until the
 * first strictly greater element (-1 if the end is reached or the value
 * sits at the last index).
 *
 * Time Complexity: O(n1 * n2)
 * Space Complexity: O(n1) for the output
 */
public class NextGreaterElementBruteForce {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        ArrayList<Integer> ans = new ArrayList<>();

        int i=0;

        while(i<nums1.length){

            int a = nums1[i];

            int j=0;

            while(j<nums2.length && nums2[j]!=a){
                j++;
            }

            if(j==nums2.length|| j==nums2.length-1){
                ans.add(-1);
                i++;
                continue;
            }

            j++;
            while(j<nums2.length && nums2[j]<a){
                j++;
            }

            if(j==nums2.length){
                ans.add(-1);
                i++;
                continue;
            }
            ans.add(nums2[j]);
            i++;
        }
        int[] ans2 = new int[ans.size()];

        for(int k=0; k<ans.size(); k++){
            ans2[k] = ans.get(k);
        }

        return ans2;
    }

    public static void main(String[] args) {
        NextGreaterElementBruteForce obj = new NextGreaterElementBruteForce();
        System.out.println(Arrays.toString(obj.nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2}))); // Expected: [-1, 3, -1]
        System.out.println(Arrays.toString(obj.nextGreaterElement(new int[]{2,4}, new int[]{1,2,3,4})));   // Expected: [3, -1]
    }
}
