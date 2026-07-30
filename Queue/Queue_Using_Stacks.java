package Queue;

import java.util.Stack;

class MyQueue {

    Stack<Integer> stk = new Stack<>();
    int size;

    public MyQueue() {
    }
    
    public void push(int x) {

        if(size==0){
            stk.push(x);
            size++;
            return;
        }

        Stack<Integer> stk2 = new Stack<>();

        while(stk.size()>0){
            stk2.push(stk.pop());
        }

        stk.push(x);

        while(stk2.size()>0){
            stk.push(stk2.pop());
        }
        size++;
    }
    
    public int pop() {

        size--;
        return stk.pop();
        
    }
    
    public int peek() {
        return stk.peek();
        
    }
    
    public boolean empty() {
        if(size==0){
            return true;
        }
        return false;
        
    }
}


public class Queue_Using_Stacks {
    
    
}
