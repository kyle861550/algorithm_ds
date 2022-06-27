package oop.builder.simple_builder;

interface ComputerBuilder<T extends Computer> {

    ComputerBuilder<T> setBoard(String board);
    ComputerBuilder<T> setCPU(String cpu);
    ComputerBuilder<T> setPower(int power);
    ComputerBuilder<T> setMemory(int memory);
    ComputerBuilder<T> setScreenSize(int size);

    T create();

}