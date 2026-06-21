package recursion;

/*
 * Problem: Print an array in reverse using recursion
 * Time Complexity: O(n)
 * Space Complexity: O(n) recursion stack
 */
public class PrintArrayReverse {

    public static void print(int[] arr,int b){
        int a= arr.length-1;
        if(b>a){
            return;
        }

        System.out.print(arr[-(b-a)]+" ");
        print(arr,b+1);


    }
    public static void recPrint(int[] arr, int idx){
        if(idx == arr.length) return;
        recPrint(arr,idx+1);
        System.out.print(arr[idx]+" ");
    }

public static void main(String[] args) {

    int arr[] = {5,4,7,8,12,34,54,60};

    print(arr,0);

    System.out.println();
    recPrint(arr,0);


}
    }
