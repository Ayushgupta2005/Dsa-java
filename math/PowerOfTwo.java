package math;

public class PowerOfTwo {
    public static boolean isPowerOfTwo(int n) {

        if (n<=0){
            return false;
        }
        while (n%2==0){
            n=n/2;
        }

        if (n==1){
            return true; //Time Complexity: O(log n)
        }
        else{
            return false;
        }
        
    }
    public static void main(String[] args) {
        int a=16;

        System.out.println(isPowerOfTwo(a));
    }

    
}
