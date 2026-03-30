package patterns;
public class AlphaNumericTriangle {

    public static void main(String[] args) {
        for(int i=0; i<5; i++){
            System.err.println();
            for(int j=0; j<=i; j++){
                if(i%2==0){
                    System.out.print(j + " ");
                }
                else{
                    System.out.print((char) (j+65) + " ");
                }
            }
        }
    }
    
}
