package arrays.Array;

import java.util.Arrays;

/*
 * Problem: Minimum Total Price After Applying Discounts (LeetCode 4014)
 *
 * Greedy: sort both arrays descending and pair them up, so the largest
 * discount lands on the largest price. A discount of d on price p saves
 * p*d/100, so bigger p paired with bigger d maximises total savings. Any
 * leftover prices (when discounts run out) are added at full value.
 *
 * Time Complexity: O(n log n + m log m)
 * Space Complexity: O(1) extra
 */
public class MinimumTotalPriceAfterDiscounts {

    public static void reverse(int[] arr){
        int i=0;
        int j=arr.length-1;

        while(i<j){
            int temp = arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }
    public double minPrice(int[] prices, int[] discounts) {

        Arrays.sort(prices);
        Arrays.sort(discounts);

        reverse(prices);
        reverse(discounts);

        int i=0;

        double ans =0.0;

        while(i<prices.length && i<discounts.length){
            int a=prices[i];
            int b= 100-discounts[i];

            double c =(double) a *(b/100.0);
            ans = ans+ c;
            i++;
        }

        while(i<prices.length){
            ans=ans+ (double) prices[i];
            i++;
        }

        return ans;

    }

    public static void main(String[] args) {
        MinimumTotalPriceAfterDiscounts obj = new MinimumTotalPriceAfterDiscounts();

        System.out.println(obj.minPrice(new int[]{10,30,21}, new int[]{50,60}));  // Expected: 32.5
        System.out.println(obj.minPrice(new int[]{100,70}, new int[]{10,40,50})); // Expected: 92.0
        System.out.println(obj.minPrice(new int[]{7,3,9}, new int[]{100,100}));   // Expected: 3.0
    }
}
