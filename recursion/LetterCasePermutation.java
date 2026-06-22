
import java.util.ArrayList;
import java.util.List;

/*
 * Problem: Letter Case Permutation (LeetCode 784)
 * Time Complexity: O(n * 2^n)
 * Space Complexity: O(n) recursion stack (excluding output)
 */
public class LetterCasePermutation {

    public static void generate(String str,String s, int idx, ArrayList<String> ans){

        if(idx==s.length()){
            ans.add(str);
            return;
        }

        if(Character.isLetter(s.charAt(idx))){
            generate(str+s.charAt(idx),s,idx+1,ans);

            if(Character.isLowerCase(s.charAt(idx))){
            generate(str+Character.toUpperCase(s.charAt(idx)),s,idx+1,ans);}
            else{
                generate(str+Character.toLowerCase(s.charAt(idx)),s,idx+1,ans);}

        }
        else{
            generate(str+s.charAt(idx),s,idx+1,ans);
        }
    }

    public List<String> letterCasePermutation(String s) {

        ArrayList<String> ans = new ArrayList<>();

        generate("",s,0,ans);
        return ans;

    }

    public static void main(String[] args) {
        LetterCasePermutation obj = new LetterCasePermutation();
        System.out.println(obj.letterCasePermutation("a1b2"));
    }
}
