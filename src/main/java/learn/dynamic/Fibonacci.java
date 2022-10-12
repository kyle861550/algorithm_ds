package learn.dynamic;

public class Fibonacci {

    int step = 0;
    private int fib(int N) {

        System.out.println("Step: " + ++step);
        if(N == 0) return 0;
        if(N == 1 || N == 2) return 1;

        return fib(N - 1) + fib(N - 2);
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();

        System.out.println(fibonacci.fib(5));
    }
}