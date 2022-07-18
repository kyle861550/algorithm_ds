package oop.state.base;

public class PowerOnMode implements IControl {

    @Override
    public void stop() {
        System.out.println("MCU turn off.");
    }

    @Override
    public void showLed() {
        System.out.println("Shiny ~ Shiny ~ Shiny ~.");
    }

}
