package Hash_map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class sumOfDistances_2615 {
    public static long[] distance(int[] nums) {
        HashMap<Integer, List<Integer>> hmap = new HashMap<>();
        
        for(int i=0; i<nums.length; i++) {
            
            if(!hmap.containsKey(nums[i]))
                hmap.put(nums[i], new ArrayList<>());
            hmap.get(nums[i]).add(i);
        }

        long[] sol = new long[nums.length];

        for(List<Integer> list : hmap.values()) {

            int freqleft =0;
            int freqright =list.size()-1;

            long left =0;
            long right =0;

            for(int i=0; i<list.size(); i++){
                right = right + list.get(i);
            }

            for(int i=0; i<list.size(); i++){
                right = right - list.get(i);

                long leftsum = ((long)freqleft * list.get(i))-left;
                long rightsum = right - ((long)freqright * list.get(i));
                sol[list.get(i)]=leftsum + rightsum;

                freqleft++;

                freqright--;

                left+=list.get(i);

            }


    }

    return sol;
}

public static void main(String[] args) {
    int nums[] = {1,3,1,1,2};

    long[] sol = distance(nums);

}
}
