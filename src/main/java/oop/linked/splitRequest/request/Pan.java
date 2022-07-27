package oop.linked.splitRequest.request;

public class Pan implements Request {
    @Override
    public String getRequestName() {
        return "Pan";
    }

    @Override
    public String projectName() {
        return "Pandora";
    }

    @Override
    public int cost() {
        return 10_000;
    }
}
