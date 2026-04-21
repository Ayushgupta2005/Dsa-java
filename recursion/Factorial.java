package recursion;

class Factorial {

    static int Fcatorial(int n){
        if(n==0 || n==1){
            return 1;
        }

        return n * Fcatorial(n-1);
    }

    public static void main(String[] args) {
        int fact = Fcatorial(5);
        System.out.println(fact);
    
    }
}

// Time complexity : O(n)