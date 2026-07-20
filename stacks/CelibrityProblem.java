package stacks;
import java.util.*;

public class CelibrityProblem {

    public static int celebrity(int mat[][]) {

        if (mat.length == 1) {
            return 0;
        }

        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < mat.length; i++) {
            stk.push(i);
        }

        while (stk.size() > 0) {

            if (stk.size() == 1) {
                int c = stk.pop();

                for (int i = 0; i < mat.length; i++) {
                    if (i == c) {
                        continue;
                    } else {
                        if (mat[c][i] == 1 || mat[i][c] == 0) {
                            return -1;
                        }
                    }
                }

                return c;
            }

            int a = stk.pop();
            int b = stk.pop();

            if (mat[a][b] == 1) {
                if (mat[b][a] == 1) {
                    continue;
                } else {
                    stk.push(b);
                }
            } else {
                if (mat[b][a] == 1) {
                    stk.push(a);
                } else {
                    continue;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[][] mat = {
            {0, 1, 1, 1},
            {0, 0, 0, 0},
            {0, 1, 0, 1},
            {0, 1, 0, 0}
        };

        int ans = celebrity(mat);

        if (ans == -1) {
            System.out.println("No Celebrity Found");
        } else {
            System.out.println("Celebrity is Person " + ans);
        }
    }
}
    
