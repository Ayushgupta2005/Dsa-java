public class MergeSortedArray {

    public static void main(String[] args) {
        
        int arr1[]= {2,5,6,9};
        int arr2[]={1,3,4,5,5,10,11};

        int a=arr1.length;
        int b= arr2.length;
        int arr3[]=new int[a+b];

        int i = 0;
        int j=0;
        int k=0;

        while(i<a && j<b){

            if(arr1[i]<=arr2[j]){
                arr3[k]=arr1[i];
                k++;
                i++;

            }
            else{
                arr3[k]=arr2[j];
                k++;
                j++;
            }
            
        }

        if(i==a){
            for(int l=j; l<b; l++){
                arr3[k]=arr2[l];
                k=k+1;

            }
        }
            else{
                for(int m=i; m<a; m++){
                    arr3[k]=arr1[m];
                    k=k+1;
                }
            }


            for(int g=0;g<arr3.length; g++){
                System.out.print(arr3[g]+ " ");
            }
        }

    }

