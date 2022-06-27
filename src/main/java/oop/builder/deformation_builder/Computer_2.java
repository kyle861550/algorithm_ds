package oop.builder.deformation_builder;

public class Computer_2 {
    private String board;
    private String cpu;
    private int power;

    public Computer_2(ComputerBuilder_2<?> builder) {
        board = builder.getBoard();
        cpu = builder.getCpu();
        power = builder.getPower();
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

    public void print() {
        System.out.println("CPU is " + cpu + "\n"
                +"Board is " + board + "\n"
                +"power is " + power + "w\n"
        );
    }
}
