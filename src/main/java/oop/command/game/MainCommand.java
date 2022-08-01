package oop.command.game;

public class MainCommand {

    public static void main(String[] args) {
        GameControl gameControl = new GameControl();

        Invoker invoker = new Invoker(
                new RightCommand(gameControl),
                new LeftCommand(gameControl),
                new UpCommand(gameControl),
                new DownCommand(gameControl));

        invoker.turnDown(3);
        invoker.turnUp(1);
        invoker.turnLeft(2);
        invoker.turnRight(5);

        System.out.println("---------------------- Record");

        invoker.showRecordStep();
    }

}
