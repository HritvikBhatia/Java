import java.util.*;
public class Queue_question {

    public static void printNonRepeating(String str){
        int frq[] = new int[26];
        Queue<Character> q = new LinkedList<>();

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            q.add(ch);
            frq[ch - 'a']++;

            while(!q.isEmpty() && frq[q.peek() - 'a'] > 1){
                q.remove();
            }

            if(q.isEmpty()){
                System.out.print(-1 + " ");
            }else{
                System.out.print(q.peek() + " ");
            }
        }
        System.out.println();
    }

    public static void interLeave(Queue<Integer> q){
        Queue<Integer> firstHalf = new LinkedList<>();
        int size = q.size();

        for(int i=0; i<size/2; i++){
            firstHalf.add(q.remove());
        }

        while(!firstHalf.isEmpty()){
            q.add(firstHalf.remove());
            q.add(q.remove());
        }

    }

    public static void reverse(Queue<Integer> q){
        Stack<Integer> s = new Stack<>();
        while (!q.isEmpty()) {
            s.push(q.remove());
        }
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
    }

    public static void main(String[] args) {
        
        // // non reapeating 
        // String str = "aabccxb";
        // printNonRepeating(str);

        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=10; i++){
            q.add(i);//1 2 3 4 5 6 7 8 9 10
        }
        
        // /* interLeave
        //  * input -> 12345 6789 10
        //  * output - > 1 6 2 7 3 8 4 9 5 10
        // */
        // interLeave(q);

        // revers a queue 1234 -> 4321
        reverse(q);

        //print
        while (!q.isEmpty()) {
            System.out.print(q.remove()+ " ");
        }
        System.out.println();
    }
}