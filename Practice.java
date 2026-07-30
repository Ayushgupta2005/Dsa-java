public class Practice {

    public static int getGcd(int a , int b){
        if(a==0){
            return b;
        }

        return getGcd(b%a,a);
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println(getGcd(10,15));
        
    }
    
}
