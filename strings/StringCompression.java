package strings;

import java.util.Arrays;

/*
 * Problem: String Compression (LeetCode 443)
 *
 * Compress runs of repeated chars in-place: read pointer i scans each run
 * and counts it, write pointer j writes the char followed by the count's
 * digits (only when count > 1). Returns the new length.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class StringCompression {
    public int compress(char[] chars) {

        int i=0;
        int j=0;

        while(i<chars.length){
            char a = chars[i];
            int count =1;
            i=i+1;

            while(i<chars.length && chars[i]==a){
                count++;
                i++;
            }

            chars[j]=a;
            j++;

            if(count>1){
                String s = Integer.toString(count);

                for(int k=0; k<s.length(); k++){
                    chars[j] = s.charAt(k);
                    j++;
                }
            }


        }
        return j;
    }

    public static void main(String[] args) {
        StringCompression obj = new StringCompression();

        char[] chars1 = {'a','a','b','b','c','c','c'};
        int len1 = obj.compress(chars1);
        System.out.println(len1 + " -> " + new String(Arrays.copyOf(chars1, len1))); // Expected: 6 -> a2b2c3

        char[] chars2 = {'a'};
        int len2 = obj.compress(chars2);
        System.out.println(len2 + " -> " + new String(Arrays.copyOf(chars2, len2))); // Expected: 1 -> a

        char[] chars3 = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        int len3 = obj.compress(chars3);
        System.out.println(len3 + " -> " + new String(Arrays.copyOf(chars3, len3))); // Expected: 4 -> ab12
    }
}
