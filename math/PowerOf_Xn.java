package math;

public class PowerOf_Xn {
    public static long power(long x, int n) {
        long result = 1;
        while (n > 0) {
            result *= x;
            n--;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(power(7,8));
    }
    
}
