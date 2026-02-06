public class Palindrome_number {

    public static boolean isPalindrome(int x){
        int a=x;
        int rev = 0;

        while (x>0){
            int digit =x %10;
            rev = rev*10 +digit; // Time Complexity = O(d) = O(\log x)} d- number of digits in x
            x = x/10;
        }
        if(a==rev){
            return true;
        }
        else{
            return false;
        }



    }
    public static void main(String[] args) {

        int x=121;

        boolean y = isPalindrome(x);
        System.out.println(y);
        
    }
    
}
