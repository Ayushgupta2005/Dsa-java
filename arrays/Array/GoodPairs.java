import java.util.*;
public class GoodPairs {

    public static int numIdenticalPairs(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int num : nums) {
            count += map.getOrDefault(num, 0);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 1, 3};

        System.out.println(numIdenticalPairs(nums));
    }
}
