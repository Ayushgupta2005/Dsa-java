package Linked_List;

public class Example {
    public static void main(String[] args) {
        
        int a=22;
        if(a%11==0){
            a=a+(a/11);
        }

        System.out.println(a);

        int b = (a%7)*3;
        System.out.println(a-b);
    }
    
}
