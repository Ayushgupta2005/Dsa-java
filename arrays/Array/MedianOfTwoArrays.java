public class MedianOfTwoArrays {

    public static void main(String[] args) {
        
        int arr1[]= {1,2};
        int arr2[]={3,4};

        int a=arr1.length;
        int b=arr2.length;
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

            if(arr3.length%2==0){
                int mid=arr3.length/2;
                int n=mid -1;
                float ans= (float) ((arr3[mid]+arr3[n])/2.0);
                System.out.println(" the median is"+ ans);
            }
            else{
                int mid = arr3.length /2;
                int ans= arr3[mid];
                System.out.println("the median is"+ ans);

            }
        }

    }