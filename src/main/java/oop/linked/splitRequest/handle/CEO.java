package oop.linked.splitRequest.handle;

public class CEO extends LinkedItem {

    protected static final int MONEY_LIMIT = 100_000;

    @Override
    protected boolean handle(int money) {
        return money <= MONEY_LIMIT;
    }
}
