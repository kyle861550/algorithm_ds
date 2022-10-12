package standard.recursion;

public class Fibonacci {

    public int fibonacci(int val) {
        if(val == 0) {
            return 0;
        }
        if(val == 2 || val == 1) {
            return 1;
        }
        return fibonacci(val - 1) + fibonacci(val - 2);
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();

        int result = fibonacci.fibonacci(5);

        System.out.println("Fibonacci(5): " + result);
    }
}
