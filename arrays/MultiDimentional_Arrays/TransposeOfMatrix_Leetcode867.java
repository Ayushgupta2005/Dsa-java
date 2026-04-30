package MultiDimentional_Arrays;


// Leetcode 867: Transpose of a matrix
public class TransposeOfMatrix_Leetcode867 {
    public int[][] transpose(int[][] matrix) {



        if(matrix.length==matrix[0].length){

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){

                if(j>i){
                    int temp = matrix[i][j];
                    matrix[i][j]=matrix[j][i];
                    matrix[j][i]= temp;
                }
            }
        }
        return matrix;
        
    }

    else{
        int arr[][] = new int[matrix[0].length][matrix.length];

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                arr[j][i]=matrix[i][j];
    }
        }
    return arr;

}
// OR

// public int[][] transpose(int[][] matrix) {
//         int m = matrix.length;
//         int n = matrix[0].length;

//         int[][] result = new int[n][m];

//         for(int i = 0; i < m; i++){
//             for(int j = 0; j < n; j++){
//                 result[j][i] = matrix[i][j];
//             }
//         }

//         return result;
//     }
// }
}
}