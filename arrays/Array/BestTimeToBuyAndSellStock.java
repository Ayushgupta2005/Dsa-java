/*
 * Problem: Best Time to Buy and Sell Stock (LeetCode 121)
 *
 * Build a suffix-max array where greater[i] is the highest price from day i
 * onward, then the best profit for buying on day i is greater[i] - prices[i].
 * Take the max over all days. Fully increasing / decreasing inputs are
 * short-circuited first.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class BestTimeToBuyAndSellStock {

    public static boolean checkInc(int[] prices){
        for(int i=0; i<prices.length-1; i++){
            if(prices[i]>prices[i+1]){
                return false;
            }
        }
        return true;
    }
     public static boolean checkDec(int[] prices){
        for(int i=0; i<prices.length-1; i++){
            if(prices[i]<prices[i+1]){
                return false;
            }
        }
        return true;
    }


    public int maxProfit(int[] prices) {

        if(prices.length==1) return 0;
        boolean a = checkInc(prices);

        if(a==true){
            int val = prices[prices.length-1] - prices[0];
            return val;
        }

        boolean b = checkDec(prices);

        if(b==true){
    return 0;
        }

        int[] greater = new int[prices.length];

        greater[greater.length-1]= prices[prices.length-1];

        int max= prices[prices.length-1];

        for(int i=greater.length-2; i>=0; i--){
            max = Math.max(prices[i],max);
            greater[i]=max;
        }

        max = 0;

        for(int i=0; i<prices.length; i++){

            int d = greater[i]-prices[i];
            max = Math.max(max,d);

        }
        return max;



    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock obj = new BestTimeToBuyAndSellStock();
        System.out.println(obj.maxProfit(new int[]{7,1,5,3,6,4})); // Expected: 5
        System.out.println(obj.maxProfit(new int[]{7,6,4,3,1}));   // Expected: 0
        System.out.println(obj.maxProfit(new int[]{1,2,3,4,5}));   // Expected: 4
    }
}
