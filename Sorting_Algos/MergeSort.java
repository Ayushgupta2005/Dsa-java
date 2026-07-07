package Sorting_Algos;

import java.util.Arrays;

/*

 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */
public class MergeSort {

    public static void mergeSort(int arr[]){
        int n=arr.length;
        if(n==1){
            return;
        }

        int[] a = new int[n/2];
        int[] b = new int[n-n/2];

        int index = 0;

        for(int i=0; i<a.length; i++){
            a[i]=arr[index];
            index++;
        }

        for(int i=0; i<b.length; i++){
            b[i]= arr[index];
            index++;
        }

        mergeSort(a);
        mergeSort(b);

        merge(a,b,arr);
    }

public static void merge(int[] nums1, int[] nums2, int arr[]) {
        int i=0;
        int j=0;
        int k=0;

        while(i<nums1.length && j<nums2.length){

            if(nums1[i]<=nums2[j]){
                arr[k]=nums1[i];
                k++;
                i++;
            }
            else{
                arr[k]=nums2[j];
                k++;
                j++;
            }

        }

        if(i==nums1.length){
            for(int l=j; l<nums2.length; l++){
                arr[k]=nums2[l];
                k=k+1;

            }
        }
            else{
                for(int b=i; b<nums1.length; b++){
                    arr[k]=nums1[b];
                    k=k+1;
                }
            }


            for(int f=0; f<nums1.length; f++){
                nums1[f]=arr[f];
            }
    }
    public int[] sortArray(int[] nums) {

        mergeSort(nums);
        return nums;

    }

    public static void main(String[] args) {
        int[] nums1 = {5, 2, 3, 1};
        mergeSort(nums1);
        System.out.println(Arrays.toString(nums1)); // Expected: [1, 2, 3, 5]

        int[] nums2 = {5, 1, 1, 2, 0, 0};
        mergeSort(nums2);
        System.out.println(Arrays.toString(nums2)); // Expected: [0, 0, 1, 1, 2, 5]
    }
}
