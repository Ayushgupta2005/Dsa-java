package MultiDimentional_Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
 * Problem: The K Weakest Rows in a Matrix (LeetCode 1337) - without PriorityQueue
 *
 * Count the soldiers (1s) in each row. Group row indices by their soldier
 * count in a HashMap<count, list of row indices> (insertion order within
 * each bucket naturally keeps ties in original row order). Sort the counts,
 * then walk them in order pulling one row index at a time from the front
 * of its bucket - this produces the k weakest rows, ties broken by index.
 *
 * Time Complexity: O(rows * cols + rows log rows)
 * Space Complexity: O(rows)
 */
public class KWeakestRows {

    // without peiorityQueue
    public int[] kWeakestRows(int[][] mat, int k) {

        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<mat.length; i++){
            int count=0;

            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j]==1) count++;
            }
            list.add(count);
        }

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0; i<list.size(); i++){
           if(!map.containsKey(list.get(i))){
            map.put(list.get(i),new ArrayList<>());
           }
           map.get(list.get(i)).add(i);
        }

        ArrayList<Integer> idx = new ArrayList<>();
        Collections.sort(list);

        for(int i=0; i<list.size(); i++){
            idx.add(map.get(list.get(i)).get(0));
            map.get(list.get(i)).remove(0);
        }

        int arr[] = new int[k];
        for(int i=0; i<arr.length; i++){
            arr[i]=idx.get(i);
        }
        return arr;

    }


    public static void main(String[] args) {
        KWeakestRows obj = new KWeakestRows();

        int[][] mat1 = {
            {1,1,0,0,0},
            {1,1,1,1,0},
            {1,0,0,0,0},
            {1,1,0,0,0},
            {1,1,1,1,1}
        };
        System.out.println(java.util.Arrays.toString(obj.kWeakestRows(mat1, 3))); // Expected: [2, 0, 3]

        int[][] mat2 = {
            {1,0,0,0},
            {1,1,1,1},
            {1,0,0,0},
            {1,0,0,0}
        };
        System.out.println(java.util.Arrays.toString(obj.kWeakestRows(mat2, 2))); // Expected: [0, 2]
    }
}
