package stacks;
import java.util.Stack;
public class Min_Stack {

    private Stack<Integer> stk;
    private Stack<Integer> minStk;

     public Min_Stack() {
        stk = new Stack<>();
        minStk = new Stack<>();
    }

    // Push element onto the stack
    public void push(int value) {
        if (stk.isEmpty()) {
            stk.push(value);
            minStk.push(value);
        } else {
            stk.push(value);
            minStk.push(Math.min(value, minStk.peek()));
        }
    }

    // Remove the top element
    public void pop() {
        if (!stk.isEmpty()) {
            stk.pop();
            minStk.pop();
        }
    }

    // Return the top element
    public int top() {
        return stk.peek();
    }

    // Return the minimum element
    public int getMin() {
        return minStk.peek();
    }

    public static void main(String[] args) {

        Min_Stack stack = new Min_Stack();

        stack.push(5);
        stack.push(3);
        stack.push(7);
        stack.push(2);

        System.out.println("Top: " + stack.top());         // 2
        System.out.println("Minimum: " + stack.getMin());  // 2

        stack.pop();

        System.out.println("Top: " + stack.top());         // 7
        System.out.println("Minimum: " + stack.getMin());  // 3

        stack.pop();

        System.out.println("Top: " + stack.top());         // 3
        System.out.println("Minimum: " + stack.getMin());  // 3
    }
}
