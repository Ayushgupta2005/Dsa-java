package Hash_map;

import java.util.HashSet;
import java.util.List;

/*
 * Problem: Replace Words (LeetCode 648)
 *
 * Put every dictionary root into a HashSet. Split the sentence on spaces
 * by hand with two pointers (i, j), and for each word try every prefix
 * from shortest to longest - the first prefix found in the set is the
 * shortest matching root, so it replaces the whole word; otherwise the
 * word is kept as-is.
 *
 * Time Complexity: O(n * L^2)  n = sentence length, L = longest word
 *                  (each prefix check does an O(L) substring + hash lookup)
 * Space Complexity: O(d)  d = total dictionary characters
 */
public class ReplaceWords {

    public static String check(String s, HashSet<String> set){

        for(int i=1; i<=s.length(); i++){
            String substr = s.substring(0,i);
            if(set.contains(substr)){
                return substr;
            }
        }

        return s;
    }

    public String replaceWords(List<String> dictionary, String sentence) {

        HashSet<String> set = new HashSet<>();
        for(int i=0; i<dictionary.size(); i++){
            set.add(dictionary.get(i));
        }

        int i=0;
        int j=0;
        StringBuilder ans = new StringBuilder();

        while(i<sentence.length()){

            while(j<sentence.length() && sentence.charAt(j)!=' '){
                j++;
            }
            if(j==sentence.length()){
                String s= sentence.substring(i,j);
                String subb = check(s,set);

                ans.append(subb);
                return ans.toString();

            }
            else{
                String s= sentence.substring(i,j);
                String subb = check(s,set);

                ans.append(subb);
                ans.append(' ');

            }
            i=j+1;
            j=i;

        }
        return ans.toString();

    }

    public static void main(String[] args) {
        ReplaceWords obj = new ReplaceWords();
        System.out.println(obj.replaceWords(java.util.Arrays.asList("cat","bat","rat"), "the cattle was rattled by the battery"));
        // Expected: the cat was rat by the bat
        System.out.println(obj.replaceWords(java.util.Arrays.asList("a","b","c"), "aadsfasf absbs bbab cadsfafs sdfafs"));
        // Expected: a a b c sdfafs
    }
}
