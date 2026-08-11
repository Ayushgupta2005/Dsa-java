package DP;

/*
 * Problem: 0/1 Knapsack (GeeksforGeeks) - memoization
 *
 * At each item i you either PICK it (gain val[i], capacity drops by wt[i])
 * or SKIP it - take the max. Item i can only be picked if it fits.
 * State (i, W) is cached in dp so each item/capacity pair is solved once.
 *
 * Time Complexity: O(n * W)
 * Space Complexity: O(n * W) + O(n) recursion stack
 */
public class Knapsack01 {

    static int dp[][];
    public int knapsackk(int W, int val[], int wt[], int i){
         if(i>=val.length || W==0) return 0;


         if(dp[i][W]!=-1) return dp[i][W];
        if(W-wt[i]<0){
            int skip = knapsackk(W,val,wt,i+1);
            dp[i][W]=skip;
            return skip;
        }

        int pick = val[i]+knapsackk(W-wt[i],val,wt,i+1);
        int skip = knapsackk(W,val,wt,i+1);

        int ans= Math.max(pick,skip);
        dp[i][W]=ans;
        return ans;
    }
    public int knapsack(int W, int val[], int wt[]) {

        dp = new int[val.length][W+1];

        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j]=-1;
            }
        }
        return knapsackk(W,val,wt,0);

    }

    public static void main(String[] args) {
        Knapsack01 obj = new Knapsack01();

        System.out.println(obj.knapsack(4, new int[]{1, 2, 3}, new int[]{4, 5, 1})); // Expected: 3
        System.out.println(obj.knapsack(3, new int[]{1, 2, 3}, new int[]{4, 5, 6})); // Expected: 0
        System.out.println(obj.knapsack(50, new int[]{60, 100, 120}, new int[]{10, 20, 30})); // Expected: 220
    }
}
