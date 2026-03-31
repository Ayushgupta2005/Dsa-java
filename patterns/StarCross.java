package patterns;

public class StarCross {
    public static void main(String[] args) {
        for(int i=0; i<5; i++){
            System.out.println();
            for(int j=0; j<5; j++){
                if(i==j || i+j==4){
                    System.out.print("* ");
                }
                else{
                    System.out.print("  ");
                }
            }
        }
    }
    
}
