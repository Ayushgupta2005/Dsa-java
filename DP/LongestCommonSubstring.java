package DP;

/*
 * Problem: Longest Common Substring (GeeksforGeeks)
 *
 * Unlike LCS, a substring must be contiguous, so dp[i][j] = length of the
 * common substring ENDING exactly at s1[i] and s2[j]. Characters match ->
 * extend the diagonal by 1; mismatch -> reset to 0 (the run is broken).
 * The answer is the maximum cell, not dp[n-1][m-1].
 *
 * Time Complexity: O(n*m)
 * Space Complexity: O(n*m)
 */
public class LongestCommonSubstring {

    public int longCommSubstr(String s1, String s2) {

        int dp[][]= new int[s1.length()][s2.length()];

        for(int i=0; i<dp.length; i++){
            if(s1.charAt(i)==s2.charAt(0)){
                dp[i][0]=1;
            }
            else{
                dp[i][0]=0;
            }
        }

        for(int i=0; i<dp[0].length; i++){

            if(s2.charAt(i)==s1.charAt(0)){
                dp[0][i]=1;
            }
            else{
                dp[0][i]=0;
            }
        }

        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                if(s1.charAt(i)==s2.charAt(j)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=0;
                }
            }
        }
        int max=0;

        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                max = Math.max(max,dp[i][j]);
            }
        }
        return max;

    }

    public static void main(String[] args) {
        LongestCommonSubstring obj = new LongestCommonSubstring();

        System.out.println(obj.longCommSubstr("ABCDGH","ACDGHR")); // Expected: 4  ("CDGH")
        System.out.println(obj.longCommSubstr("ABC","ACB"));       // Expected: 1
        System.out.println(obj.longCommSubstr("ABCDE","FGHIJ"));   // Expected: 0
    }
}
