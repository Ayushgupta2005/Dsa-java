public class Selectionsort {

    public static void main(String[] args) {
        
        int arr[] = {4,1,5,2,3};

        for(int k=0; k<arr.length-1; k++){

            int minIndex =k;
            for(int i=k+1; i<arr.length; i++){
                if(arr[i]<arr[minIndex]){
                    minIndex = i;
                }
            }
            int temp = arr[k];
            arr[k]= arr[minIndex];
            arr[minIndex]=temp;
        }

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
    
}
