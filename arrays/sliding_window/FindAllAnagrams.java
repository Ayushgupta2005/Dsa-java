package sliding_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * Problem: Find All Anagrams in a String (LeetCode 438)
 * Time Complexity: O(n + m)
 * Space Complexity: O(1)  (at most 26 keys per map)
 */
public class FindAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> list = new ArrayList<>();
        int a=s.length();
        int b=p.length();
        if(a<b){
            return list;

        }

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i<b; i++){
            if(!map.containsKey(p.charAt(i))){
                map.put(p.charAt(i), 1);
            }else{
                map.put(p.charAt(i), map.get(p.charAt(i))+1);
            }

        }
        HashMap<Character, Integer> map2 = new HashMap<>();

        for(int i=0; i<b; i++){
            if(!map2.containsKey(s.charAt(i))){
                map2.put(s.charAt(i), 1);
            }else{
                map2.put(s.charAt(i), map2.get(s.charAt(i))+1);
            }

        }
        if(map.equals(map2)){
            list.add(0);
        }

        for(int i=b; i<s.length(); i++){
            if(!map2.containsKey(s.charAt(i))){
                map2.put(s.charAt(i),1);
            }
            else{
                map2.put(s.charAt(i), map2.get(s.charAt(i))+1);
            }

            if(map2.get(s.charAt(i-b))==1){
                map2.remove(s.charAt(i-b));
            }
            else{
                map2.put(s.charAt(i-b), map2.get(s.charAt(i-b))-1);
            }

            if(map.equals(map2)){
                list.add(i-b+1);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        FindAllAnagrams obj = new FindAllAnagrams();
        System.out.println(obj.findAnagrams("cbaebabacd", "abc")); 
        System.out.println(obj.findAnagrams("abab", "ab"));        
    }
}
