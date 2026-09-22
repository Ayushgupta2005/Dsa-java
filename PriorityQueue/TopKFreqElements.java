package PriorityQueue;

import java.util.*;

class Pair implements Comparable<Pair> {
    int a;
    int b;

    Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int compareTo(Pair p) {
        return this.b - p.b;
    }
}

public class TopKFreqElements {

    public static int[] topKFrequentSorting(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }

        ArrayList<Pair> list = new ArrayList<>();

        for (Integer key : map.keySet()) {
            list.add(new Pair(key, map.get(key)));
        }

        Collections.sort(list);

        int[] ans = new int[k];
        int a = 0;

        for (int i = list.size() - 1; i >= list.size() - k; i--) {
            Pair p = list.get(i);
            ans[a] = p.a;
            a++;
        }

        return ans;
    }

    public static int[] topKFrequentPriorityQueue(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }

        int[] key = new int[map.size()];
        int[] value = new int[map.size()];
        int a = 0;

        for (Integer ke : map.keySet()) {
            key[a] = ke;
            value[a] = map.get(ke);
            a++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < value.length; i++) {
            pq.add(value[i]);

            if (pq.size() > k) {
                pq.remove();
            }
        }

        HashSet<Integer> set = new HashSet<>();

        while (pq.size() > 0) {
            set.add(pq.remove());
        }

        int[] ans = new int[k];
        a = 0;

        for (int i = 0; i < value.length && a < k; i++) {
            if (set.contains(value[i])) {
                ans[a] = key[i];
                a++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        int[] ans1 = topKFrequentSorting(nums, k);

        System.out.println("Sorting Approach:");
        System.out.println(Arrays.toString(ans1));

        int[] ans2 = topKFrequentPriorityQueue(nums, k);

        System.out.println("Priority Queue Approach:");
        System.out.println(Arrays.toString(ans2));
    }
}
