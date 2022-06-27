package oop.builder.simple_builder;

public class BuilderClass {

    public static void main(String[] args) {
        ComputerBuilder<Computer> computerBuilder = new Asus().
                setPower(550).
                setCPU("Intel").
                setBoard("ASUS");

        Computer computer = computerBuilder.create();
        computer.print();
    }

}
