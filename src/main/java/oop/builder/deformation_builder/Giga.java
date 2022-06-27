package oop.builder.deformation_builder;

public class Giga implements ComputerBuilder_2<Computer_2> {

    private String cpu;
    private String board;
    private int power;

    public Giga(String cpu, String board) {
        this.cpu = cpu;
        this.board = board;
    }

    @Override
    public ComputerBuilder_2<Computer_2> setBoard(String board) {
        this.board = board + "_version_2";
        return this;
    }

    @Override
    public ComputerBuilder_2<Computer_2> setCPU(String cpu) {
        this.cpu = cpu + "_version_2";
        return this;
    }

    @Override
    public ComputerBuilder_2<Computer_2> setPower(int power) {
        this.power = power;
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
    public Computer_2 create() {
        if(power <= 0) {
            this.power = 300;
        }

        return new Computer_2(this);
    }
}
