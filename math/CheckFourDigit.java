public class CheckFourDigit {
    public static void main(String[] args) {
        int n =12324;
        int count =0;
        int tar = 4;

        while (n>0){
            n=n/10;
            count = count +1;
        }
        if (count == tar){
            System.out.println("yes ");
        }
        else{
            System.out.println("no");
        }

    }

    
}
