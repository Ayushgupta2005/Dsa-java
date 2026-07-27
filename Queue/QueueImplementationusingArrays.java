package Queue;

class Queu{
        int arr[];
        int size;
        int f;
        int r;

        Queu(int val){
            arr = new int[val];
        }

        void add(int val){

            if(size == arr.length){
                System.out.println("Queue is full");
                return;
            }
            arr[r++]=val;
            if(r==arr.length) r=0;
            size++;
        }

        int peek(){
            if(size==0){
                System.out.println("Queue is empty");
                return -1;
            }

            return arr[f];
        }

        int remove(){
            if(size==0){
                System.out.println("Queue is empty nothing to remove");
                return -1;
            }
            int a= arr[f];

            f++;
            if(f==arr.length) f=0;
            size--;
            return a;
        }

        void print(){
            int ff = f;

            if(size==0){
                System.out.println("Queue is empty baby");
                return;
            }

            for(int i=0; i<size; i++){
                System.out.print(arr[f]+ " ");
                f++;
                if(f==arr.length) f=0;
            }

            f=ff;
        }
    }

public class QueueImplementationusingArrays {
    public static void main(String[] args) {
        Queu q = new Queu(5);
        q.add(10);
        q.add(20);
        q.add(30);
                q.add(30);
                        q.add(30);
                                q.add(30);
        q.remove();
        q.remove();
        q.remove();
           q.print();
           q.add(50);
           q.add(60);
           q.print();

    }

    
}
