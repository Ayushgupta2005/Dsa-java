package DP;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Problem: Russian Doll Envelopes (LeetCode 354)
 *
 * Same sort trick (width ascending, height descending on ties), but the LIS
 * over heights is done with patience sorting: keep a list where each entry
 * is the smallest possible tail for a subsequence of that length, extending
 * it when the element is bigger than every tail, else binary searching for
 * the first tail >= element and overwriting it. The list's size is the LIS
 * length (its contents are not a real subsequence).
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */
public class RussianDollEnvelopesBinarySearch {


    public static void replace(int ele, ArrayList<Integer> ans){
        int low= 0;
        int high = ans.size()-1;
        int lb=-1;
        while(low<=high){
            int mid = low +(high-low)/2;

            if(ans.get(mid)>=ele){
                lb = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        ans.set(lb,ele);
    }

    public static int lis(int[] nums){
        ArrayList<Integer> ans = new ArrayList<>();

        for(int ele: nums){
            if(ans.size()==0 || ele>ans.get(ans.size()-1)){
                ans.add(ele);
            }
            else{
                replace(ele,ans);
            }
        }
        return ans.size();

    }
    public int maxEnvelopes(int[][] envelopes) {


        // sort based on 1st index and if 1st index is same then based on second
        Arrays.sort(envelopes, (a,b)-> (a[0]!=b[0]) ? Integer.compare(a[0],b[0]) : Integer.compare(b[1],a[1]));

        int arr[]= new int[envelopes.length];
        for(int i=0; i<envelopes.length; i++){
            arr[i]=envelopes[i][1];
        }

        return lis(arr);
}

    public static void main(String[] args) {
        RussianDollEnvelopesBinarySearch obj = new RussianDollEnvelopesBinarySearch();

        System.out.println(obj.maxEnvelopes(new int[][]{{5,4},{6,4},{6,7},{2,3}})); // Expected: 3
        System.out.println(obj.maxEnvelopes(new int[][]{{1,1},{1,1},{1,1}}));       // Expected: 1
    }
}
