package oop.interpreter;

public class CalMain {

    public static void main(String[] args) {
        Calculation calculation = new Calculation("1 + 2 + 3 + 5 - 10");

        System.out.println("Calculation result: " + calculation.getResult());
    }

}