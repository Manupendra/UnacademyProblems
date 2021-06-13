package Queues;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

//Queue - enqueue and dequeue operations
class QueueUsingStack {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    //enqueue operation
    void enqueue(int x) {

        while (!s1.isEmpty()) {
            //Copy the all the elements from s1 to s2
            int ele = s1.pop();
            s2.push(ele);
        }

        //add the new element add to s1
        s1.push(x);

        //Again copy the elements to s1 from s2
        while (!s2.isEmpty()) {
            //Copy the all the elements from s1 to s2
            int ele = s2.pop();
            s1.push(ele);
        }

    }

    //dequeue operation
    void dequeue() {
        s1.pop();
    }

    void printElementsInQueue() {
        Stack<Integer> printStack = s1;
        while (!printStack.isEmpty()) {
            System.out.print(printStack.pop() + " ");
        }
    }

}

public class QueueImplementationUsingStack {

    //Sliding Problem
    static void slidingWindow(int[] a, int k) {

        Deque<Integer> d = new LinkedList<>();
        int i;
        //Till the size of Window
        for ( i = 0; i < k; i++) {

            while (!d.isEmpty() && a[i]>=a[d.peekLast()])
                d.removeLast();
            d.addLast(i);
        }

        //For Upcoming Windows
        for (; i <a.length ; i++) {
            System.out.print(a[d.peek()]+" ");
            //For out of range elements
            while(!d.isEmpty() && d.peek()<=i-k)
                d.removeFirst();
            while(!d.isEmpty() && a[i]>=a[d.peekLast()])
                d.removeLast();
            d.addLast(i);
        }

        System.out.print(a[d.peek()]+" ");

    }


    public static void main(String[] args) {
        /*QueueUsingStack s = new QueueUsingStack();
        s.enqueue(10);
        s.enqueue(20);
        //s.printElementsInQueue();
        s.dequeue();
        s.enqueue(3);
        s.printElementsInQueue();*/
        slidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);
    }
}
