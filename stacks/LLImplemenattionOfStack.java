package stacks;


class Node{
    int val ;
    Node next;
    
    Node(int val){
        this.val = val;
    }
}


class Sttack{
    Node head;
    int size;


    void push(int a){

        Node temp = new Node(a);
        temp.next = head;
        head = temp;
        size++;
    }

    int peek(){
        if(head == null){
            return -1;
        }
        else{
            return head.val;

        }
    }

    int pop(){
        int a = head.val;
        head = head.next;
        size--;
        return a;
    }
}
public class LLImplemenattionOfStack {
    public static void main(String[] args) {
        

    Sttack s1 = new Sttack();
    s1.push(20);
    s1.push(10);
    System.out.println(s1.peek());
    }
}
