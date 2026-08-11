package DP;

/*
 * Problem: Count Square Submatrices with All Ones (LeetCode 1277)
 *
 * dp[i][j] = size of the largest all-ones square whose BOTTOM-RIGHT corner
 * is (i, j), which also equals the number of squares ending at that cell.
 * A cell can extend a square only as far as its weakest neighbour allows:
 * dp[i][j] = 1 + min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) when matrix[i][j]
 * is 1. Summing the whole dp table gives the total square count.
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */
public class CountSquareSubmatrices {
    public int countSquares(int[][] matrix) {

        int dp[][] = new int[matrix.length][matrix[0].length];

        for(int i=0; i<matrix.length; i++){
            dp[i][0] = matrix[i][0];
        }

        for(int i=0; i<matrix[0].length; i++){
            dp[0][i] = matrix[0][i];
        }

        for(int i=1; i<matrix.length; i++){
            for(int j=1; j<matrix[0].length; j++){
                if(matrix[i][j]==0) dp[i][j]=0;
                else if(dp[i-1][j]!=0 && dp[i][j-1]!=0 && dp[i-1][j-1]!=0){
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));
                }
                else{
                    dp[i][j]=matrix[i][j];
                }
            }
        }

        int count=0;
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                count = count + dp[i][j];
            }

        }
        return count;

    }

    public static void main(String[] args) {
        CountSquareSubmatrices obj = new CountSquareSubmatrices();

        int[][] matrix1 = {
            {0, 1, 1, 1},
            {1, 1, 1, 1},
            {0, 1, 1, 1}
        };
        System.out.println(obj.countSquares(matrix1)); // Expected: 15

        int[][] matrix2 = {
            {1, 0, 1},
            {1, 1, 0},
            {1, 1, 0}
        };
        System.out.println(obj.countSquares(matrix2)); // Expected: 7
    }
}
