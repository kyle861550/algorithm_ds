package oop.command.game;

public class RightCommand extends AbstractCommand {

    public RightCommand(GameControl gameControl) {
        super(gameControl);
    }

    @Override
    public void exec(GameControl control) {
        control.turnRight();
    }

}
