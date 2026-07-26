/*Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49 */

// Leetcode 11 (container With most water ) Brute force Approach submitted but time limit exceeded 

public class ContainerWithMostWater_BruteForce {
    public static int maxArea(int[] height) {

        int max=0;
        for (int i=0; i<height.length; i++){
            int area = 1;
            int a=0;

            for (int j=i+1; j<height.length; j++){

                if(height[i]<height[j]){
                    a = height[i] *area;
                    area = area +1;
                }
                else{
                    a= height[j]*area;
                    area = area + 1;

                }
                if (a > max){
                    max = a;
                }
            }
        }
        return max;
        
    }

    public static void main(String[] args) {
        int height[] = {1,8,6,2,5,4,8,3,7};
        System.out.println("max area = " + maxArea(height));
    }
}
