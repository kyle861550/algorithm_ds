package oop.builder.simple_builder;

public class Director {
    private final ComputerBuilder<?> computerBuilder;

    public Director(ComputerBuilder<?> computerBuilder) {
        this.computerBuilder = computerBuilder;
    }

    public Computer getAsusComputer_Normal() {
        return computerBuilder.create();     // 用 default 參數
    }

    public Computer getAsusComputer_Top() {
        return computerBuilder.setCPU("intel i9")
                .setMemory(64)
                .setPower(1200)
                .create();
    }

}
