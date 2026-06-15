public class Gcdd {
    public static int gcd(int a, int b){
        int c;
        if(a>b){
            c=b;
        }
        else{
            c=a;
        }
        for(int i=c;i>0; i--){
            if(a%i==0 && b%i==0){
                return i;
            }
        }
        return 0;
    }

    

    public static void main(String[] args) {

        System.out.println(gcd(36,60));

    }
    
}
