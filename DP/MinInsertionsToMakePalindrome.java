package DP;

/*
 * Problem: Minimum Insertion Steps to Make a String Palindrome (LeetCode 1312 - Hard)
 *
 * The characters already part of the longest palindromic subsequence can
 * stay put; every other character needs a matching insertion. So the answer
 * is n - LPS(s), and LPS(s) = LCS(s, reverse(s)).
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n^2)
 */
public class MinInsertionsToMakePalindrome {
    static int dp[][];


    public static int lcs(int a, int b, String text1, String text2){

        if(a<0 || b<0) return 0;

        if(dp[a][b]!=-1) return dp[a][b];

        if(text1.charAt(a)==text2.charAt(b)){
            int aa = 1+lcs(a-1,b-1,text1,text2);
            dp[a][b]=aa;
            return aa;
        }

        int x= lcs(a-1,b,text1,text2);
        int y = lcs(a,b-1,text1,text2);
        int ans = Math.max(x,y);
        dp[a][b]=ans;
        return ans;
    }

    public int minInsertions(String s) {
        dp = new int[s.length()][s.length()];

        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j]=-1;
            }
        }

        String rev ="";
        for(int i=s.length()-1; i>=0; i--){
            rev = rev+s.charAt(i);
        }

        int ans= lcs(s.length()-1, rev.length()-1,s,rev);

        return s.length()-ans;

    }

    public static void main(String[] args) {
        MinInsertionsToMakePalindrome obj = new MinInsertionsToMakePalindrome();
        System.out.println(obj.minInsertions("zzazz"));     // Expected: 0
        System.out.println(obj.minInsertions("mbadm"));     // Expected: 2
        System.out.println(obj.minInsertions("leetcode"));  // Expected: 5
    }
}
