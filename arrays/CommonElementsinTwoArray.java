import java.util.ArrayList;
import java.util.Arrays;

public class CommonElementsinTwoArray {

    public static void main(String[] args) {
        int a[] = {3,6,1,7,9,2,2};
        int b[] ={9,7,3,4,9};
        Arrays.sort(a);
        Arrays.sort(b);
        
        int i=0;
        int j=0;
        
        ArrayList<Integer> list = new ArrayList<>();
        while(i<a.length && j<b.length){
            if(a[i]<b[j]){
                i++;
            }
            else if(a[i]>b[j]){
                j++;
            }
            else{
                list.add(a[i]);
                i++;
                j++;
            }
        }

        for(int k=0; k<list.size(); k++){
            System.out.print(list.get(k)+ " ");
        }
    }
    
}
