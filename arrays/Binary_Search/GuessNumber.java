package arrays.Binary_Search;

public class GuessNumber {

    static int pickedNumber = 6;

    public static int guess(int num) {

        if (num > pickedNumber) {
            return -1;
        }

        else if (num < pickedNumber) {
            return 1;
        }

        return 0;
    }

    public static int guessNumber(int n) {

        int left = 0;
        int right = n;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (guess(mid) == 0) {
                return mid;
            }

            else if (guess(mid) == -1) {
                right = mid - 1;
            }

            else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int n = 10;

        int result = guessNumber(n);

        System.out.println("Picked number: " + pickedNumber);
        System.out.println("Found number: " + result);
    }
}