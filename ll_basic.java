public class ll_basic {

    public static class Node{
        int data;
        Node next; // The data type of next is Node because it is pointing to a another Node
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public int size;

    // # steps to insert/add first 
    //  1 create a new Node 
    //  2 new Node next = head
    //  3 head = new Node

    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        
        if(head == null){
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    // # insert/add last
    //  1 create a new node
    //  2 tail.next = new Node
    //  3 tail = new Node

    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        
        if(head == null){
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    // # print a LinkedList
    //  1 create temp node = head
    //  2 print temp.data 
    //  3 temp = temp.next till temp!=null

    public void printLL(){
        if(head == null){
            System.out.println("Linklist is empty");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    // # insert/add in the middle
    //  1 we need the index and the data
    //  2 create temp = head
    //  3 i=0 till i< index-1 i++
    //  4 temp = temp.next
    //  5 newNode.next = temp.next
    // `6 temp.next = newNode

    public void addMid(int index,int data){
        if(index == 0){
            addFirst(data);
            return; 
        }
        Node newNode = new Node(data);
        size++;

        Node temp = head;
        int i = 0;
        while(i < index -1){
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public static void main(String[] args) {
        ll_basic ll = new ll_basic();
        
        ll.addFirst(2); 
        ll.addFirst(1);
        ll.addLast(4);
        ll.addLast(5);
        ll.addMid(2, 3);
        
        ll.printLL();
        System.out.println(ll.size);

    }
}