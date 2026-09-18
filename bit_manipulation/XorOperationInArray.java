package bit_manipulation;

public class XorOperationInArray {

    public static int xorOperation(int n, int start) {

        int ans = start;

        for (int i = 0; i < n - 1; i++) {

            start = start + 2;

            ans = ans ^ start;
        }

        return ans;
    }

    public static void main(String[] args) {

        int n = 5;
        int start = 0;

        System.out.println("XOR Result: " + xorOperation(n, start));
    }
}
