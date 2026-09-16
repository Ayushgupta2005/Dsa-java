package bit_manipulation;

public class PowerOfFour {

    public static boolean isPowerOfFour(int n) {

        int a = 0;

        if (n == 2147483647) {
            return false;
        }

        while (true) {

            int check = (int) Math.pow(4, a);

            if (check == n) {
                return true;
            }

            if (check > n) {
                return false;
            }

            a++;
        }
    }

    public static void main(String[] args) {

        int n = 16;

        System.out.println(n + " is power of four: " + isPowerOfFour(n));
    }
}
