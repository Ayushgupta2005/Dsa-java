package Hash_map;

import java.util.HashMap;

/*
 * Problem: Encode and Decode TinyURL (LeetCode 535)
 *
 * Hand out a fresh incrementing counter as the short key and store
 * key -> longUrl in a map. Uniqueness is guaranteed because the counter
 * never repeats, so decode is a single map lookup.
 *
 * Time Complexity: O(1) for both encode and decode
 * Space Complexity: O(n) for n encoded URLs
 */
public class EncodeAndDecodeTinyURL {
    HashMap<String, String> map = new HashMap<>();
    int count =0;

    public String encode(String longUrl) {
        count++;
        String s = String.valueOf(count);
        map.put(s,longUrl);
        return s;
    }

    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }

    public static void main(String[] args) {
        EncodeAndDecodeTinyURL obj = new EncodeAndDecodeTinyURL();

        String a = obj.encode("https://leetcode.com/problems/design-tinyurl");
        System.out.println(obj.decode(a));
        // Expected: https://leetcode.com/problems/design-tinyurl

        String b = obj.encode("https://example.com/another");
        System.out.println(obj.decode(b));   // Expected: https://example.com/another
        System.out.println(obj.decode(a));   // Expected: original url still intact
        System.out.println(a.equals(b));     // Expected: false (distinct short keys)
    }
}
