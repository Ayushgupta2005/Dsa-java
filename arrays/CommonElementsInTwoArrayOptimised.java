import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CommonElementsInTwoArrayOptimised {

    public static void main(String[] args) {

        int nums1[] = {1,2,2,1};
        int nums2[] = {2,2};
    
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<nums1.length; i++){
            if(map.containsKey(nums1[i])){
                map.put(nums1[i],map.get(nums1[i])+1);
            }
            else{
                map.put(nums1[i],1);
            }
        }


        for(int j=0; j<nums2.length;j++){
            if(map.containsKey(nums2[j])){
                if(map.get(nums2[j])>0){
                    list.add(nums2[j]);

                    map.put(nums2[j], map.get(nums2[j])-1);
                }
            }
        }
        int sol[] = new int[list.size()];

        for(int k=0; k<list.size();k++ ){
            sol[k]=list.get(k);
        }

        for(int m=0; m<sol.length; m++){
            System.out.print(sol[m]+ " ");
        }
    }
    
}
