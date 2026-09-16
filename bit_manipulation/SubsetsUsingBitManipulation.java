package bit_manipulation;

import java.util.ArrayList;
import java.util.List;

public class SubsetsUsingBitManipulation {

    public static boolean check(int n, int k) {

        n = n >> k;

        if (n % 2 != 0) {
            return true;
        }

        return false;
    }

    public static List<List<Integer>> subsets(int[] nums) {

        ArrayList<List<Integer>> ans = new ArrayList<>();

        int a = (int) Math.pow(2, nums.length);

        for (int i = 0; i < a; i++) {

            ArrayList<Integer> list = new ArrayList<>();

            for (int j = 0; j < nums.length; j++) {

                boolean checkk = check(i, j);

                if (checkk) {
                    list.add(nums[j]);
                }
            }

            ans.add(list);
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};

        List<List<Integer>> ans = subsets(nums);

        System.out.println(ans);
    }
}
