package DP;

/*
 * Problem: Maximum Path Score in a Grid (LeetCode 3742)
 *
 * Moving only right/down, each cell adds grid[i][j] to the score and costs 1
 * if it is non-zero. The remaining budget is part of the state, so the memo
 * is 3D: dp[i][j][cost]. Integer.MIN_VALUE marks "no valid path from here",
 * and it propagates up so a dead end never contributes a score.
 *
 * Time Complexity: O(m*n*k)
 * Space Complexity: O(m*n*k)
 */
public class MaximumPathScoreInGrid {

    static int dp[][][];

    public static int dp(int[][] grid, int k, int i, int j, int cost){

        if(i>=grid.length || j>=grid[0].length) return Integer.MIN_VALUE;


        if(grid[i][j]!=0){
            cost=cost+1;
        }


        if(cost>k) {
             return Integer.MIN_VALUE;
        }
        if(dp[i][j][cost]!=-1) return dp[i][j][cost];

        if(i==grid.length-1 && j==grid[0].length-1){
            dp[i][j][cost]= grid[i][j];
            return dp[i][j][cost];
        }

        int c= Math.max(dp(grid,k,i+1,j,cost),dp(grid,k,i,j+1,cost));
        if(c==Integer.MIN_VALUE){
            dp[i][j][cost]= c;
            return dp[i][j][cost];
        }

        int a = grid[i][j] + c;
        dp[i][j][cost]= a;
        return dp[i][j][cost];
    }
    public int maxPathScore(int[][] grid, int k) {
        dp = new int[grid.length][grid[0].length][k+1];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                for(int c = 0; c <= k; c++){
                dp[i][j][c]=-1;
            }
        }
        }

        int ans= dp(grid,k,0,0,0);
        if(ans==Integer.MIN_VALUE) return -1;
        return ans;
    }

    public static void main(String[] args) {
        MaximumPathScoreInGrid obj = new MaximumPathScoreInGrid();

        System.out.println(obj.maxPathScore(new int[][]{{0,1},{2,0}}, 1)); // Expected: 2
        System.out.println(obj.maxPathScore(new int[][]{{0,1},{1,2}}, 1)); // Expected: -1
    }
}
