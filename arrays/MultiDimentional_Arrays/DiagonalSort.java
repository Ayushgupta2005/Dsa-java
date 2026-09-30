package arrays.MultiDimentional_Arrays;

import java.util.*;

public class DiagonalSort {

    public static int[][] diagonalSort(int[][] mat) {

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

        // Sort every diagonal
        for (int k = 0; k < ans.size(); k++) {
            Collections.sort(ans.get(k));
        }

        // Put sorted diagonals back
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
            {3, 3, 1, 1},
            {2, 2, 1, 2},
            {1, 1, 1, 2}
        };

        int[][] result = diagonalSort(mat);

        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}