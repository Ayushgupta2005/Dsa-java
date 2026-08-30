package DP;

/*
 * Problem: Shortest Common Supersequence (LeetCode 1092)
 *
 * The shortest string containing both str1 and str2 as subsequences is
 * built by weaving them together around their LCS: every character NOT in
 * the LCS must appear (it can't be shared), while each LCS character is
 * written once and serves both strings. First compute the LCS (standard
 * DP + backtrack), then walk str1 and str2 together: dump non-matching
 * characters from each until the next LCS character is reached, write it
 * once, and repeat. Finally append whatever remains of either string.
 *
 * Time Complexity: O(n * m)
 * Space Complexity: O(n * m)
 */
public class ShortestCommonSupersequence {

    public String lcs(String text1, String text2) {

        int[][] dp = new int[text1.length()+1][text2.length()+1];

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

        String ans ="";

        int i=dp.length-1;
        int j= dp[0].length-1;

        while(i>0 && j>0){
            if(text1.charAt(i-1)==text2.charAt(j-1)){
                ans=ans+text1.charAt(i-1);
                i--;
                j--;

            }
            else{
                if(dp[i-1][j]==dp[i][j-1]){
                    j--;
                }
                else{
                    if(dp[i-1][j]>dp[i][j-1]){
                        i=i-1;
                    }
                    else{
                        j=j-1;
                    }
                }
            }

        }

        String anss ="";
        for(int k=ans.length()-1; k>=0; k--){
            anss = anss+ans.charAt(k);
        }

        return anss;

    }


    public String shortestCommonSupersequence(String str1, String str2) {

        String lcs =  lcs(str1,str2);

        int i=0;
        int j=0;
        int k=0;

        String ans="";

        while(i!=str1.length()&& j!=str2.length()&& k!=lcs.length()){
            char ch = lcs.charAt(k);

            while(str1.charAt(i)!=ch){
                ans= ans+str1.charAt(i);
                i++;
            }
            while(str2.charAt(j)!=ch){
                ans = ans+str2.charAt(j);
                j++;
            }

            ans = ans+ ch;
            k++;
            i++;
            j++;
        }

        for(int x=i; x<str1.length(); x++){
            ans = ans+ str1.charAt(x);
        }
        for(int y=j; y<str2.length(); y++){
            ans= ans+str2.charAt(y);

        }
        return ans;
    }

    public static void main(String[] args) {
        ShortestCommonSupersequence obj = new ShortestCommonSupersequence();
        String r1 = obj.shortestCommonSupersequence("abac", "cab");
        System.out.println(r1); // Expected length 5, e.g. "cabac"

        String r2 = obj.shortestCommonSupersequence("aaaaaaaa", "aaaaaaaa");
        System.out.println(r2); // Expected: aaaaaaaa
    }
}
