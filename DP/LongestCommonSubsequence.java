package DP;

/*
 * Problem: Longest Common Subsequence (LeetCode 1143) - memoization
 *
 * Compare the LAST characters of both strings:
 *  - if they match, they must be part of the LCS -> 1 + lcs(both shortened)
 *  - if not, drop the last char of one string or the other and take the max
 * State is (len1, len2), memoized in dp.
 *
 * Time Complexity: O(n * m) states
 * Space Complexity: O(n * m)
 */
public class LongestCommonSubsequence {

    static int dp[][];

    public static int lcs(String text1, String text2){
        if(text1.length()==0 || text2.length()==0) return 0;

        int l1=text1.length();
        int l2=text2.length();

        if(dp[l1][l2]!=-1) return dp[l1][l2];

        char c1= text1.charAt(l1-1);
        char c2 = text2.charAt(l2-1);

        if(c1==c2){

            return 1+ lcs(text1.substring(0,l1-1),text2.substring(0,l2-1));
        }

        int ans = Math.max(lcs(text1,text2.substring(0,l2-1)), lcs(text1.substring(0,l1-1),text2));
        dp[l1][l2]=ans;

        return ans;

    }
    public int longestCommonSubsequence(String text1, String text2) {

        dp = new int[text1.length()+1][text2.length()+1];

        for(int i=0;i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j]=-1;
            }
        }

        return lcs(text1,text2);


    }

    public static void main(String[] args) {
        LongestCommonSubsequence obj = new LongestCommonSubsequence();
        System.out.println(obj.longestCommonSubsequence("abcde", "ace")); // Expected: 3
        System.out.println(obj.longestCommonSubsequence("abc", "abc"));   // Expected: 3
        System.out.println(obj.longestCommonSubsequence("abc", "def"));   // Expected: 0
    }
}
