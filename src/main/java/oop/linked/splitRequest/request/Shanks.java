package oop.linked.splitRequest.request;

public class Shanks implements Request {
    @Override
    public String getRequestName() {
        return "Shanks";
    }

    @Override
    public String projectName() {
        return "航海王";
    }

    @Override
    public int cost() {
        return 100_000;
    }
}
