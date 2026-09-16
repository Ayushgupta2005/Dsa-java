package bit_manipulation;

public class MinimumBitFlips {

    public static int minBitFlips(int start, int goal) {

        int a = start ^ goal;
        int count = 0;

        while (a > 0) {
            if (a % 2 == 1) {
                count++;
            }
            a = a / 2;
        }

        return count;
    }

    public static void main(String[] args) {

        int start = 10;
        int goal = 7;

        int ans = minBitFlips(start, goal);

        System.out.println("Minimum Bit Flips: " + ans);
    }
}