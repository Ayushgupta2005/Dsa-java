package Linked_List;

class Node{
    int val;
    Node next;

    Node(int val){
        this.val = val;
    }
}

class Linklist{
    Node head;
    Node tail;
    int size;

    void addAtTail(int a){

        Node n = new Node(a);
        if(head==null){
            head = tail = n;
            size++;
        }
        else{
            tail.next = n;
            tail = n;
            size++;

        }
    }

    void display(){
        Node n = head;
        while(n!=null){
            System.out.print(n.val+ " ");
            n=n.next;
        }
        System.out.println("size is " + size);
    }

    void addAtfront(int a){
        Node n = new Node(a);
        if(head==null){
            head = tail = n;
            size++;
        }
        else{
            n.next = head;
            head = n;
            size++;
        }

    }

    void deleteAthead(){
        if(head==null){
            System.out.println("already empty");
        }
        else{
            if(head.next==null){
                tail = null;
            }
            head = head.next;
            size--;
         
        }

    }

    int searchh(int a){
        int idx =0;
        if(head==null){
            return -1;
        }
        Node temp = head;
        while(temp!=null){
            if(temp.val == a){
                return idx;
            }
            idx++;
                temp = temp.next;
        }
        return -1;
        
    }

    int get(int idx){
        if(head ==null){
            return -1;
        }
        Node temp = head;
        int i=0;

        while(i<idx){
            temp = temp.next;
            if(temp==null){
                return -1;
            }
            i++;
        }

        return temp.val;
    }



    void addAtindex(int idx, int val){
        if(head == null || idx>size) return;
        if(idx==0){
            addAtfront(val);
            return;
        }
        if(idx == size){
            addAtTail(val);
            return;
        }

        Node temp = head;

        for(int i=1; i<idx; i++){
            temp = temp.next;
        }

        Node n = new Node(val);
        n.next = temp.next;
        temp.next = n;
        size++;
    }

    void delete(int index){

        if(index>=size){
            return;

        }
        if(size == 0){
            return;
        }

        if(size==1 && index ==0){
            head = tail = null;
            size--;
            return;
        }

        if(index==0){
            deleteAthead();
            return;
        }

        Node temp = head;

        for(int i=1; i<index; i++){
            temp = temp.next;
        }
     
        temp.next =temp.next.next;
           if(index+1 ==size){
            tail = temp;
            
        }
        size--;
        return; 
    }
}

public class StudyingLinkedList {
    public static void main(String[] args) {
        
        Linklist l1 = new Linklist();
        System.out.println(l1.tail);
        l1.addAtTail(20);
        l1.addAtTail(30); // 15 10 20 30 400 %          
        l1.addAtTail(40);

        l1.display();

    }
    
}
