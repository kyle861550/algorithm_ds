package oop.linked.splitRequest.handle;

import oop.linked.splitRequest.request.Request;

public abstract class LinkedItem {

    private final String handlePersonName;

    public LinkedItem() {
        this.handlePersonName = getClass().getSimpleName();
    }

    public LinkedItem next;

    public final boolean start(Request request) {
        int cost = request.cost();
        boolean canHandle = handle(cost);

        if(!canHandle) {
            System.out.println(handlePersonName + " cannot pay.");

            return next != null && next.start(request);

        } else {
            System.out.println("Person: " + request.getRequestName() + ", project" + request.projectName());
            System.out.println(handlePersonName + " handle pay: " + cost);
        }


        return true;
    }

    protected abstract boolean handle(int money);

}
