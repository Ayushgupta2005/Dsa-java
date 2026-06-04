public class Leetcode_2706 {
    public static int buyChoco(int[] prices, int money) {
        int min = 100;
        int smin = 100;

        for (int price : prices) {
            if (price < min) {
                smin = min;
                min = price;
            } else if (price < smin) {
                smin = price;
            }
        }

        int remaining = money - (min + smin);

        return remaining >= 0 ? remaining : money;
    }

    public static void main(String[] args) {
        
        int arr[] = {1,2,2};

        System.out.println(buyChoco(arr, 3));

    }
}

