package MultiDimentional_Arrays;

/*
 * Problem: Score After Flipping Matrix (LeetCode 861)
 *
 * Reading each row as a binary number, the leading bit dominates the value
 * most, so every row is first flipped to force its first column to 1
 * (maximizing the most significant bit of every row for free). Then, for
 * each remaining column, flip it if 1s are the minority - more 1s than 0s
 * in a column always beats the alternative once every row already starts
 * with a 1. Finally sum every row's binary value.
 *
 * Time Complexity: O(rows * cols)
 * Space Complexity: O(1)  (in place)
 */
public class ScoreAfterFlippingMatrix {
    public int matrixScore(int[][] grid) {

        for(int i=0; i<grid.length; i++){
            if(grid[i][0]==0){
                for(int j=0; j<grid[0].length; j++){
                    if(grid[i][j]==0){
                        grid[i][j]=1;
                    }
                    else{
                        grid[i][j]=0;
                    }
                }
            }
        }

        for(int i=0; i<grid[0].length; i++){

            int zero=0;
            int one =0;
            for(int j=0; j<grid.length; j++){
                if(grid[j][i]==0){
                    zero++;
                }
                else{
                    one++;
                }
            }

            if(zero>one){
                for(int j=0; j<grid.length; j++){
                    if(grid[j][i]==0){
                        grid[j][i]=1;
                    }
                    else{
                        grid[j][i]=0;
                    }
                }
            }
        }
        int ans= 0;

        for(int i=0; i<grid.length; i++){
            int a=0;
            int poww =0;

            for(int j=grid[0].length-1; j>=0; j--){

                int c= (int) Math.pow(2,poww);
                c=grid[i][j] * c;
                a=a+c;
                poww++;
            }
            ans=ans+a;
        }
        return ans;

    }

    public static void main(String[] args) {
        ScoreAfterFlippingMatrix obj = new ScoreAfterFlippingMatrix();
        int[][] grid1 = {{0,0,1,1},{1,0,1,0},{1,1,0,0}};
        System.out.println(obj.matrixScore(grid1)); // Expected: 39

        int[][] grid2 = {{0}};
        System.out.println(obj.matrixScore(grid2)); // Expected: 1
    }
}
