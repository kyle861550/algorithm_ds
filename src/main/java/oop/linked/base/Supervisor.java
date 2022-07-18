package oop.linked.base;

public class Supervisor extends LinkedItem {

    protected static final int MONEY_LIMIT = 1_000;

    @Override
    protected boolean handle(int money) {
        return money <= MONEY_LIMIT;
    }
}
