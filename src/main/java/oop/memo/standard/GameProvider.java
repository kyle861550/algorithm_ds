package oop.memo.standard;

// Originator
public class GameProvider {
    private int hp = 100;
    private int mp = 100;

    public Memo createMemo() {
        Memo memo = new Memo();
        memo.hp = hp;
        memo.mp = mp;

        return memo;
    }

    public void restore(Memo memo) {
        if(memo == null) {
            return;
        }

        hp = memo.hp;
        mp = memo.mp;
    }

    public GameProvider attack() {
        mp -= 20;
        return this;
    }

    public GameProvider defense() {
        hp -= 5;
        return this;
    }

    public void finishGame() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Hp: " + hp + ", mp: " + mp;
    }
}
