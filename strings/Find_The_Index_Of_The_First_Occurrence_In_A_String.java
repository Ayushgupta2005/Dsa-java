package strings;
/*
LeetCode 28 - Find the Index of the First Occurrence in a String

Status: Accepted (85 / 85 test cases passed)

Time Complexity: O((n - m + 1) * m)
Space Complexity: O(m)
*/
public class Find_The_Index_Of_The_First_Occurrence_In_A_String {

public static int strStr(String haystack, String needle) {

    int n = haystack.length();
    int m = needle.length();

    if (needle.length() == 0) {
        return 0;
    }

    for (int i = 0; i <= n - m; i++) {
        if (haystack.substring(i, i + m).equals(needle)) {
            return i;
        }
    }

    return -1;
}

public static void main(String[] args) {

    String haystack = "sadbutsad";
    String needle = "sad";

    int result = strStr(haystack, needle);

    System.out.println("First Occurrence Index: " + result);
}
    
}
