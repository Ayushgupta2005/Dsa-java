package Binary_Search;
// fimd the floor square root of x 
// Time complexity: (log n)
public class SqrtOfx {
    public static int mySqrt(int x) {

        int i=0;
        int j=x;

        if(x==1 || x==0){
            return x;
        }

        int sol=0;

        while(i<=j){
            int mid= i+(j-i)/2;
            if((long)mid*mid>x){
                j=mid-1;
            }
            else if((long)mid * mid<=x){
                sol =mid;
                i = mid +1;
            }

        }
        return sol;
        
    }

    public static void main(String[] args) {

        int a=26;
        System.out.println(mySqrt(a));
        
    }
}
    
