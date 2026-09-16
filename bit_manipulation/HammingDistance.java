package bit_manipulation;

public class HammingDistance {

    public static int hammingDistance(int x, int y) {

        int a = x ^ y;
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

        int x = 1;
        int y = 4;

        int ans = hammingDistance(x, y);

        System.out.println("Hamming Distance: " + ans);
    }
}
