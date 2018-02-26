package Stack;

import java.util.Stack;

public class MaxStack {
    Stack<Integer> maxStack;
    Stack<Integer> stack;
    /** initialize your data structure here. */
    public MaxStack() {
        maxStack = new Stack<>();
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            maxStack.push(x);
        } else {
            if (x > maxStack.peek()) {
                maxStack.push(x);
            } else {
                maxStack.push(maxStack.peek());
            }
            stack.push(x);
        }
    }

    public int pop() {
        if (stack.isEmpty()) {
            return Integer.MAX_VALUE;
        }
        maxStack.pop();
        return stack.pop();
    }

    public int top() {
        if (stack.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return stack.peek();
        }
    }

    public int peekMax() {
        if (maxStack.isEmpty()) {
            return Integer.MAX_VALUE;
        }
        return maxStack.peek();
    }

    public int popMax() {
        Stack<Integer> tmpStack = new Stack<>();
        int max = maxStack.peek();
        while (!stack.isEmpty()) {
            int tmp = stack.pop();
            maxStack.pop();
            if (tmp == max) {
                break;
            }
            tmpStack.push(tmp);
        }
        while (!tmpStack.isEmpty()) {
            push(tmpStack.pop());
        }
        return max;
    }

    public static void main(String[] args) {
        MaxStack obj = new MaxStack();
        obj.push(5);
        obj.push(1);
        obj.push(3);
        System.out.println(obj.top() == 3);
        System.out.println(obj.peekMax() == 5);
        System.out.println(obj.pop() == 3);
        System.out.println(obj.popMax() == 5);
        System.out.println(obj.peekMax() == 1);
        System.out.println(obj.top() == 1);
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
