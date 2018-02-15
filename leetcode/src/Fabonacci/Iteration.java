package Fabonacci;

public class Iteration {
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
        System.out.println(iteration.getFabonacci(-5));
        System.out.println(iteration.getFabonacci(0));
        System.out.println(iteration.getFabonacci(1));
        System.out.println(iteration.getFabonacci(2));
        System.out.println(iteration.getFabonacci(3));
        System.out.println(iteration.getFabonacci(4));
        System.out.println(iteration.getFabonacci(5));
        System.out.println(iteration.getFabonacci(6));
        System.out.println(iteration.getFabonacci(7));
    }
}
