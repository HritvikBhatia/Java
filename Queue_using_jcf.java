import java.util.LinkedList;
import java.util.Queue;

public class Queue_using_jcf {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();//or Arraydeque
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