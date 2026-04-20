package recursion;

public class Recursion {

    static void Print(int n){
        if(n==10){
            return;
        }

        System.out.println(" Ayush");
        Print(n+1);
    }

    public static void main(String[] args) {
        Print(1);
        

    }
}