package oop.factory_abstract;

public class CreateUART implements IComm.ICreate {

    @Override
    public void create() {
        System.out.println("Start create UART comm");
    }

}
