package oop.linked.splitRequest.request;

public class Shanks implements Request {
    @Override
    public String getRequestName() {
        return "Shanks";
    }

    @Override
    public String projectName() {
        return "Comics";
    }

    @Override
    public int cost() {
        return 100_000;
    }
}
