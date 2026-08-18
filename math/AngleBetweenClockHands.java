/*
 * Problem: Angle Between Hands of a Clock (LeetCode 1344)
 *
 * The hour hand sits at 30 degrees per hour PLUS 0.5 per minute; the minute
 * hand at 6 degrees per minute. Their difference simplifies to
 * |30*hour - 5.5*minutes|. Take the smaller of that and its 360 complement.
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */
public class AngleBetweenClockHands {
    public double angleClock(int hour, int minutes) {

        double a=30 * hour;
        double b=5.5*minutes;
        double angle= Math.abs(a-b);
         return Math.min(angle, 360 - angle);

    }

    public static void main(String[] args) {
        AngleBetweenClockHands obj = new AngleBetweenClockHands();
        System.out.println(obj.angleClock(12, 30)); // Expected: 165.0
        System.out.println(obj.angleClock(3, 30));  // Expected: 75.0
        System.out.println(obj.angleClock(1, 57));  // Expected: 76.5
    }
}
