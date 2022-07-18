package oop.state.base;

public class PowerOffMode implements IControl {

    @Override
    public void stop() {
        System.out.println("MCU already off.");
    }

    @Override
    public void showLed() {
        System.out.println("Turn on MCU first.");
    }

}
