public class Linear_search {
    public static void main(String[] args) {
        
        int arr[] = {1,2,3,4,5,4};
        int target = 4;

        for (int i=0; i<arr.length; i++){
            if(arr[i]==target){
                System.out.println("element fount at"+i);
                break;
            }
        }

    }
    
}
