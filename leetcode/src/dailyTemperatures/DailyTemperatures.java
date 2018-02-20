package dailyTemperatures;

import java.util.Stack;

public class DailyTemperatures {
    // Fast 10+ ms
    public int[] dailyTemperatures(int[] temperatures) {
        int[] stack = new int[temperatures.length];
        int[] res = new int[temperatures.length];
        int top = -1;
        for (int i  = 0; i < temperatures.length; ++i) {
            while(top > -1 && temperatures[i] > temperatures[stack[top]]) {
                int idx = stack[top--];
                res[idx] = i - idx;
            }
            stack[++top] = i;
        }
        return res;
    }

    // 50+ ms
/*    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for (int i  = 0; i < temperatures.length; ++i) {
            while(!stack.empty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                res[idx] = i - idx;
            }
            stack.push(i);
        }
        return res;
    }*/

    public static void main(String[] args) {
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        int[] temperatures = new int[]{79, 78, 67, 56, 89, 90, 104, 78, 76, 89, 87};
        int[] res = dailyTemperatures.dailyTemperatures(temperatures);
        for (int r : res) {
            System.out.println(r);
        }
    }
}
