package DP;

/*
 * Problem: Unbounded Knapsack / Knapsack with Duplicates (GeeksforGeeks) - memoization
 *
 * Same pick/skip structure as 0/1 Knapsack, with ONE difference: after
 * picking item i we recurse on i (not i+1), so the same item can be chosen
 * any number of times. Skipping still moves to i+1.
 *
 * Time Complexity: O(n * W)
 * Space Complexity: O(n * W) + recursion stack
 */
public class UnboundedKnapsack {

     static int dp[][];
    public int knapsackk(int W, int val[], int wt[], int i){
         if(i>=val.length || W==0) return 0;


         if(dp[i][W]!=-1) return dp[i][W];
        if(W-wt[i]<0){
            int skip = knapsackk(W,val,wt,i+1);
            dp[i][W]=skip;
            return skip;
        }

        int pick = val[i]+knapsackk(W-wt[i],val,wt,i);
        int skip = knapsackk(W,val,wt,i+1);

        int ans= Math.max(pick,skip);
        dp[i][W]=ans;
        return ans;
    }
    public int knapSack(int val[], int wt[], int W) {

        dp = new int[val.length][W+1];

        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j]=-1;
            }
        }
        return knapsackk(W,val,wt,0);


    }

    public static void main(String[] args) {
        UnboundedKnapsack obj = new UnboundedKnapsack();

        // val = {1,1,1}, wt = {2,1,3}, W = 2  -> take item 1 twice
        System.out.println(obj.knapSack(new int[]{1, 1, 1}, new int[]{2, 1, 3}, 2)); // Expected: 2

        // val = {6,1,7,7}, wt = {1,3,4,5}, W = 8 -> take item 0 eight times
        System.out.println(obj.knapSack(new int[]{6, 1, 7, 7}, new int[]{1, 3, 4, 5}, 8)); // Expected: 48

        // 0/1 would give 220 here; unbounded takes item 0 five times = 300
        System.out.println(obj.knapSack(new int[]{60, 100, 120}, new int[]{10, 20, 30}, 50)); // Expected: 300
    }
}
