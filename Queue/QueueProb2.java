package Queue;
import java.util.LinkedList;
import java.util.Queue;

public class QueueProb2 {

public class CountStudentsUnableToEatLunch {

    public static int countStudents(int[] students, int[] sandwiches) {

        Queue<Integer> stu = new LinkedList<>();
        Queue<Integer> san = new LinkedList<>();

        // Add students to the queue
        for (int student : students) {
            stu.add(student);
        }

        // Add sandwiches to the queue
        for (int sandwich : sandwiches) {
            san.add(sandwich);
        }

        while (!stu.isEmpty()) {

            int count = 0;

            if (stu.peek().equals(san.peek())) {
                stu.remove();
                san.remove();
            } else {

                while (!stu.peek().equals(san.peek())) {

                    count++;
                    stu.add(stu.remove());

                    if (count == stu.size()) {
                        return stu.size();
                    }
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {

        int[] students = {1, 1, 0, 0};
        int[] sandwiches = {0, 1, 0, 1};

        int result = countStudents(students, sandwiches);

        System.out.println("Students unable to eat: " + result);
    }
}
    
}
