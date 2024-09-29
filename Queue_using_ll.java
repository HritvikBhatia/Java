public class Queue_using_ll {
    
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head = null;
    public static Node tail = null;


    static class Queue{
        public boolean isEmpty(){
            return head == null;
        }

        public void add(int data){
            Node newNode = new Node(data);

            if(head == null){
                head = tail = newNode;
                return;
            }

            tail.next = newNode;
            tail = newNode;
        }

        public void remove(){
            if(head == null){
                System.out.println("Queue is empty");
                return;
            }
            if(head == tail){
                head = tail = null;
            }else{
                head = head.next;
            }
        }

        public int peek(){
            if(head == null){
                System.out.println("Queue is empty");
                return -1;
            }
            int first = head.data;
            return first;
        }

    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}