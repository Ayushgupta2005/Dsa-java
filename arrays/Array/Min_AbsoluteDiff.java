import java.util.*;

public class Min_AbsoluteDiff {

    public static List<List<Integer>> minimumAbsDifference(int[] arr) {

        ArrayList<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);

        int diff = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - 1; i++) {
            int cur = arr[i + 1] - arr[i];
            diff = Math.min(diff, cur);
        }

        for (int i = 0; i < arr.length - 1; i++) {
            int cur = arr[i + 1] - arr[i];

            if (cur == diff) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(arr[i]);
                list.add(arr[i + 1]);
                ans.add(list);
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] arr = {4, 2, 1, 3};

        List<List<Integer>> ans = minimumAbsDifference(arr);

        System.out.println(ans);
    }
}