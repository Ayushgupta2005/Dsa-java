package recursion;

public class ClimbingStairs {
    public static int climbStairs(int n) {
        return climbStairss(n);
    }

    public static int climbStairss(int n){
        if(n == 1) return 1;
        if(n == 2) return 2;

        return climbStairss(n-1) + climbStairss(n-2);
    }

    public static void main(String[] args) {
        int n=4;
        System.out.println(climbStairs(n));
    }
}
    
