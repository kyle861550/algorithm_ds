package oop.factory_abstract.base;

public class FactoryTest {

    public static void main(String[] args) {
        FactoryTest factoryTest = new FactoryTest();

        factoryTest.testFactory(new SPI_Factory());
        factoryTest.testFactory(new UART_Factory());
        factoryTest.testFactory(new MIX_Factory());
    }

    public void testFactory(IFactory factory) {

        System.out.println("Factory implement: " + factory.getClass().getSimpleName());

        IComm.ICreate iCreate = factory.create();
        iCreate.create();

        IComm.IStart startCode = factory.getStartCode();
        System.out.println("Comm start code: " + startCode.getStartCode());

        System.out.println("// -------------------------------\n");
    }
}
