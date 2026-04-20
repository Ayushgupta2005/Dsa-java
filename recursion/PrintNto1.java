package recursion;


public class PrintNto1 {

    public static void Print(int n){
        if(n==0){
            return;
        }
        System.out.print(" "+ n);
        Print(n-1);

    }
    public static void main(String[] args) {
        Print(10);
    }
    
}
