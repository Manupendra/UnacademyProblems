package Stack_2;

import java.util.Stack;

public class StackClass2 {
    static void nextGreater(int[] a){
        Stack<Integer> nextGreaterEle = new Stack<>();
        for (int i = 0; i < a.length; i++) {
            if(nextGreaterEle.empty()){
                nextGreaterEle.push(a[i]);
            }else if(nextGreaterEle.peek()>a[i]){
                while(nextGreaterEle.peek()>a[i]) {
                    nextGreaterEle.push(a[i]);
                }
            }else if(nextGreaterEle.peek()<a[i]){
                while(nextGreaterEle.peek()<a[i]){
                    System.out.println(nextGreaterEle.pop()+" whose next greater is: "+a[i]);
                }
            }
        }
        while(!nextGreaterEle.isEmpty()){
            System.out.println(nextGreaterEle.pop()+" whose next greater is: -1");
        }
    }

    public static void main(String[] args) {
        nextGreater(new int[]{7,5,4,3,6});
    }
}
