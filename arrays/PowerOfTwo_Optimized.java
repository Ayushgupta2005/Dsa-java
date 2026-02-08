   
   //Leetcode Q: 231. Power of Two
   
   class PowerOfTwo_Optimized{

    public static boolean isPowerOfTwo(int n) {

        if (n>0 && (n & (n-1)) == 0){ // Time Complexity: O(1)
            return true;
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