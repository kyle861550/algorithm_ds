package oop.command.game;

public class DownCommand extends AbstractCommand {

    public DownCommand(GameControl gameControl) {
        super(gameControl);
    }

    @Override
    public void exec(GameControl control) {
        control.turnDown();
    }

}
