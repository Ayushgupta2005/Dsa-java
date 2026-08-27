public class Patternn {

    public static void main(String[] args) {

        int a=1;
        
        for(int i=1; i<6; i++){

            for(int j=0; j<5-i; j++){
                System.out.print(" ");
            }

            for(int j=0; j<a; j++){
                System.out.print("*");
                
            }
            a=a+2;

            System.out.println();
        }

        int b=7;
        for(int i=1; i<5; i++){

            for(int j=0; j<i; j++){
                System.out.print(" ");
            }

            for(int k=0; k<b; k++){
                System.out.print("*");
            }
            b=b-2;
            System.out.println();
        }
    }
    
}
