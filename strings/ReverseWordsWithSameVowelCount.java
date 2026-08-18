package strings;

import java.util.ArrayList;

/*
 * Problem: Reverse words whose vowel count matches the first word
 *
 * Split the sentence into words. Keep the first word as-is and record its
 * vowel count. Every later word with the same vowel count gets reversed;
 * the rest are left unchanged.
 *
 * Time Complexity: O(n^2) worst case (rev built with string concatenation)
 * Space Complexity: O(n)
 */
public class ReverseWordsWithSameVowelCount {

    public static int count(String s){
        int count =0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='a' || s.charAt(i)=='e'|| s.charAt(i)=='i'|| s.charAt(i)=='o'|| s.charAt(i)=='u'){
                count++;
            }
        }
        return count;
    }

    public String reverseWords(String s) {

        if(s.length()==1){
            return s;
        }

        ArrayList<String> list = new ArrayList<>();

        int i=0;
        int j=i+1;

        while(j<s.length()){

            while(j<s.length() && s.charAt(j)!=' '){
                j++;
            }

            list.add(s.substring(i,j));
            i=j+1;
            j=i;
        }
        StringBuilder str = new StringBuilder();
        str.append(list.get(0));
        str.append(' ');
        int count = count(list.get(0));

        for(int p=1; p<list.size();p++){
            int a = count(list.get(p));

            if(a==count){
                String rev ="";

                String aa = list.get(p);
                for(int k=aa.length()-1; k>=0; k--){
                    rev=rev+ aa.charAt(k);
                }

                str.append(rev);
                str.append(' ');
            }

            else{
                String aa=list.get(p);
                str.append(aa);
                str.append(' ');
            }
        }

        String ans = str.toString();
        ans = ans.trim();
        return ans;


    }

    public static void main(String[] args) {
        ReverseWordsWithSameVowelCount obj = new ReverseWordsWithSameVowelCount();

        // hello=2 vowels | world=1 (keep) | code=2 (reverse)
        System.out.println(obj.reverseWords("hello world code"));

        // abc=1 | def=1 (reverse)
        System.out.println(obj.reverseWords("abc def"));

        // single word stays as-is
        System.out.println(obj.reverseWords("hello"));
    }
}
