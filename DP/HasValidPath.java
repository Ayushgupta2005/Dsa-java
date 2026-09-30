package DP;

public class HasValidPath {

    public static boolean hasValidPath(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int pathLen = n + m - 1;

        // Path length must be even
        if (pathLen % 2 == 1) {
            return false;
        }

        // Start must be '(' and end must be ')'
        if (grid[0][0] != '(' || grid[n - 1][m - 1] != ')') {
            return false;
        }

        // dp[i][j][balance]
        boolean[][][] dp = new boolean[n][m][pathLen + 1];

        // Starting cell
        dp[0][0][1] = true;

        for (int i = 0; i < n; ++i) {

            for (int j = 0; j < m; ++j) {

                int change = grid[i][j] == '(' ? 1 : -1;

                // Coming from above
                if (i > 0) {

                    for (int balance = 0; balance <= pathLen; ++balance) {

                        if (!dp[i - 1][j][balance]) {
                            continue;
                        }

                        int next = balance + change;

                        if (next >= 0) {
                            dp[i][j][next] = true;
                        }
                    }
                }

                // Coming from left
                if (j > 0) {

                    for (int balance = 0; balance <= pathLen; ++balance) {

                        if (!dp[i][j - 1][balance]) {
                            continue;
                        }

                        int next = balance + change;

                        if (next >= 0) {
                            dp[i][j][next] = true;
                        }
                    }
                }
            }
        }

        return dp[n - 1][m - 1][0];
    }

    public static void main(String[] args) {

        char[][] grid = {
            {'(', '(', '('},
            {'(', '(', ')'},
            {'(', ')', ')'}
        };

        boolean result = hasValidPath(grid);

        System.out.println("Has Valid Path: " + result);
    }
}
