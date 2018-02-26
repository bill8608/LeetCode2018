package Stack;

import java.util.Stack;

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            int currMin = minStack.peek();
            if (currMin < x) minStack.push(currMin);
            else minStack.push(x);
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        stack.pop();
        minStack.pop();
    }

    public int top() {
        if (stack.isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return stack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            return Integer.MAX_VALUE;
        }
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(5);
        obj.push(1);
        obj.push(3);
        System.out.println(obj.top() == 3);
        System.out.println(obj.getMin() == 1);
        obj.pop();
        System.out.println(obj.getMin() == 1);
        obj.pop();
        System.out.println(obj.top() == 5);
        System.out.println(obj.getMin() == 5);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
