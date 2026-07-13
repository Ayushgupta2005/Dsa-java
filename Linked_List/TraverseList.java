package Linked_List;

public class TraverseList {

    public static int gett(Node head, int a){

        Node t = head;

        for(int j=0; j<a; j++){
            t = t.next;
        }

        return t.val;

    }

    public static void display(Node head){

        Node curr = head;

        while(curr!=null){
            System.out.println(curr.val);
            curr =curr.next; 
        }

    }
    public static void main(String[] args) {

        Node a = new Node(10); 
        Node b = new Node(20); 
        Node c = new Node(30);
        Node d = new Node(40); 
        Node e = new Node(50); 
        a.next = b;
        b.next =c;
        c.next =d;
        d.next = e;
        System.out.println(gett(a, 2));
    }
    
}
