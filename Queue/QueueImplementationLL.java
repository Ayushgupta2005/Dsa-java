package Queue;

class Node{
    int val;
    Node next;

    Node(int val){
        this.val = val;

    }
}

class Queuee{
    Node head;
    Node tail;
    int size;

    int peek(){
        if(head==null){
            System.out.println("Queue is empty");
            return -1;
        }
        return head.val;
    }

    int size(){
        return size;
    }

    int remove(){
        if(head==null){
            System.out.println("Queue is empty");
            return -1;
        }
        else{
            int a = head.val;
            head=head.next;
            size--;
            return a;
        }
    }

    void add(int val){
        Node temp = new Node(val);
        if(head==null){
        head= tail = temp;
        size++;
        return;}

        tail.next=temp;
        tail=tail.next;
        tail.next = null;
        size++;

    }

    void print(){
        if(head==null){
            System.out.println("Queue is empty");
            return;
        }
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.val+ " ");
            temp=temp.next;
        }
        System.out.println();

    }
}


public class QueueImplementationLL {
    public static void main(String[] args) {
        Queuee q1 = new Queuee();
        q1.add(10);
        q1.add(20);
        q1.add(30);
        q1.add(40);
        System.out.println(q1.size());
    }
    
}
