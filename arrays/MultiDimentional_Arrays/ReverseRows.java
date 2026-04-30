package MultiDimentional_Arrays;

public class ReverseRows {

    public static void main(String[] args) {
        
    int arr[][] = {{2,8 ,3,4,7}, {7,2,1,6,3},{5,5,4,1,4},{3,1,8,2,6}};

    for(int i=0; i<arr.length; i++){
        
        int k= 0;
        int j=arr[i].length-1;

        while(k<j){
            int temp= arr[i][k] ;
            arr[i][k]= arr[i][j];
            arr[i][j]= temp;

            k++;
            j--;
        } 
}

for(int i=0; i<arr.length; i++){
    System.out.println();
    for(int j=0; j<arr[i].length; j++){
        System.out.print(arr[i][j]+ " ");

    }
}
}
    }
