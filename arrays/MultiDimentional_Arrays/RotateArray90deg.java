public class RotateArray90deg {

    public static void main(String[] args) {

        int matrix = {{1,2,3},[4,5,6],[7,8,9]}
        class Solution {
    public void rotate(int[][] matrix) {
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix.length; j++){

                if(j>i){
                    int temp = matrix[i][j];
                    matrix[i][j]=matrix[j][i];
                    matrix[j][i]= temp;
                }
            }
        }

        for(int i=0; i<matrix.length; i++){

            int j=matrix.length-1;
            int k=0;

            while(k<j){
                int temp = matrix[i][k];

                matrix[i][k]=matrix[i][j];
                matrix[i][j]= temp;
                k++;
                j--;
            }
        }
        
    }
}
        

    }



    
}
