package patterns;

public class AbhinavSirPattern {

    public static void main(String[] args) {
        
    

    int[] arr = {4,3,6,1,3,5};
    int max =0;

    for(int i=0; i<arr.length; i++){
        if(arr[i]>max){
            max = arr[i];
        }
    }

    for(int i=0; i<max; i++){
        System.out.println();

            for(int j=0; j<arr.length; j++){
                if(arr[j]>0){
                    System.out.print("*"+" ");
                    arr[j] = arr[j]-1;
                }
                else{
                    System.out.print("  ");
                }
                
            }
    }


    
}
}
