package oop.command.game;

public abstract class AbstractCommand {

    private long step;

    protected GameControl gameControl;

    public AbstractCommand(GameControl gameControl) {
        this.gameControl = gameControl;
    }

    public void execute(long step) {
        this.step = step;
        System.out.println("----------- Start command");

        while (step-- > 0) {
            exec(gameControl);
        }
    }

    abstract void exec(GameControl control);

    public void doLastAgain() {
        execute(step);
    }

}
