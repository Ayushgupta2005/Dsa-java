package Hash_map;

import java.util.HashSet;

public class Commom_Element {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {3, 4, 4, 5, 6};

        HashSet<Integer> set = new HashSet<>();
        for (int x : a) set.add(x);

        HashSet<Integer> common = new HashSet<>();
        for (int x : b) {
            if (set.contains(x)) {
                common.add(x);
            }
        }

        System.out.println(common);
    }
}
