package oop.builder.simple_builder;

public class RunComputer {

    public static void main(String[] args) {

        Director director = new Director(new Asus());

        director.getAsusComputer_Normal().print();

        System.out.println("-----------------------------------------");

        director.getAsusComputer_Top().print();
    }

}
