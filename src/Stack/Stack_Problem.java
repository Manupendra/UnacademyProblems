package Stack;

import java.util.Stack;

public class Stack_Problem {
    static boolean valid_parathensis(String string){
        Stack<Character> s=new Stack<>();
        for (int i = 0; i < string.length(); i++) {
            char ch=string.charAt(i);
            if(ch=='{'||ch=='('||ch=='['){
                s.push(ch);

            }
            else{
                if(s.isEmpty()) return false;
                if(ch==']'&&s.peek()!='[') return false;
                else if(ch=='}'&&s.peek()!='{') return false;
                else if(ch==')'&&s.peek()!='(') return false;
                else{
                    s.pop();
                }
            }

        }
        return s.empty();
    }
    public static void main(String[] args) {
        System.out.println(valid_parathensis("({[]{}}){}"));
    }
}
