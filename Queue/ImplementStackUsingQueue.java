package Queue;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    Queue<Integer> q = new LinkedList<>();

    public MyStack() {

    }

    public void push(int x) {

        q.add(x);

        int size = q.size();

        for (int i = 0; i < size - 1; i++) {
            q.add(q.remove());
        }
    }

    public int pop() {
        return q.remove();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}

public class ImplementStackUsingQueue {

    public static void main(String[] args) {

        MyStack stack = new MyStack();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top Element: " + stack.top());      // 30
        System.out.println("Popped: " + stack.pop());           // 30

        stack.push(40);

        System.out.println("Top Element: " + stack.top());      // 40
        System.out.println("Popped: " + stack.pop());           // 40
        System.out.println("Popped: " + stack.pop());           // 20
        System.out.println("Popped: " + stack.pop());           // 10

        System.out.println("Is Empty: " + stack.empty());       // true
    }
}