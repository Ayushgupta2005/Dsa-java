package MultiDimentional_Arrays;
/*
LeetCode: 289 - Game of Life

Approach:
Simulation using an auxiliary matrix

Time Complexity: O(m × n)
Space Complexity: O(m × n)
*/
import java.util.Arrays;

public class GameOfLife {

    public static void gameOfLife(int[][] board) {

        int m = board.length;
        int n = board[0].length;

        int[][] next = new int[m][n];

        for(int i = 0; i < m; i++) {

            for(int j = 0; j < n; j++) {

                int count = 0;

                if(i - 1 >= 0 && j - 1 >= 0 && board[i - 1][j - 1] == 1) count++;
                if(i - 1 >= 0 && board[i - 1][j] == 1) count++;
                if(i - 1 >= 0 && j + 1 < n && board[i - 1][j + 1] == 1) count++;

                if(j - 1 >= 0 && board[i][j - 1] == 1) count++;
                if(j + 1 < n && board[i][j + 1] == 1) count++;

                if(i + 1 < m && j - 1 >= 0 && board[i + 1][j - 1] == 1) count++;
                if(i + 1 < m && board[i + 1][j] == 1) count++;
                if(i + 1 < m && j + 1 < n && board[i + 1][j + 1] == 1) count++;

                if(board[i][j] == 1 && count >= 2 && count <= 3) {
                    next[i][j] = 1;
                }
                else if(board[i][j] == 0 && count == 3) {
                    next[i][j] = 1;
                }
                else {
                    next[i][j] = 0;
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = next[i][j];
            }
        }
    }

    public static void main(String[] args) {

        int[][] board = {
                {0,1,0},
                {0,0,1},
                {1,1,1},
                {0,0,0}
        };

        gameOfLife(board);

        for(int[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }
}
