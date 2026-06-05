    import java.util.HashSet;

public class HappyNumber {



    public static boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();

        while (n != 1) {

            if (seen.contains(n)) {
                return false;
            }

            seen.add(n);

            int sum = 0;

            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }

            n = sum;
        }

        return true;
    }

    public static void main(String[] args) {

        int[] testCases = {19, 2, 7, 20};

        for (int n : testCases) {
            System.out.println("Input: " + n +
                    " Happy Number? " + isHappy(n));
        }
    }
}
    
