package ExceptionHandlingBasics;
import java.io.*;

public class CheckedExpection {

    public static void main(String[] args) {

        try{

        FileReader file = new FileReader("ayush.txt");
        System.out.println("File successfully read");
        }
        catch (FileNotFoundException a){
            System.out.println("File not found");

        }
        finally{
            System.out.println("Finally block which always prints");
        }


        System.out.println("Rest of the code");
    }
}
