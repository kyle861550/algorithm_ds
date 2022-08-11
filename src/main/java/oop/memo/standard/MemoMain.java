package oop.memo.standard;

public class MemoMain {

    public static void main(String[] args) {

        Caretaker caretaker = new Caretaker();

        GameProvider game = new GameProvider();
        game.attack();
        game.attack();
        game.defense();

        final String player = "Alien";
        caretaker.setMemo(player, game.createMemo());
        game.finishGame();

        GameProvider game2 = new GameProvider();
        game2.restore(caretaker.getMemo(player));
        game2.finishGame();
    }

}
