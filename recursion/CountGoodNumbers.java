package recursion;

/*
 * Problem: Count Good Numbers (LeetCode 1922)
 * Time Complexity: O(log n)  (fast exponentiation)
 * Space Complexity: O(log n) recursion stack
 */
public class CountGoodNumbers {

    public static long power(long a, long b){
        long Mod = 1000000007;
        if(b==0){
            return 1;
        }

        long half = power(a,b/2);

        if(b%2==0){
            return ((half * half) % Mod);

        }
        else{
            return ((a*half * half)%Mod);
        }

    }
    public int countGoodNumbers(long n) {

        long even = (n+1)/2;
        long odd = n/2;

        long evenChoices = power(5, even);

        long oddChoices = power(4, odd);
        long Mod = 1000000007;

        return (int) ((evenChoices * oddChoices) % Mod);

    }

    public static void main(String[] args) {
        CountGoodNumbers obj = new CountGoodNumbers();
        System.out.println(obj.countGoodNumbers(1)); // Expected: 5
        System.out.println(obj.countGoodNumbers(4)); // Expected: 400
        System.out.println(obj.countGoodNumbers(50)); // Expected: 564908303
    }
}
