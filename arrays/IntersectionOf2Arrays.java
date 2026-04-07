import java.util.HashSet;

public class IntersectionOf2Arrays {

    public static void main(String[] args) {
        
        int nums1[]= {4,5,9};
        int nums2[]={9,4,9,8,4};
        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<nums1.length; i++){
            set.add(nums1[i]);
        }

        HashSet<Integer> set2 = new HashSet<>();
        for(int j=0; j<nums2.length;j++ ){
            if(set.contains(nums2[j])){
                set2.add(nums2[j]);
            }
        }
        int[] result = new int[set2.size()];
        
        int index = 0;
        for(int val : set2){
            result[index++] = val;


}
for(int l=0; l<result.length ; l++){
    System.out.print(result[l] + " ");
}
    }
    
}
