package Stack_2;

import java.util.Stack;

public class StackClass2 {
    //Time Complexity: O(n)
    //Space complexity: O(n)
    static void nextGreater(int[] a) {
        Stack<Integer> nextGreaterEle = new Stack<>();
        nextGreaterEle.push(a[0]);
        for (int i = 1; i < a.length; i++) {
            int val = a[i];
            if (!nextGreaterEle.isEmpty()) {
                int ele = nextGreaterEle.pop();
                while (ele < val) {
                    System.out.println(ele + " ---->Next Greater Element is " + val);
                    if (nextGreaterEle.isEmpty()) {
                        break;
                    }
                    ele = nextGreaterEle.pop();
                }
                if (ele > val) {
                    nextGreaterEle.push(ele);
                }
            }
            nextGreaterEle.push(val);
        }

        //For Leftover elements in stack
        while (!nextGreaterEle.isEmpty()) {
            int ele = nextGreaterEle.pop();
            int nextGreater = -1;
            System.out.println(ele + " ----> Next Greater Element is " + nextGreater);
        }
    }

    static void evaluatePostFixExpression(String s) {
        Stack<Integer> exp_ans = new Stack<>();
        char ch = ' ';
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                exp_ans.push((s.charAt(i)) - '0');
            } else {
                int val1 = exp_ans.pop();
                int val2 = exp_ans.pop();
                ch = s.charAt(i);
                switch (ch) {
                    case '+':
                        exp_ans.push(val2 + val1);
                        break;

                    case '-':
                        exp_ans.push(val2 - val1);
                        break;

                    case '/':
                        exp_ans.push(val2 / val1);
                        break;

                    case '*':
                        exp_ans.push(val2 * val1);
                        break;
                }

            }
        }
        System.out.println(exp_ans.pop());
    }

    static int[] stockSpan(int[] a) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int output[] = new int[a.length];
        output[0] = 1;
        for (int i = 1; i < a.length; i++) {
            while (!stack.isEmpty() && a[i] > a[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                output[i] = i + 1;
            } else {
                output[i] = i - stack.peek();
            }
            stack.push(i);
        }
        return output;
    }

    public static void main(String[] args) {
        //In this next greater function, Here the ordering is not maintain
        //nextGreater(new int[]{7, 5, 4, 3, 6});

        //evaluatePostFixExpression("123+*8-");

        //Stock Span Problem
        int[] res = stockSpan(new int[]{100, 80, 60, 70, 60, 75, 85});
        for (int val : res) {
            System.out.print(val + " ");
        }
    }
}
