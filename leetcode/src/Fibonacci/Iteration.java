package Fibonacci;

public class Iteration {
    public int getFibonacci(int i) {
        if (i == 2) {
            return 1;
        }
        if (i == 1) {
            return 1;
        }
        if (i < 1) {
            return 0;
        }
        int a = 1;
        int b = 1;
        for (int j = 3; j <= i; ++j) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {
        Iteration iteration = new Iteration();
        System.out.println(iteration.getFibonacci(-5));
        System.out.println(iteration.getFibonacci(0));
        System.out.println(iteration.getFibonacci(1));
        System.out.println(iteration.getFibonacci(2));
        System.out.println(iteration.getFibonacci(3));
        System.out.println(iteration.getFibonacci(4));
        System.out.println(iteration.getFibonacci(5));
        System.out.println(iteration.getFibonacci(6));
        System.out.println(iteration.getFibonacci(7));
    }
}
