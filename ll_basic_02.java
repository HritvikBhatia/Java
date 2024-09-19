// LL in collection framework
import java.util.LinkedList;

public class ll_basic_02 {

    public static void main(String[] args) {
        //create
        LinkedList<Integer> ll = new LinkedList<>();
        
        //add       
        ll.addFirst(1);        
        ll.addFirst(3);

        ll.addLast(4);
        ll.addLast(2);
        
        //remove
        ll.removeFirst();
        ll.removeLast();
        
        
        
        //print
        System.out.println(ll);
    }
}