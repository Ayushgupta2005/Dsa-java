package DP;

/*
 * Problem: Longest Palindromic Subsequence (LeetCode 516) - LCS with the reverse
 *
 * A palindromic subsequence of s reads the same forwards and backwards, so
 * it is exactly a common subsequence of s and reverse(s). Reverse the string
 * and run the standard LCS memoization on indices (a, b).
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n^2)
 */
public class LongestPalindromicSubsequence {
    static int dp[][];

     public static int lcs(int a, int b, String text1, String text2){

        if(a==-1|| b==-1) return 0;

        if(dp[a][b]!=-1) return dp[a][b];
        if(text1.charAt(a)==text2.charAt(b)){
            int aa = 1+ lcs(a-1, b-1, text1, text2);
            dp[a][b]=aa;
            return aa;
        }

        int c = lcs(a-1,b,text1,text2);
        int d = lcs(a,b-1,text1,text2);
        int ans = Math.max(c,d);
        dp[a][b]=ans;
        return ans;
    }

    public int longestPalindromeSubseq(String s) {

        String rev = "";

        for(int i=s.length()-1; i>=0; i--){
            rev = rev+s.charAt(i);
        }

        dp = new int[s.length()][rev.length()];

        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j]=-1;
            }
        }

        return lcs(s.length()-1, rev.length()-1, s,rev);



    }

    public static void main(String[] args) {
        LongestPalindromicSubsequence obj = new LongestPalindromicSubsequence();
        System.out.println(obj.longestPalindromeSubseq("bbbab")); // Expected: 4 (bbbb)
        System.out.println(obj.longestPalindromeSubseq("cbbd"));  // Expected: 2 (bb)
        System.out.println(obj.longestPalindromeSubseq("a"));     // Expected: 1
    }
}
