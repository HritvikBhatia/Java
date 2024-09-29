import java.util.Stack;

public class Stack_using_jcf {

    public static void pushatBottom(Stack<Integer> s,int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }

        int top = s.pop();
        pushatBottom(s, data);
        s.push(top);
    }

    public static void reverseStack(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }

        int top = s.pop();
        reverseStack(s);
        pushatBottom(s, top);
    }

    public static void printS(Stack<Integer> s){
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

    public static String reverseString(String str){
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while(idx < str.length()){
            s.push(str.charAt(idx));
            idx++;
        }

        StringBuilder result = new StringBuilder();
        while (!s.isEmpty()) {
            char curr = s.pop();
            result.append(curr);
        }

        return result.toString();
    }

    public static boolean isValid(String str){
        Stack<Character> s = new Stack<>();
        
        for(int i=0; i<str.length(); i++ ){
            char ch = str.charAt(i);

            //opening
            if(ch=='(' || ch =='{' || ch=='[' || ch=='<'){
                s.push(ch);
            }else{
                //closing 
                if(s.isEmpty()){
                    return false;
                }
                if(s.peek() == '(' && ch==')'
                    || s.peek() == '{' && ch=='}'
                    || s.peek() == '[' && ch==']'
                    || s.peek() == '<' && ch=='>'){
                        s.pop();
                }else{
                    return false;
                }
            }
        }
        if(s.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    public static boolean isDuplicate(String str){
        Stack<Character> s = new Stack<>();
        for(int i=0; i<str.length(); i++ ){
            char ch = str.charAt(i);
            if(ch == ')'){
                int count = 0;
                while(s.peek() != '('){
                    s.pop();
                    count++; 
                }
                if(count < 1){
                    return true; 
                }else{
                    s.pop(); //opening pair

                }
            }else{
                s.push(ch);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);   
        s.push(2);   
        s.push(3);   
        s.push(4);
        
        // pushatBottom(s, 5);
        reverseStack(s);

        printS(s);

        // //reverse a string
        // String str = "abcd";
        // System.out.println(reverseString(str));

        // //parentheses validation
        // String str1 = "({})[]";
        // System.out.println(isValid(str1)); 
        
        // duplicate parentheses
        String str2 = "((a+b))"; //true
        String str3 = "(a-b)";//false
        System.out.println(isDuplicate(str2));
        System.out.println(isDuplicate(str3));
    }
}