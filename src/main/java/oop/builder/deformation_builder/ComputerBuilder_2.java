package oop.builder.deformation_builder;

public interface ComputerBuilder_2<T extends Computer_2> {

    ComputerBuilder_2<T> setBoard(String board);
    ComputerBuilder_2<T> setCPU(String cpu);
    ComputerBuilder_2<T> setPower(int power);

    String getBoard();
    String getCpu();
    int getPower();

    T create();

}