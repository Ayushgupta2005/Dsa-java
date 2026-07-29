package Queue;
    import java.util.LinkedList;
import java.util.Queue;
public class RearrangeQueue {

    public static void rearrangeQueue(Queue<Integer> q) {

        Queue<Integer> firstHalf = new LinkedList<>();
        Queue<Integer> secondHalf = new LinkedList<>();

        int size = q.size() / 2;

        // Store first half
        for (int i = 0; i < size; i++) {
            firstHalf.add(q.remove());
        }

        // Store second half
        while (!q.isEmpty()) {
            secondHalf.add(q.remove());
        }

        // Rearrange the queue
        for (int i = 0; i < size; i++) {
            q.add(firstHalf.remove());
            q.add(secondHalf.remove());
        }
    }

    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);

        System.out.println("Original Queue: " + queue);

        rearrangeQueue(queue);

        System.out.println("Rearranged Queue: " + queue);
    }
}
