package strings;

/*
 * Problem: Partitioning Into Minimum Number Of Deci-Binary Numbers (LeetCode 1689)
 *
 * Each deci-binary number contributes at most 1 to any digit position, so a
 * digit d needs at least d of them. The answer is simply the largest digit
 * in n - that many deci-binary numbers can cover every other position too.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class MinPartitionsDeciBinary {
    public int minPartitions(String n) {

        int i=n.length()-1;
        int ans = 0;

        while(i>=0){
            int a = n.charAt(i)-'0';
            ans = Math.max(a,ans);
            i--;

        }
        return ans;

    }

    public static void main(String[] args) {
        MinPartitionsDeciBinary obj = new MinPartitionsDeciBinary();
        System.out.println(obj.minPartitions("32"));                   // Expected: 3
        System.out.println(obj.minPartitions("82734"));                // Expected: 8
        System.out.println(obj.minPartitions("27346209830709182346")); // Expected: 9
    }
}
