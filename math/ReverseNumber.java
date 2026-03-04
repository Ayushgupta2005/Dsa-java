public class ReverseNumber {

    public static void main(String[] args) {
        
        int n =1625;
        int rev=0;

        while (n>0){
            rev = rev * 10;
            rev = rev + n% 10;
            n = n/10;

        }
        System.out.println(" Reversed numeber " + rev
        );
    }
    
}
