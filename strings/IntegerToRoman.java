package strings;

/*
 * Problem: Integer to Roman (LeetCode 12)
 *
 * Greedy: keep the value/symbol pairs in descending order (including the
 * subtractive forms CM, CD, XC, XL, IX, IV). Repeatedly subtract the
 * largest value that still fits, appending its symbol each time.
 *
 * Time Complexity: O(1)  (bounded by the fixed symbol table)
 * Space Complexity: O(1)
 */
public class IntegerToRoman {

    public String intToRoman(int num) {
        int numbers[]={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        int i=0;
        String romanNumbers[]={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder sb=new StringBuilder();

        while(num>0){
            if(numbers[i]<=num){
                sb.append(romanNumbers[i]);
                num-=numbers[i];
            }else{
                i++;
            }
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        IntegerToRoman obj = new IntegerToRoman();
        System.out.println(obj.intToRoman(3749)); // Expected: MMMDCCXLIX
        System.out.println(obj.intToRoman(58));   // Expected: LVIII
        System.out.println(obj.intToRoman(1994)); // Expected: MCMXCIV
    }
}
