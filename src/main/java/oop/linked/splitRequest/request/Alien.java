package oop.linked.splitRequest.request;

public class Alien implements Request {
    @Override
    public String getRequestName() {
        return "Alien";
    }

    @Override
    public String projectName() {
        return "Sky";
    }

    @Override
    public int cost() {
        return 1_000;
    }
}
