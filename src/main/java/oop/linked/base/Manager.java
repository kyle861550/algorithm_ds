package oop.linked.base;

public class Manager extends LinkedItem {

    protected static final int MONEY_LIMIT = 10_000;

    @Override
    protected boolean handle(int money) {
        return money <= MONEY_LIMIT;
    }
}
