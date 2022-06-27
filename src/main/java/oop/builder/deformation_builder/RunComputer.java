package oop.builder.deformation_builder;

public class RunComputer {

    public static void main(String[] args) {
        ComputerBuilder_2<?> builder2 = new Giga("AMD_2", "Giga");

        Computer_2 computer_2 = builder2.create();

        computer_2.print();
    }

}
