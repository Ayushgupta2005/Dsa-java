package Hash_map;

import java.util.HashMap;

public class Fibonacci {
    public int fib(int n) {

        if(n==0 || n==1){
            return n;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,0);
        map.put(1,1);
        for(int i=2; i<=n;i++){
            int a = map.get(i-1) + map.get(i-2);
            map.put(i,a);
        }

        return map.get(n);
        
    }
}
    
