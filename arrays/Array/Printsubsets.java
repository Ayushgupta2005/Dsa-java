
import java.util.ArrayList;
import java.util.Collections;
public class Printsubsets {

    public static void printt(String ans, String str, int index, ArrayList<String> list){

        if(index==str.length()){
            list.add(ans);
            return;
        }

        printt(ans+str.charAt(index),str,index+1,list); // pick 
        printt(ans,str,index+1,list); //drop

    }
    public static void main(String[] args) {
        
        String str = "abc";
        ArrayList<String> list = new ArrayList<>();
        printt("",str,0, list);

        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i)+" ");

        }
    }


    
}
