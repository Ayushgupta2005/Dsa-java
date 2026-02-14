package strings;

import java.util.HashSet;
import java.util.Set;

// Find the length odf longest substring without repeating characters
public class LongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
 


        char arr[] = s.toCharArray();
        if (s.length() == 0) return 0;
        

        int max=0;  // brute force approach

        for(int i=0; i<arr.length; i++){
            Set<Character> set = new HashSet<>();
            int currentmax=1;

            set.add(arr[i]);

            for (int j=i+1; j<arr.length; j++){

                if (set.contains(arr[j])){
                    int n = set.size();
                    if(n>max){
                        max=n;
                    }
                    break;
                }
                else{
                    set.add(arr[j]);
                    currentmax++;
                }
            }

            max=Math.max(max, currentmax);
        }
        
        return max;
        
    }
    public static void main(String[] args) {
        String a="abcdabc";
        System.out.println(lengthOfLongestSubstring(a));
    }
}


    
