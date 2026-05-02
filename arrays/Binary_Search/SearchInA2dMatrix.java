package Binary_Search;
// Leetcode 240
public class SearchInA2dMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        int i=0;
         int j=matrix[i].length-1;
         if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
    return false;

         while(j>=0 && i<matrix.length){
            if(matrix[i][j]==target){
                return true;
            }
            else if(matrix[i][j]>target){
                j--;
            }
            else{
                i++;
            }
         }
         return false;
        
    }
}
    
