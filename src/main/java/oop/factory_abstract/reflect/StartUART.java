package oop.factory_abstract.reflect;

public class StartUART implements IComm.IStart {
    @Override
    public String getStartCode() {
        return "UUU--AAA---RRR---TTT";
    }
}
