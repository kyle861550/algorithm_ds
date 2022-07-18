package oop.state;

public class McuControl {

    enum State {
        ON,
        OFF
    }

    private State curState = State.OFF;

    public void setState(State state) {
        if(state != curState) {
            curState = state;
        }
    }

    public void start() {
        switch (curState) {
            case ON:
                System.out.println("MCU already on.");
                break;

            case OFF:
                System.out.println("MCU turn on.");
                break;
        }
    }

    public void stop() {
        switch (curState) {
            case ON:
                System.out.println("MCU turn off.");
                break;

            case OFF:
                System.out.println("MCU already off.");
                break;
        }
    }

    public void showLed() {
        switch (curState) {
            case ON:
                System.out.println("Shiny ~ Shiny ~ Shiny ~.");
                break;

            case OFF:
                System.out.println("Turn on MCU first.");
                break;
        }
    }

}
