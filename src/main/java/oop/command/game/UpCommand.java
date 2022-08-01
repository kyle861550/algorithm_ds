package oop.command.game;

public class UpCommand extends AbstractCommand {

    public UpCommand(GameControl gameControl) {
        super(gameControl);
    }

    @Override
    public void exec(GameControl control) {
        control.turnUp();
    }

}
