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

    // # delete/remove first 
    //  1 head = head.next 

    public int removeFirst(){
        if(size == 0){
            System.out.println("Linked list is empty");
            return Integer.MIN_VALUE;
        }else if(size == 1){
            int data = head.data;
            head = tail = null;
            size = 0;
            return data;
        }
        int data = head.data;
        head = head.next;
        size--;
        return data;
    }

    // # delete/remove last 
    //  1 we have to go till last 2nd node then i<size-1
    //  2 prev.next = null
    //  3 tail = prev

    public int removeLast(){
        if(size == 0){
            System.out.println("Linked list is empty");
            return Integer.MIN_VALUE;
        }else if(size == 1){
            int data = head.data;
            head = tail = null;
            size = 0;
            return data;
        }
        int data = tail.data;
        Node prev = head;
        while(prev.next != tail){
            prev = prev.next;
        }
        prev.next = null;
        tail = prev;
        size--;
        return data;
    }

    //# iterative search
    // 1 temp = head
    // 2 while temp!=null
    // 3 if key == temp.data return index 
    // 4 else temp = temp.next 
    
    public int LinearSearch(int key)
    {
        Node temp = head;
        int i = 0;
        while(temp != null){
            if(temp.data == key){
                return i;
            }
            temp = temp.next;
            i++;
        }
        System.out.println("Key not found");
        return -1;
    }
 
    /* reverse a Linked List 
     * consist of 3 variable and 4 step
     * curr = head , prev = next = null
     *  1 next = curr.next
     *  2 curr.next = prev
     *  3 prev = curr
     *  4 curr = next
     * tail = head
     * head = prev 
    */

    public void reverseLL(){
        Node curr = tail = head;
        Node prev = null;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    } 

    public void deleteNthFromEnd(int index){
        int sz = 0; //first we check total size
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            sz++;
        }

        if(index == sz){// we have to remove head
            head = head.next; // remove First
            return;
        }

        //sz-index
        int i = 1;
        int prevOfIndex = sz - index;
        Node prev = head;
        if(i < prevOfIndex){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }

    public Node findMid(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /* check for palindrome
     * 1 find mid
     * 2 reverse the second half
     * 3 check if LHS = RHS 
    */

    public boolean checkPalindrome(){
        if(head == null || head.next == null){
            return true;
        }
        // step 1
        Node midNode = findMid(head);

        //step 2
        Node currNode = midNode;
        Node prev = null;
        Node next;

        while(currNode != null){
            next = currNode.next;
            currNode.next = prev;
            prev = currNode;
            currNode = next;
        }
        Node RHShead = prev;
        Node LHShead = head;

        //step 3
        while (RHShead != null) {
            if(RHShead.data != LHShead.data){
                return false;
            }
            RHShead = RHShead.next;
            LHShead = LHShead.next;
        }
        return true;

    }

    public boolean isCycle(){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
  
    /* remove cycle
     * 1 check iscycle
     * 2 find meeting point
     * 3 remove cycle -> last.next = null
    */

    public static void removeCycle(){
        //1
        Node slow = head;
        Node fast = head;
        Boolean cycle = false;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                cycle = true;
                break;
            }
        }
        if(cycle == false){
            return;
        }

        //2 
        slow = head;
        Node prev = null;
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        //3 
        prev.next = null;
    }

    public static void main(String[] args) {
        ll_basic ll = new ll_basic();
        
        ll.addFirst(2); 
        ll.addFirst(1);

        ll.addLast(4);
        ll.addLast(5);
        
        ll.addMid(2, 3);
        
        ll.removeFirst(); //1
        ll.removeLast(); //5
        
        System.out.print("LL: ");
        ll.printLL(); // 2 3 4
        
        System.out.println("size of LL is: "+ll.size); // 3
        
        System.out.println("index of key is: "+ ll.LinearSearch(4));
        
        ll.reverseLL();
        System.out.print("Reverse LL: ");
        ll.printLL(); //4 3 2
        
        ll.deleteNthFromEnd(2);
        System.out.print("LL: ");
        ll.printLL(); // 4 2 
        
        System.out.println("Palindrome: "+ ll.checkPalindrome());
    }
}