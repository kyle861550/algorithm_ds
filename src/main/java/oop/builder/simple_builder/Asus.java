package oop.builder.simple_builder;

public class Asus implements ComputerBuilder<Computer> {
    private String board = "技嘉", cpu = "AMD";
    private int power = 500, memory = 8;


    @Override
    public ComputerBuilder<Computer> setBoard(String board) {
        this.board = board;
        return this;
    }

    @Override
    public ComputerBuilder<Computer> setCPU(String cpu) {
        this.cpu = cpu;
        return this;
    }

    @Override
    public ComputerBuilder<Computer> setPower(int power) {
        this.power= power;
        return this;
    }

    @Override
    public ComputerBuilder<Computer> setMemory(int memory) {
        this.memory = memory;
        return this;
    }

    @Override
    public String getBoard() {
        return board;
    }

    @Override
    public String getCpu() {
        return cpu;
    }

    @Override
    public int getPower() {
        return power;
    }

    @Override
    public int getMemory() {
        return memory;
    }

    @Override
    public Computer create() {
        if(power < 200) {
            power = 200;
        }

        if(memory < 8) {
            memory = 8;
        }

        return new Computer(board, cpu, power, memory);
    }


}
