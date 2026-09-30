package stacks;

public class MaxDepthAfterSplit {

    public static int[] maxDepthAfterSplit(String seq) {

        int dept = 0;

        int[] ans = new int[seq.length()];

        for (int i = 0; i < seq.length(); i++) {

            if (seq.charAt(i) == '(') {

                dept++;

                if (dept % 2 == 0) {
                    ans[i] = 0;
                }
                else {
                    ans[i] = 1;
                }
            }

            else {

                if (dept % 2 == 0) {
                    ans[i] = 0;
                }
                else {
                    ans[i] = 1;
                }

                dept--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        String seq = "(()())";

        int[] result = maxDepthAfterSplit(seq);

        for (int value : result) {
            System.out.print(value + " ");
        }
    }
}
