public class StarPlus {
    public static void main(String[] args) {
        int a=(6/2)-1;
        for(int i=0; i<5; i++){
            System.out.println();
            for(int j=0; j<5; j++){
                if(i==a || j==a){
                    System.out.print("* ");
                }
                else{
                    System.out.print("  ");
                 }
                
            }
        }
    }
    
}
