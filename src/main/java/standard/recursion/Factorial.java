package standard.recursion;

public class Factorial {

    public int factorial(int val) {
        if(val == 1) {
            return 1;
        }
        return val * factorial(val - 1);
    }

    public static void main(String[] args) {
        Factorial factorial = new Factorial();

        int result = factorial.factorial(5);

        System.out.println("5!: " + result);
    }
}
