package learn.dynamic;

public class Fibonacci {

    int fib(int N) {
        if(N == 0) return 0;
        if(N == 1 || N == 2) return 1;
        return fib(N - 1) + fib(N - 2);
    }
}