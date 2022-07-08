package oop.factory_abstract.reflect;

public class CreateSPI implements IComm.ICreate{
    @Override
    public void create() {
        System.out.println("Create SPI comm.");
    }
}
