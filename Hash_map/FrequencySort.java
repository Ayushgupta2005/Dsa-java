package Hash_map;

import java.util.HashMap;

/*
 * Problem: Sort Characters By Frequency (LeetCode 451)
 * Time Complexity: O(n + k^2)  k = number of distinct characters
 * Space Complexity: O(n)
 */
public class FrequencySort {

    public static void addd(int max, char ch,StringBuilder str){
        for(int i=0; i<max; i++){
            str.append(ch);
        }

    }
    public String frequencySort(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),1);
            }
            else{
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }

        }
        StringBuilder str = new StringBuilder();

        while(map.size()>0){

            int max=0;
            char ch='a';
            for(Character key: map.keySet()){
                if(map.get(key)>max){
                    max = map.get(key);
                    ch = key;
                }
            }
            addd(max,ch,str);
            map.remove(ch);
        }

        return str.toString();

    }

    public static void main(String[] args) {
        FrequencySort obj = new FrequencySort();
        System.out.println(obj.frequencySort("tree"));   
        System.out.println(obj.frequencySort("cccaaa")); 
        System.out.println(obj.frequencySort("Aabb"));  
    }
}
