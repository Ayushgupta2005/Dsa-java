package Hash_map;

import java.util.*;

public class MinimumDistance {

    public static int minimumDistance(int[] nums) {

        int min = Integer.MAX_VALUE;

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
                map.get(nums[i]).add(i);
            } 
            else {
                map.get(nums[i]).add(i);

                if (map.get(nums[i]).size() == 3) {

                    int a = map.get(nums[i]).get(0);
                    int b = map.get(nums[i]).get(map.get(nums[i]).size() - 1);

                    int c = 2 * (b - a);

                    min = Math.min(min, c);

                    // Remove oldest occurrence
                    map.get(nums[i]).remove(0);
                }
            }
        }

        if (min == Integer.MAX_VALUE) {
            return -1;
        } else {
            return min;
        }
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 1, 1, 2};

        int ans = minimumDistance(nums);

        System.out.println("Minimum Distance: " + ans);
    }
}