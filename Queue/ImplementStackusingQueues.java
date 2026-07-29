package Queue;
import java.util.*;
class MyStack {

    Queue<Integer> q = new LinkedList<>();

    public MyStack() {
        
    }
    
    public void push(int x) {
        q.add(x);
        
    }
    
    public int pop() {
        int n=q.size();

        for(int i=1; i<=n-1; i++){
            q.add(q.remove());
        }
        return q.remove();
        
    }
    
    public int top() {
        int n=q.size();

        for(int i=1; i<=n-1; i++){
            q.add(q.remove());
        }
        int t= q.peek();
        q.add(q.remove());
        return t;
        
    }
    
    public boolean empty() {

        return (q.size()==0);
        
    }
}


public class ImplementStackusingQueues {
     public static void main(String[] args) {

        MyStack stack = new MyStack();

        stack.push(10);

        stack.push(20);

        stack.push(30);

        System.out.println("Top Element: " + stack.top());     

        System.out.println("Popped: " + stack.pop());           

        System.out.println("Top Element: " + stack.top());      

        stack.push(40);

        System.out.println("Popped: " + stack.pop());         

        System.out.println("Popped: " + stack.pop());           

        System.out.println("Is Empty: " + stack.empty());       

        System.out.println("Popped: " + stack.pop());          

        System.out.println("Is Empty: " + stack.empty());      

    }


    
}
