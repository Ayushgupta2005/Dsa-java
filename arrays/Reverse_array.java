public class Reverse_array {
    public static void main(String[] args) {
        
        int arr[] = {1,2,3,4,5};

        int i=0;
        int j=arr.length-1;

        while (i<j){ // time complexity(O(n))
            int k=arr[i];  
            arr[i]=arr[j];  // swap 
            arr[j]=k;

            i++;
            j--;
        }

        for (int l=0; l<arr.length; l++){
            System.out.print(arr[l]+ " ");

        }
    }
    
}
