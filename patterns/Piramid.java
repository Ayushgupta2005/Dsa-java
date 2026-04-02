public class Piramid {
    public static void main(String[] args) {

        
        for(int i=4; i>0; i--){
            System.out.println();

            for(int j=i-1;j>0; j--){
                System.out.print(" ");
            }
           for(int k = (2*(5 - i) - 1); k > 0; k--){
                System.out.print("*");
            }
            }
        }
    }
    