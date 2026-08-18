package MultiDimentional_Arrays;

import java.util.Arrays;

/*
 * Problem: Flipping an Image (LeetCode 832)
 *
 * Invert every bit (0 <-> 1), then reverse each row with two pointers.
 * Order does not matter here since inverting and reversing are independent.
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(1)  (in place)
 */
public class FlippingAnImage {
    public int[][] flipAndInvertImage(int[][] image) {

        for(int i=0; i<image.length; i++){

            for(int j=0; j<image[0].length; j++){
                if(image[i][j]==0){
                    image[i][j]=1;
                }
                else{
                    image[i][j]=0;
                }
            }
        }

        for(int i=0; i<image.length; i++){

            int a=0;
            int b=image[0].length-1;

            while(a<b){
                int temp = image[i][a];
                image[i][a]=image[i][b];
                image[i][b]=temp;
                a++;
                b--;
            }
        }

        return image;
    }

    public static void main(String[] args) {
        FlippingAnImage obj = new FlippingAnImage();

        int[][] img1 = {{1,1,0},{1,0,1},{0,0,0}};
        System.out.println(Arrays.deepToString(obj.flipAndInvertImage(img1)));
        // Expected: [[1, 0, 0], [0, 1, 0], [1, 1, 1]]

        int[][] img2 = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
        System.out.println(Arrays.deepToString(obj.flipAndInvertImage(img2)));
        // Expected: [[1, 1, 0, 0], [0, 1, 1, 0], [0, 0, 0, 1], [1, 0, 1, 0]]
    }
}
