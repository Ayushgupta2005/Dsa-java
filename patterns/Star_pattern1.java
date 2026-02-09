/* Write a program to print the following pattern: (100 days of code)
*
**
***
****
*****
 */

package patterns;

public class Star_pattern1 {

    public static void main(String[] args) {

        for(int i=0; i<5; i++){
            System.out.println();
            for (int j=0; j<=i; j++){
                System.out.print("*");
            }
        }
        

    }
    
}
