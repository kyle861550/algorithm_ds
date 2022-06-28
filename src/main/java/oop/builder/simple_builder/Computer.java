package oop.builder.simple_builder;

public class Computer {
    private String board, cpu;
    private int power, memory;

    public Computer(String b, String c, int p, int m) {
        board = b;
        cpu = c;
        power = p;
        memory = m;
    }

    void setBoard(String board) {
        this.board = board;
    }

    void setCPU(String cpu) {
        this.cpu = cpu;
    }

    void setPower(int power) {
        this.power = power;
    }

    void setMemory(int memory) {
        this.memory = memory;
    }

    public void print() {
        System.out.println("CPU is " + cpu + "\n"
                +"Board is " + board + "\n"
                +"power is " + power + "w\n"
                +"memory is " + memory + "G\n"
        );
    }
}
