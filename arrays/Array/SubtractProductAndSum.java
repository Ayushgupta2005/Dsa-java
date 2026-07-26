/*
Problem: Subtract the Product and Sum of Digits of an Integer (LeetCode 1281)

Time Complexity: O(log n)
Space Complexity: O(1)
*/


public class SubtractProductAndSum {

    public static int subtractProductAndSum(int n) {

        int product = 1;
        int sum = 0;

        while (n > 0) {
            int digit = n % 10;

            product *= digit;
            sum += digit;

            n /= 10;
        }

        return product - sum;
    }

    public static void main(String[] args) {
        int n = 234;

        System.out.println(subtractProductAndSum(n));
    }


    
}
