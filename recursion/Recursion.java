public class Recursion {

    public static void main(String[] args) {
        
        int arr[] = {2,3,7,8,10};

        int i=0;
        int j=arr.length-1;
        int target =9;
        boolean found =false;

        while(i<=j){
            int mid = i+(j-i)/2;

            if(arr[mid]==target){
                System.out.println("element found at index " + mid);
                found = true;
                break;
        }
        else if(arr[mid]>target){
            j=mid-1;
        }
        else{
            i=mid+1;
        }

    }

    if(found==false){
        System.out.println("Element not found");
    }


    
    }
    }
        