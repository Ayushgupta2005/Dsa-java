package DP;

public class DistinctSubsequencesII {

    static long MOD = 1000000007L;

    public static long solve(String s, int i) {

        // Empty string
        if (i == 0) {
            return 1;
        }

        // Pick / not pick current character
        long ans = (2 * solve(s, i - 1)) % MOD;

        char ch = s.charAt(i - 1);

        // Find previous occurrence of current character
        int j = i - 2;

        while (j >= 0) {

            if (s.charAt(j) == ch) {

                // Remove duplicate subsequences
                ans = (ans - solve(s, j) + MOD) % MOD;

                break;
            }

            j--;
        }

        return ans;
    }

    public static void main(String[] args) {

        String s = "aba";

        long ans = solve(s, s.length());

        // -1 to remove the empty subsequence
        ans = (ans - 1 + MOD) % MOD;

        System.out.println(ans);
    }
}