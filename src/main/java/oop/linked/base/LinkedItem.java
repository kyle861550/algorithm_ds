package oop.linked.base;

public abstract class LinkedItem {

    private final String handlePersonName;

    public LinkedItem() {
        this.handlePersonName = getClass().getSimpleName();
    }

    public LinkedItem next;

    public final boolean start(int money) {
        boolean canHandle = handle(money);

        if(!canHandle) {
            System.out.println(handlePersonName + " cannot pay.");

            return next != null && next.start(money);

        } else {
            System.out.println(handlePersonName + " handle pay: " + money);
        }


        return true;
    }

    protected abstract boolean handle(int money);

}
