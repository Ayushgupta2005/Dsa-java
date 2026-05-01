package MultiDimentional_Arrays;

import java.util.ArrayList;
import java.util.List;

public class Pascle_Triangle_Leetcode118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> sol = new ArrayList<>();

        if(numRows==1){
            List<List<Integer>> sol1 = new ArrayList<>();
            List<Integer> list1 = new ArrayList<>();
            list1.add(1);
            sol1.add(list1);

            return sol1;
        }
        else if(numRows==2){
            List<List<Integer>> sol2 = new ArrayList<>();
            List<Integer> list1 = new ArrayList<>();
            list1.add(1);
            sol2.add(list1);
            List<Integer> list2 = new ArrayList<>();
            list2.add(1);
            list2.add(1);
            sol2.add(list2);
            return sol2;

        }
        else{
            List<Integer> list1 = new ArrayList<>();
            list1.add(1);
            sol.add(list1);
            List<Integer> list2 = new ArrayList<>();
            list2.add(1);
            list2.add(1);
            sol.add(list2);


        for(int i=2; i<numRows; i++){

            List<Integer> list = new ArrayList<>();
            for(int j=0; j<=i; j++){
                if(j==0 || j==i){
                    list.add(1);
                }
                else{
                    int x=sol.get(i-1).get(j-1) + sol.get(i-1).get(j);
                    list.add(x);
                }



            }
            sol.add(list);
        }
        return sol ;

        
    }
}
}
