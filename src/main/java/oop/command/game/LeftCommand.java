package oop.command.game;

public class LeftCommand extends AbstractCommand {

    public LeftCommand(GameControl gameControl) {
        super(gameControl);
    }

    @Override
    public void exec(GameControl control) {
        control.turnLeft();
    }

}
