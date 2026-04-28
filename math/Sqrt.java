//  Brutre force approach 

// Time complexity: O(Root(x))
public class Sqrt{
    public int mySqrt(int x) {

        if(x==1){
            return 1;
        }

        int ans =0;

        for(int i=1; i<x; i++){

            if(i*i==x){
                return i;
            }
            else if((long)i*i>x){
                break;
            }
            ans=i;
        }
        return ans;
        
    }
}