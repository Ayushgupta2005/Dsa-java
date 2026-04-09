public class Practice {
    public static void main(String[] args) {
        
        int arr[] ={5,3,2,1,8};

        for(int i=0; i<arr.length; i++){
            int minIndex=i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[j]<arr[minIndex]){
                    minIndex=j;
                }

            }

            // Swap operation 
            int temp =arr[i];
            arr[i]=arr[minIndex];
            arr[minIndex]=temp;
        }


        for(int i=0; i<arr.length ;i++){
            System.out.print(arr[i]+ " ");
        }
    }
    
}
