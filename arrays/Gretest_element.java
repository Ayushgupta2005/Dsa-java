public class Gretest_element {

    public static void main(String[] args) {
        
        int arr[]={5,3,7,9,2,1};

        int a=arr[0];

        for(int i=1; i<arr.length; i++){ // O(n) time complexity 
            if (arr[i]>a){
                a = arr[i];
            }

        }
        System.out.println("the gretest element is " + a);


    }
    
}
