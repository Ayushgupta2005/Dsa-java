package MultiDimentional_Arrays;

public class Row_With_Max_sum {

    public static void main(String[] args) {

        int arr[][] = {{2,1 ,3,4,7}, {7,2,1,6,3},{5,5,4,1,4},{3,1,8,2,6}};

        int idx=0;
        int max=Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++){
            int sum=0;
            for(int j=0; j<arr[i].length; j++){
                sum=sum+arr[i][j];
            }
            if(sum>max){
                max=sum;
                idx =i;
            }
        }
        System.out.println(idx+ " sum is " + max);
    }
    
}
