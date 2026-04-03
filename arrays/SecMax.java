public class SecMax {

    public static void main(String[] args) {
        
        int arr[] = {1,9,2,8,4,7,5,6};
        int max=arr[0];
        int secmax = arr[0];

        for(int i=0; i<arr.length; i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        System.out.println("Max is "+ max);

        for(int i=0; i<arr.length; i++){
            if(arr[i] == max){

            }
            else if(arr[i]>secmax){
                secmax=arr[i];

            }

            }
            System.out.println("Sec max is" + secmax);
        }
    }
