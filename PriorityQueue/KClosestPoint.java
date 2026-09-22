package PriorityQueue;

import java.util.*;

class Triplet implements Comparable<Triplet> {
    int dist;
    int x;
    int y;

    Triplet(int dist, int x, int y) {
        this.dist = dist;
        this.x = x;
        this.y = y;
    }

    public int compareTo(Triplet t) {
        return this.dist - t.dist;
    }
}

public class KClosestPoint {

    public static int[][] kClosest(int[][] points, int k) {

        ArrayList<Triplet> list = new ArrayList<>();

        for (int i = 0; i < points.length; i++) {
            int a = points[i][0];
            int b = points[i][1];
            int d = a * a + b * b;

            list.add(new Triplet(d, a, b));
        }

        Collections.sort(list);

        int[][] ans = new int[k][2];

        for (int i = 0; i < k; i++) {
            ans[i][0] = list.get(i).x;
            ans[i][1] = list.get(i).y;
        }

        return ans;
    }

    public static void main(String[] args) {

        int[][] points = {
            {1, 3},
            {-2, 2}
        };

        int k = 1;

        int[][] ans = kClosest(points, k);

        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i][0] + " " + ans[i][1]);
        }
    }
}
