package recursion;
public class AraisedToPowerB_DividenConquer {

    public static int power(int a, int b){
        if(b==0){
            return 1;
        }
        int call = power(a,b/2);

        if(b%2==0){
            return call * call;
        }
        else{
            return a*call*call;
        }

    }

    public static void main(String[] args) {
        
        System.out.println(power(2,5));
    }
    
}
