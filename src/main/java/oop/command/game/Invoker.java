package oop.command.game;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Invoker {

    private final LinkedList<AbstractCommand> record = new LinkedList<>();

    private final Map<String, AbstractCommand> map = new HashMap<>();

    public Invoker(AbstractCommand right, AbstractCommand left, AbstractCommand up, AbstractCommand down) {
        map.put("Right", right);
        map.put("Left", left);
        map.put("Up", up);
        map.put("Down", down);
    }

    public void turnRight(long step) {
        AbstractCommand right = map.get("Right");

        if(right == null) {
            return;
        }

        right.execute(step);
        record.addFirst(right);
    }

    public void turnLeft(long step) {
        AbstractCommand left = map.get("Left");

        if(left == null) {
            return;
        }

        left.execute(step);
        record.addFirst(left);
    }

    public void turnUp(long step) {
        AbstractCommand up = map.get("Up");

        if(up == null) {
            return;
        }

        up.execute(step);
        record.addFirst(up);
    }

    public void turnDown(long step) {
        AbstractCommand down = map.get("Down");

        if(down == null) {
            return;
        }

        down.execute(step);
        record.addFirst(down);
    }

    public void showRecordStep() {
        AbstractCommand tmp = record.getFirst();
        while (tmp != null) {
            tmp.doLastAgain();
            tmp = record.poll();
        }
    }

}