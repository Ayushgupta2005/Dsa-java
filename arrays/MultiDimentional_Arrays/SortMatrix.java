package arrays.MultiDimentional_Arrays;

import java.util.*;

public class SortMatrix {

    public static int[][] sortMatrix(int[][] mat) {

        ArrayList<List<Integer>> ans = new ArrayList<>();

        int row = mat.length;
        int col = mat[0].length;

        int i = mat.length - 1;
        int j = 0;

        boolean check = true;

        // Store all diagonals
        for (int k = 0; k < row + col - 1; k++) {

            ArrayList<Integer> list = new ArrayList<>();

            if (i == 0 && j == 0)
                check = false;

            if (check == true) {

                int a = i;
                int b = j;

                while (a < mat.length && b < mat[0].length) {
                    list.add(mat[a][b]);
                    a++;
                    b++;
                }

                ans.add(new ArrayList<>(list));

                i--;
            }

            else {

                int a = i;
                int b = j;

                while (a < mat.length && b < mat[0].length) {
                    list.add(mat[a][b]);
                    a++;
                    b++;
                }

                ans.add(new ArrayList<>(list));

                j++;
            }
        }

        // Sort diagonals
        int nn = ans.size();
        nn = nn / 2 + 1;

        for (int k = 0; k < ans.size(); k++) {

            if (nn > 0) {
                Collections.sort(ans.get(k));
                Collections.reverse(ans.get(k));
                nn--;
            }

            else {
                Collections.sort(ans.get(k));
            }
        }

        // Put diagonals back
        i = mat.length - 1;
        j = 0;
        check = true;

        for (int k = 0; k < row + col - 1; k++) {

            if (i == 0 && j == 0)
                check = false;

            if (check == true) {

                int a = i;
                int b = j;
                int idx = 0;

                while (a < mat.length && b < mat[0].length) {

                    mat[a][b] = ans.get(k).get(idx);

                    idx++;
                    a++;
                    b++;
                }

                i--;
            }

            else {

                int a = i;
                int b = j;
                int idx = 0;

                while (a < mat.length && b < mat[0].length) {

                    mat[a][b] = ans.get(k).get(idx);

                    idx++;
                    a++;
                    b++;
                }

                j++;
            }
        }

        return mat;
    }

    public static void main(String[] args) {

        int[][] mat = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[][] result = sortMatrix(mat);

        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}