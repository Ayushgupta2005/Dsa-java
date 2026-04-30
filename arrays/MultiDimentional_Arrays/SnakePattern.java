package MultiDimentional_Arrays;
// print matrix in snake pattern

public class SnakePattern {

    public static void main(String[] args) {
        int arr[][] = {{2,8 ,3,4,7}, {7,2,1,6,3},{5,5,4,1,4},{3,1,8,2,6}};

        for(int i=0; i<arr.length;i++){

            System.out.println();

            if(i%2==0){
                for(int j=0; j<arr[0].length; j++){
                    System.out.print(arr[i][j]+ " ");
                }
            }
            else{
                for(int j=arr[i].length-1; j>=0; j--){
                    System.out.print(arr[i][j]+ " ");

            }
        }
        
        
    }


    
}
}