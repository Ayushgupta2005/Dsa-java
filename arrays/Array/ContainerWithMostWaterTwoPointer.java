/*
 * Problem: Container With Most Water (LeetCode 11) - two pointers
 *
 * Start with the widest container (both ends). Area is limited by the
 * SHORTER wall, so moving the taller wall inward can never help - only
 * moving the shorter one can find a taller limit. Shrink from the shorter
 * side each step and track the best area.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class ContainerWithMostWaterTwoPointer {
    public int maxArea(int[] height) {

        int ans =0;

        int i=0;
        int j=height.length-1;

        while(i<j){

            int a = Math.min(height[i],height[j]);
            int area =(j-i)*a;

            ans = Math.max(ans,area);

            if(height[j]>=height[i]){
                i++;
            }
            else j--;
        }
        return ans;

    }

    public static void main(String[] args) {
        ContainerWithMostWaterTwoPointer obj = new ContainerWithMostWaterTwoPointer();
        System.out.println(obj.maxArea(new int[]{1,8,6,2,5,4,8,3,7})); // Expected: 49
        System.out.println(obj.maxArea(new int[]{1,1}));               // Expected: 1
    }
}
