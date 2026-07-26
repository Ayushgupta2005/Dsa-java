package Binary_Search;

public class ArrangingCoins_Leetcode441 {
    public static int mySqrt(long x) {
        if (x < 2)
            return (int) x;

        long i = 1;
        long j = x;
        long sol = 0;

        while (i <= j) {
            long mid = i + (j - i) / 2;

            if (mid > x / mid) {
                j = mid - 1;
            } else {
                sol = mid;
                i = mid + 1;
            }
        }
        return (int) sol;
    }

    public static int arrangeCoins(int n) {
        return (mySqrt(1 + 8L * n) - 1) / 2;
    }

    public static void main(String[] args) {

        System.err.println(arrangeCoins(20));
    }
}
    
