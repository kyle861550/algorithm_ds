package oop.factory_abstract.reflect;


public class FactoryTest {

    public static void main(String[] args) {
        FactoryTest factoryTest = new FactoryTest();

        IFactory factory = new UniversalFactory();

        System.out.println("SPI ------------------------------------");
        factoryTest.testFactory(factory, CreateSPI.class, StartSPI.class);

        System.out.println("UART -------------------------------\n");
        factoryTest.testFactory(factory, CreateUART.class, StartUART.class);

        System.out.println("MIX -------------------------------\n");
        factoryTest.testFactory(factory, CreateSPI.class, StartUART.class);
    }

    public void testFactory(IFactory factory,
                            Class<? extends IComm.ICreate> create,
                            Class<? extends IComm.IStart> start) {

        System.out.println("Factory implement: " + factory.getClass().getSimpleName());

        IComm.ICreate iCreate = factory.create(create);
        iCreate.create();

        IComm.IStart startCode = factory.getStartCode(start);
        System.out.println("Comm start code: " + startCode.getStartCode());

    }
}
