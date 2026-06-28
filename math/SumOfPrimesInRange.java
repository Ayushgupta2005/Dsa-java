/*
 * Problem: Sum of primes in the range [n, reverse(n)]
 *
 * Reverse the digits of n, then sum all prime numbers in the inclusive
 * range between n and its reverse (whichever is smaller .. larger).
 * Primality is checked by trial division up to sqrt(i).
 *
 * Time Complexity: O(R * sqrt(R))  where R is the larger endpoint
 * Space Complexity: O(1)
 */
public class SumOfPrimesInRange {

    public static boolean check(int n){
        if(n < 2) return false;

    for(int i = 2; i * i <= n; i++){

        if(n % i == 0){

           return false;
        }
    }
    return true;
    }

   public int sumOfPrimesInRange(int n) {

    int original = n;
    int rev = 0;

    while(n != 0){
        rev = rev * 10 + (n % 10);
        n /= 10;
    }

    int sum = 0;

    for(int i = Math.min(original, rev); i <= Math.max(original, rev); i++){
        if(check(i)){
            sum += i;
        }
    }

    return sum;
}

    public static void main(String[] args) {
        SumOfPrimesInRange obj = new SumOfPrimesInRange();
        System.out.println(obj.sumOfPrimesInRange(13)); // range [13, 31] -> 13+17+19+23+29+31 = 132
        System.out.println(obj.sumOfPrimesInRange(20)); // range [2, 20]  -> 2+3+5+7+11+13+17+19 = 77
    }
}
