package DP;
import java.util.*;
public class HouseRobber {

    public static int[] dp;

    public static int robb(int i, int[] nums) {

        if (i >= nums.length)
            return 0;

        if (dp[i] != -1)
            return dp[i];

        int pick = nums[i] + robb(i + 2, nums);
        int skip = robb(i + 1, nums);

        int ans = Math.max(pick, skip);
        dp[i] = ans;

        return ans;
    }

    public static int rob(int[] nums) {

        dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return robb(0, nums);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of houses: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter money in each house:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int ans = rob(nums);

        System.out.println("Maximum money that can be robbed: " + ans);

        sc.close();
    }
}
