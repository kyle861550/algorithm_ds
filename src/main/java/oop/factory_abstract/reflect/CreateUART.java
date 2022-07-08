package oop.factory_abstract.reflect;

public class CreateUART implements IComm.ICreate{
    @Override
    public void create() {
        System.out.println("Create UART comm.");
    }
}
