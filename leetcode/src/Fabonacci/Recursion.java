package Fabonacci;

public class Recursion {
    public int getFabonacci(int i) {
        if (i == 2) {
            return 1;
        }
        if (i == 1) {
            return 1;
        }
        if (i < 1) {
            return 0;
        }
        return getFabonacci(i - 1) + getFabonacci(i - 2);
    }

    public static void main(String[] args) {
        Recursion recursion = new Recursion();
        System.out.println(recursion.getFabonacci(-5));
        System.out.println(recursion.getFabonacci(0));
        System.out.println(recursion.getFabonacci(1));
        System.out.println(recursion.getFabonacci(2));
        System.out.println(recursion.getFabonacci(3));
        System.out.println(recursion.getFabonacci(4));
        System.out.println(recursion.getFabonacci(5));
        System.out.println(recursion.getFabonacci(6));
        System.out.println(recursion.getFabonacci(7));
    }
}
