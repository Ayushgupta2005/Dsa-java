package recursion;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem: Generate Parentheses (LeetCode 22)
 * Time Complexity: O(4^n / sqrt(n))  (nth Catalan number of valid strings)
 * Space Complexity: O(n) recursion stack
 */
public class GenerateParenthesis {

    public static void fxn(String str, int n, int a, int b,ArrayList<String> ans){


        if(a==n && b==n){
            ans.add(str);
            return;
        }
        if(str.length()==0){
            fxn(str+'(', n,a+1,b,ans);
        }
        else if(a<n && a>b){
            fxn(str+'(',n,a+1,b,ans);
            fxn(str+')',n, a,b+1,ans);
        }else if(a<n && a==b){
            fxn(str+'(',n,a+1,b,ans);
        }else if(a==n && b<a){
            fxn(str+')',n, a,b+1,ans);
        }


    }

    public List<String> generateParenthesis(int n) {

        ArrayList<String> ans = new ArrayList<>();

        fxn("",n,0,0,ans);
        return ans;

    }

    public static void main(String[] args) {
        ArrayList<String> ans = new ArrayList<>();
        fxn("", 3, 0, 0, ans);
        System.out.println(ans); // Expected: [((())), (()()), (())(), ()(()), ()()()]
    }
}
