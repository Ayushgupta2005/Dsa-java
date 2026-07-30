package Queue;

    import java.util.LinkedList;
import java.util.Queue;

public class Q1 {

    public static int findTheWinner(int n, int k) {

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while (queue.size() > 1) {

            for (int i = 0; i < k - 1; i++) {
                queue.add(queue.remove());
            }

            queue.remove();
        }

        return queue.peek();
    }

    public static void main(String[] args) {

        int n = 5;
        int k = 2;

        int winner = findTheWinner(n, k);

        System.out.println(winner);
    }
}
    
