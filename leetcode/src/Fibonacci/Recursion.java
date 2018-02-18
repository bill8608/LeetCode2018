package Fibonacci;

public class Recursion {
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
        return getFibonacci(i - 1) + getFibonacci(i - 2);
    }

    public static void main(String[] args) {
        Recursion recursion = new Recursion();
        System.out.println(recursion.getFibonacci(-5));
        System.out.println(recursion.getFibonacci(0));
        System.out.println(recursion.getFibonacci(1));
        System.out.println(recursion.getFibonacci(2));
        System.out.println(recursion.getFibonacci(3));
        System.out.println(recursion.getFibonacci(4));
        System.out.println(recursion.getFibonacci(5));
        System.out.println(recursion.getFibonacci(6));
        System.out.println(recursion.getFibonacci(7));
    }
}
