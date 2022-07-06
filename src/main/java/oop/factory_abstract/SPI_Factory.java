package oop.factory_abstract;

public class SPI_Factory implements IFactory {

    @Override
    public IComm.ICreate create() {
        return new CreateSPI();
    }

    @Override
    public IComm.IStart getStartCode() {
        return new StartSPI();
    }
}
