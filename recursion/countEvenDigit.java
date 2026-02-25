package recursion;

public class countEvenDigit {

    static int countEvenDigits(int n) {
        // Base case
        if (n == 0) {
            return 0;
        }

        int lastDigit = n % 10;
        if (lastDigit % 2 == 0) {
            return 1 + countEvenDigits(n / 10);
        } else {
            return countEvenDigits(n / 10);
        }
    }

    public static void main(String[] args) {
        int num = 123456;
        System.out.println("Count of even digits in " + num + " = " + countEvenDigits(num));
    }
}
    
