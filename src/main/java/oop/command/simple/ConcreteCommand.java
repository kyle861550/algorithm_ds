package oop.command.simple;

public class ConcreteCommand implements ICommand {

    private final RealControl realControl;

    public ConcreteCommand(RealControl realControl) {
        this.realControl = realControl;
    }

    @Override
    public void execute() {
        realControl.action();
    }

}