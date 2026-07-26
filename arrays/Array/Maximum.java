public class Maximum {
    public static void main(String[] args) {
        

        int arr[]= {1,9,2,8,3,7,4,6,5};
        int max = arr[0];

        for(int i=0; i<arr.length; i++){
            if (arr[i]>max){
                max = arr[i];
            }
        }
        System.out.println("Maximum element in array is" + max);

    }
}
