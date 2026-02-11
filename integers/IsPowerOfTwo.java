package integers;

public class IsPowerOfTwo {

    public static void main(String[] args) {
        int a =60;

        while(a%2==0){
            a=a/2;
        }
        if (a==1){
            System.out.println("true"); // Time complexity: O(1)
        }
        else{
        System.out.println("false");
        }
    }


    
}
