/*
 * Problem: Minimum Bishop Moves on a Chessboard
 * (source unconfirmed - no verified LeetCode ID found for this signature)
 *
 * A bishop only ever reaches squares of the same color, so if (sr+sc) and
 * (tr+tc) have different parity, the target is unreachable (-1). If source
 * and target share a diagonal (same r-c, the "\" diagonal) or anti-diagonal
 * (same r+c, the "/" diagonal), one move suffices. Otherwise, on a board
 * large enough, any same-colored square is reachable in exactly 2 moves.
 *
 * NOTE: when source == target this returns 1, not 0, since the trivial
 * case satisfies sr-sc == tr-tc. Only matters if the problem allows
 * source == target as input.
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */
public class MinimumBishopMoves {
    public int minBishopMoves(int[] source, int[] target) {

        int sr = source[0];
        int sc = source[1];

        int tr = target[0];
        int tc = target[1];


        if ((sr + sc) % 2 != (tr + tc) % 2) {
            return -1;
        }

        if (sr - sc == tr - tc || sr + sc == tr + tc) {
            return 1;
        }

        return 2;
    }

    public static void main(String[] args) {
        MinimumBishopMoves obj = new MinimumBishopMoves();
        System.out.println(obj.minBishopMoves(new int[]{0,0}, new int[]{3,3})); // same diagonal -> 1
        System.out.println(obj.minBishopMoves(new int[]{0,4}, new int[]{4,0})); // same anti-diagonal -> 1
        System.out.println(obj.minBishopMoves(new int[]{0,0}, new int[]{0,1})); // different color -> -1
        System.out.println(obj.minBishopMoves(new int[]{0,0}, new int[]{2,4})); // same color, no shared diagonal -> 2
    }
}
