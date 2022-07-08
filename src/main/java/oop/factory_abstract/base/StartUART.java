package oop.factory_abstract.base;

public class StartUART implements IComm.IStart {

    @Override
    public String getStartCode() {
        return "UUU_AAA_RRR_TTT";
    }

}
