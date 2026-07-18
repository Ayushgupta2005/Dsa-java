/*
 * Problem: Sum and Multiply (LeetCode)
 *
 * Remove all zero digits from n, then return the zero-free number
 * multiplied by the sum of its digits. First loop strips zeros (building
 * the reversed number) while summing digits; second loop reverses it back
 * to the original digit order.
 *
 * Time Complexity: O(number of digits)
 * Space Complexity: O(1)
 */
public class SumAndMultiply {
    public long sumAndMultiply(int n) {
        int ans =0;
        int sum=0; // Easy lol

        while(n>0){

            int a = n%10;
            if(a!=0){
            ans = ans * 10 +a;
            sum = sum+a;
            }
            n=n/10;
        }

        while(ans!=0){
            n=n*10+ans%10;
            ans=ans/10;
        }

        return (long)n*sum;

    }

    public static void main(String[] args) {
        SumAndMultiply obj = new SumAndMultiply();
        System.out.println(obj.sumAndMultiply(1024)); // 124 * (1+2+4) = 868
        System.out.println(obj.sumAndMultiply(505));  // 55 * (5+5) = 550
        System.out.println(obj.sumAndMultiply(7));    // 7 * 7 = 49
    }
}
