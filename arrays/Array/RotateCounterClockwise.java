public class RotateCounterClockwise {
    public static void main(String[] args) {
        

        int arr[] = {1,2,3,4,5};
        int d=10;

        for(int i=0; i<d; i++){
            int first=arr[0];
        
        for(int k=0; k<arr.length-1; k++){
            arr[k] = arr[k+1];
        }
        arr[arr.length-1]=first;
    }

        for(int j=0; j<arr.length; j++){
            System.out.print(arr[j]+ " ");
        }

        }
    }
    
