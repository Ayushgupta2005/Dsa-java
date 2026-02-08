// Leetcode q: 27 (Remove Element)
public class Remove_element {

    public static int removeElement(int[] nums, int val) {
        
        int i=0;
        int j=nums.length-1;

        while (i<=j){
            if (nums[i]==val){ //Time complexity : O(N)
                int a=nums[i];
                nums[i]=nums[j];
                nums[j]=a;
                j--;
            }
            else{
                i++;
            }
        }
        return j+1;
    }

    public static void main(String[] args) {
        
        int nums[]= {3,2,2,3};
        int val = 3;

        System.out.println(removeElement(nums, val));
    } 
}
