/*
 * Problem: Longest Common Prefix (LeetCode 14)
 * Time Complexity: O(n * m) - n strings, m = shortest length
 * Space Complexity: O(m)
 */
public class LongestCommonPrefix {

    public static String fxn(String current, String strs){
        StringBuilder str = new StringBuilder();
        if(current.length()==0 || strs.length()==0){
            return "";
        }

        int i=0;
        int j=0;

        while(i<Math.min(current.length(), strs.length())){
            if(current.charAt(i)==strs.charAt(j)){
                str.append(current.charAt(i));
                i++;
                j++;
            }
            else{
                break;
            }
        }
        return str.toString();
    }
    public String longestCommonPrefix(String[] strs) {

        if (strs.length==0){
            return "";
        }
        if(strs.length==1){
            return strs[0];
        }


        String current = strs[0];
        for(int i=1; i<strs.length; i++){

            current= fxn(current,strs[i]);

            if(current.length()==0){
                return "";
            }
        }

        return current;

    }
}
