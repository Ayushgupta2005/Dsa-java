package patterns;

public class FlippedTriangle2{
    public static void main(String[] args) {
        for(int i=0; i<4; i++){
            System.out.println();
            for(int j=4; j>i; j--){
                System.out.print((char)(j+64));
            }
        }
    }
    
}
