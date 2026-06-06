package MultiDimentional_Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

 /*
    LeetCode 56 - Merge Intervals

    Time Complexity: O(n log n)
    Space Complexity: O(n)

    Approach:
    1. Sort the intervals based on their start time.
    2. Maintain a current interval.
    3. If the next interval overlaps with the current interval,
       merge them by updating the end value.
    4. Otherwise, add the current interval to the result and
       start a new current interval.
    5. Add the final interval to the result.
    */

public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();

        int[] current = intervals[0];

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] <= current[1]) {
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                result.add(current);
                current = intervals[i];
            }
        }

        result.add(current);

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {

        int[][] intervals = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };

        int[][] result = merge(intervals);

        System.out.println("Merged Intervals:");

        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
    
