package patterns;

import java.util.*;
public class HollowReactangle {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("enter no of columns ");
        int columns = scanner.nextInt();
        System.out.print("enter no of rows ");
        int rows = scanner.nextInt();
        for (int i=0; i<columns;i++){
            System.out.println();
            for(int j=0; j<rows; j++){
                if(i==0 || j==0 || i==columns-1 || j==rows-1){
                System.out.print("* ");
                }
                else{
                    System.out.print("  ");
                }
            }
        }
    }
    
}
