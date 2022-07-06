package oop.factory_abstract;

public class UART_Factory implements IFactory {

    @Override
    public IComm.ICreate create() {
        return new CreateUART();
    }

    @Override
    public IComm.IStart getStartCode() {
        return new StartUART();
    }
}
