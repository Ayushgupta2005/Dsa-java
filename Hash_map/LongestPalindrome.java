package Hash_map;
import java.util.HashMap;
import java.util.Map;

// the length of the longest palindrome that can be built with those letters.
public class LongestPalindrome {
    public static int longestPalindrome(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }
            else{
                map.put(s.charAt(i),1);
            }

        }  
        int sol =0;
        boolean hasOddFreq = false;

        for(int freq : map.values()){
            if((freq % 2)==0){
                sol+=freq;
            }
            else{
                sol+=freq -1;
                hasOddFreq =true;


            }
        }
        if(hasOddFreq){
            return sol+1;
        }     
        else{
            return sol;
        } 
    }
    public static void main(String[] args) {
        String s="abccccdd";
        int sol = longestPalindrome(s);
        System.out.println(sol);
        
    }
    
}
