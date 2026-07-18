package stacks;
import java.util.*;

public class Basic {

    public static void printt(Stack<Integer> st){
        Stack<Integer> st2 = new Stack<>();

        while(st.size()>0){
            System.out.println(st.peek());
            st2.push(st.pop());
        }

        while(st2.size()>0){
            st.push(st2.pop());
        }

    }

    public static void getidx(Stack<Integer> st, int idx){
        if(st.size()<=idx){
            System.out.println("Invalid index");
            return;

        }
        Stack<Integer> st2 = new Stack<>();
        
        while(st.size()>idx){
            st2.push(st.pop());
        }

        System.out.println(st.peek());

        while(st2.size()>0){
            st.push(st2.pop());
        }
        return;

    }

    public static void reversee(Stack<Integer> st){

        ArrayList<Integer> list = new ArrayList<>();

        while(st.size()>0){
            list.add(st.pop());
        }

        for(int i=0; i<list.size(); i++){
            st.push(list.get(i));
        }

        return;

    }

    public static void PushAtBottom(Stack<Integer> st ,int ele){

        if(st.size() ==0){
            st.push(ele);
            return;
        }

        int top = st.pop();
        PushAtBottom(st, ele);
        st.push(top);

    }

    public static void main(String[] args) {
        
        Stack<Integer> st = new Stack<>();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);
        System.out.println("Before pushing at bottom "+ st);
        PushAtBottom(st, 5);
        System.out.println(st);


    
}
}
