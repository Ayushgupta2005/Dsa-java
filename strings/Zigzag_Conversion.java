package strings;

public class Zigzag_Conversion {
    /*
LeetCode 6 - Zigzag Conversion

Status: Accepted

Time Complexity: O(n)
Space Complexity: O(n)

Approach:
- Create a StringBuilder for each row.
- Traverse the string in a zigzag manner:
  1. Move vertically down through all rows.
  2. Move diagonally up through the middle rows.
*/

public static String convert(String s, int numRows) {

    if (numRows == 1) {
        return s;
    }

    StringBuilder[] ans = new StringBuilder[numRows];

    for (int i = 0; i < numRows; i++) {
        ans[i] = new StringBuilder();
    }

    int i = 0;

    while (i < s.length()) {

        for (int idx = 0; idx < numRows && i < s.length(); idx++) {
            ans[idx].append(s.charAt(i));
            i++;
        }

        for (int idx = numRows - 2; idx > 0 && i < s.length(); idx--) {
            ans[idx].append(s.charAt(i));
            i++;
        }
    }

    StringBuilder sol = new StringBuilder();

    for (int k = 0; k < ans.length; k++) {
        sol.append(ans[k]);
    }

    return sol.toString();
}

public static void main(String[] args) {

    String s = "PAYPALISHIRING";
    int numRows = 3;

    String result = convert(s, numRows);

    System.out.println("Zigzag Conversion: " + result);
}
    
}
