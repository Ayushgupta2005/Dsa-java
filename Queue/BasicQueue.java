package Queue;

import java.util.*;

public class BasicQueue {

    public static void AddAt(Queue<Integer> q, int idx, int val){
        int n=q.size();

        for(int i=1; i<idx; i++){
            q.add(q.remove());
        }

        q.add(val);
        for(int i=0; i<n-idx+1; i++){
             q.add(q.remove());
        }
    }
    public static void RemoveAt(Queue<Integer> q, int idx){
        int n=q.size();

        for(int i=1; i<idx; i++){
            q.add(q.remove());
        }

        q.remove();
        for(int i=0; i<n-idx+1; i++){
             q.add(q.remove());
        }
    }
    public static void PeekAt(Queue<Integer> q, int idx){
        int n=q.size();

        for(int i=1; i<idx; i++){
            q.add(q.remove());
        }

        System.out.println(q.peek());
        for(int i=0; i<n-idx+1; i++){
             q.add(q.remove());
        }
    }

    public static void reversee(Queue<Integer> q){
        // time complexity O(n)
        // space complexity O(n)

        Stack<Integer> stk = new Stack<>();

        while(q.size()>0){
            stk.push(q.remove());
        }
        while(stk.size()>0){
            q.add(stk.pop());
        }

    }

    //Reverse first k elements in a queue
    public static void reverseEle(Queue<Integer> q, int k){
        int size = q.size();
        if(k==q.size()){
            reversee(q);
            return;
        }
        Queue<Integer> n = new LinkedList<>();

        for(int i=0; i<k; i++){
            n.add(q.remove());
        }
        reversee(n);
        while(n.size()>0){
            q.add(n.remove());
        }

        for(int i=0; i<size-k; i++){
            q.add(q.remove());
        }

    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);

        q.add(40);
        q.add(50);
        System.out.println(q+ " Before reversing");

        reverseEle(q,3);
        System.out.println(q);
    }
    
}
