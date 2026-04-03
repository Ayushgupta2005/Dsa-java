public class Seregate {
    public static void main(String[] args) {

        int arr[] = {0,0,1,1,0};
        int n=arr.length;
        int left =0;
        int right = n-1;
        
        while(left<right){
            while(arr[left]==0 && left<right) left++;
            
            while(arr[right]==1 && left<right) right--;
            
            
            if(left<right){
                arr[left]=0;
                arr[right]=1;
                left++;
                right--;
            }
    }
    
}
}
