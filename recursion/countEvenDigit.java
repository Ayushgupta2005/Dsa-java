package recursion;
public class CountEvenDigit{

    public static int countEven(int n){
        if(n==0){
            return 0;
        }
        int lastdigit = n%10;
        if(lastdigit %2 ==0){
            return 1 + countEven(n/10);
        }
        else{
            return countEven(n/10);
        }

    }

    public static void main(String[] args) {
        
        int number =123456;
        int sol = countEven(number);
        System.out.println(" even digits " + sol);
    }
    
    
}
