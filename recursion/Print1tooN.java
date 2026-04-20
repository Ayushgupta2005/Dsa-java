package recursion;


public class Print1tooN {

    public static void Print(int x, int n){
        if(x>n){
            return;
        }

        System.out.println(x+ " ");
        Print(x+1, n);
    }

    public static void main(String[] args) {
        Print(1,10);


        
    }
    
}
