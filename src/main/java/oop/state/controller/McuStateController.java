package oop.state.controller;

public class McuStateController {

    private IControl control = new PowerOffMode();

    enum State {
        ON,
        OFF
    }

    public void setState(State state) {
        switch (state) {
            case ON:
                control = new PowerOnMode();
                break;
            case OFF:
                control = new PowerOffMode();
                break;
        }
    }

    public void showLed() {
        control.showLed();
    }

    public void closeMcu() {
        control.stop();
    }

}
