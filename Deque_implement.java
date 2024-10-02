import java.util.*;

public class Deque_implement {

    static class Stack{
        Deque<Integer> deque = new LinkedList<>();

        public void push(int data){
            deque.addLast(data);
        }
        public int pop(){
            return deque.removeLast();
        }
        public int peek(){
            return deque.getLast();
        }
    }

    static class Queue{
        Deque<Integer> deque = new LinkedList<>();

        public void push(int data){
            deque.addLast(data);
        }
        public int pop(){
            return deque.removeFirst();
        }
        public int peek(){
            return deque.getFirst();
        }
    }

    public static void main(String[] args) {
        // Stack s = new Stack();
        // s.push(1);
        // s.push(2);
        // s.push(3);

        // Queue q = new Queue();
        // q.push(1);
        // q.push(2);
        // q.push(3);
        
    }
}