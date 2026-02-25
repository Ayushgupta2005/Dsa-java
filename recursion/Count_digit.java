package recursion;

public class Count_digit {

    static int countDigits(int n) {
        if (n >= 0 && n <= 9) {
            return 1;
        }
        return 1 + countDigits(n / 10);
    }

    public static void main(String[] args) {
        int num = 12345;
        System.out.println("Number of digits in " + num + " = " + countDigits(num));
    } // Time complexity: O(d)
}
    
