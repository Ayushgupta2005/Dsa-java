package sliding_window;

/*
 * Problem: Maximum Number of Vowels in a Substring of Given Length (LeetCode 1456)
 *
 * Classic fixed-size sliding window: maintain a window of size k, count vowels,
 * and slide it across the string adding the new char and removing the old one.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class MaxVowelsInSubstringIMP {

    public static boolean isVowel(char a){
        if(a=='a' || a=='e' || a=='i' || a=='o' || a=='u'){
            return true;
        }
        return false;

    }
    public int maxVowels(String s, int k) {
        int max=0;

    int curmax =0;

        for(int i=0; i<k; i++){
            if(isVowel(s.charAt(i))){
                curmax = curmax +1;
            }

        }
        max = curmax;
        if(curmax==k){
            return k;
        }

        for(int i=k; i<s.length(); i++){

            if(isVowel(s.charAt(i))){
                curmax = curmax +1;
            }

            if(isVowel(s.charAt(i-k))){
                curmax = curmax -1;
            }
            max=Math.max(curmax,max);

        }

        return max;

    }

    public static void main(String[] args) {
        MaxVowelsInSubstringIMP obj = new MaxVowelsInSubstringIMP();
        System.out.println(obj.maxVowels("abciiidef", 3)); 
        System.out.println(obj.maxVowels("aeiou", 2));      
        System.out.println(obj.maxVowels("leetcode", 3));   
    }
}
