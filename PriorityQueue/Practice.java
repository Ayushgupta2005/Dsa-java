package PriorityQueue;

import java.util.*;

public class Practice {

    public static void main(String[] args) {

        //Min head
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(10);
        pq.add(20);
        pq.add(30);
        pq.add(5);

        System.out.println(pq.remove());
        System.out.println(pq.peek());


    }
    
}
