package oop.factory_abstract.base;

public class CreateSPI implements IComm.ICreate {

    @Override
    public void create() {
        System.out.println("Start create Spi comm");
    }

}
