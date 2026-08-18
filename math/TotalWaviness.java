/*
 * Problem: Total Waviness
 *
 * A digit is "wavy" if it is strictly greater than both its neighbours (a
 * peak) or strictly less than both (a valley). Only interior digits can
 * qualify. Sum the waviness of every number in the range [num1, num2].
 *
 * Time Complexity: O((num2 - num1) * d)  d = number of digits
 * Space Complexity: O(d)
 */
public class TotalWaviness {

    public int waviness(int x){
        String s= Integer.toString(x);

        int cnt=0;

        for(int i=1; i<s.length()-1;i++){
            char cur = s.charAt(i);

             if ((cur > s.charAt(i - 1) && cur > s.charAt(i + 1)) ||
                (cur < s.charAt(i - 1) && cur < s.charAt(i + 1))) {
                cnt++;
            }
        }
        return cnt;
    }


    public int totalWaviness(int num1, int num2) {

        int ans=0;

        for(int i=num1; i<=num2; i++){
            ans = ans + waviness(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        TotalWaviness obj = new TotalWaviness();

        System.out.println(obj.waviness(121));   // peak at '2'          -> 1
        System.out.println(obj.waviness(123));   // strictly increasing  -> 0
        System.out.println(obj.waviness(212));   // valley at '1'        -> 1
        System.out.println(obj.waviness(12321)); // one peak at '3'      -> 1

        System.out.println(obj.totalWaviness(1, 10));    // all 1-2 digit numbers -> 0
        System.out.println(obj.totalWaviness(120, 125)); // 120 and 121 are wavy  -> 2
    }
}
