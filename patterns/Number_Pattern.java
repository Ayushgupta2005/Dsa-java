/*
Write a program to print the following pattern:
1
12
123
1234
12345 */

package patterns;

public class Number_Pattern {

    public static void main(String[] args) {
        
        for (int i=1; i<6; i++){

            System.out.println();
            for (int j=1; j<=i; j++ ){
                System.out.print(j);

            }
        }
    }
    
}
