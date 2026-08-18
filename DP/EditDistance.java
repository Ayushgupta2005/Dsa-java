package DP;

/*
 * Problem: Edit Distance (LeetCode 72 - Hard) - memoization
 *
 * Compare the last characters of both words:
 *  - if they match, no operation is needed -> move both back
 *  - otherwise take 1 + the cheapest of the three edits:
 *      delete  from word1 -> (i-1, j)
 *      replace in word1   -> (i-1, j-1)
 *      insert  into word1 -> (i, j-1)
 * Base cases: if one string is exhausted, the answer is the length of what
 * remains of the other (all inserts or all deletes).
 *
 * Time Complexity: O(n * m)
 * Space Complexity: O(n * m)
 */
public class EditDistance {

    static int dp[][];

    public static int minDis(int i, int j, String word1, String word2){

        if(i<0 && j<0) return 0;

        if(i<0) return j+1;
        if(j<0) return i+1;

        if(dp[i][j]!=-1) return dp[i][j];
        char c1 = word1.charAt(i);
        char c2 = word2.charAt(j);

        if(c1==c2){
            int n = minDis(i-1,j-1,word1,word2);
            dp[i][j]=n;
            return n;
        }

        int x= 1+minDis(i-1,j,word1,word2);
        int y = 1+ minDis(i-1,j-1,word1,word2);
        int z = 1+minDis(i,j-1,word1,word2);

        int ans =  Math.min(x,Math.min(y,z));
        dp[i][j]=ans;
        return ans;

    }



    public int minDistance(String word1, String word2) {

        dp = new int[word1.length()][word2.length()];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j]=-1;
            }
        }

        return minDis(word1.length()-1, word2.length()-1, word1,word2);

    }

    public static void main(String[] args) {
        EditDistance obj = new EditDistance();
        System.out.println(obj.minDistance("horse", "ros"));         // Expected: 3
        System.out.println(obj.minDistance("intention", "execution"));// Expected: 5
        System.out.println(obj.minDistance("", "abc"));               // Expected: 3
        System.out.println(obj.minDistance("same", "same"));          // Expected: 0
    }
}
