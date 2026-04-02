public class FlippedStarTriangke {
    public static void main(String[] args) {
        
        for(int i=4; i>0; i--){
            System.out.println();
            for(int j=0; j<4; j++){
                if(j<i-1){
                    System.out.print("  ");
                }
                else{
                    System.out.print("* ");
                }
            }
        }
    }
    
}
