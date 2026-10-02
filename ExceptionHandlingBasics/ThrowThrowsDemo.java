package ExceptionHandlingBasics;

public class ThrowThrowsDemo {

    public static void check(int a) throws Exception{

        if(a<18){
            throw new Exception("Not Eligible");
        }

        System.out.println("Eligible");
    }

    public static void main(String[] args) {

        try{
            check(16);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
