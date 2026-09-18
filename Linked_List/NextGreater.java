package Linked_List;

import java.util.*;
public class NextGreater {
    public int[] nextLargerNodes(ListNode head) {

        ArrayList<Integer> list =new ArrayList<>();

        ListNode temp = head;
        while(temp!=null){
            list.add(temp.val);
            temp = temp.next;
        }

        System.out.println(list);
        int ans[] = new int[list.size()];
        int a=ans.length-1;
        ans[a]=0;

        Stack<Integer> stk = new Stack<>();

        stk.push(list.get(a));
        a--;

        while(a>=0){

            int b = list.get(a);

            while(stk.size()>0 && stk.peek()<=b){
                stk.pop();
            }

            if(stk.size()==0){
                ans[a]=0;
            }
            else{
                ans[a]=stk.peek();
            }

            stk.push(b);
            a--;
        }

        return ans;


        
    }
}