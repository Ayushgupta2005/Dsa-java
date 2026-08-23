package DP;

/*
 * Problem: Longest Common Subsequence (LeetCode 1143) - tabulation
 *
 * dp[i][j] = LCS length of the first i chars of text1 and first j of text2.
 * Row 0 and column 0 are 0 (empty string). If the current characters match,
 * extend the diagonal; otherwise take the better of dropping one character
 * from either string. Bottom-up, so no recursion stack.
 *
 * Time Complexity: O(n * m)
 * Space Complexity: O(n * m)
 */
public class LongestCommonSubsequenceTabulation {
    public int longestCommonSubsequence(String text1, String text2) {

        int dp[][] = new int[text1.length()+1][text2.length()+1];

        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
            }
        }

        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){

                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[text1.length()][text2.length()];

    }

    public static void main(String[] args) {
        LongestCommonSubsequenceTabulation obj = new LongestCommonSubsequenceTabulation();
        System.out.println(obj.longestCommonSubsequence("abcde", "ace")); // Expected: 3
        System.out.println(obj.longestCommonSubsequence("abc", "abc"));   // Expected: 3
        System.out.println(obj.longestCommonSubsequence("abc", "def"));   // Expected: 0
        System.out.println(obj.longestCommonSubsequence("", "abc"));      // Expected: 0
    }
}
