package oop.state.base;

public class McuMain {

    public static void main(String[] args) {
        IControl mcu = new PowerOnMode();    // 預設
        TestMcu(mcu);

        mcu = new PowerOffMode();
        TestMcu(mcu);
    }

    private static void TestMcu(IControl mcu) {
        mcu.showLed();
        mcu.stop();

        System.out.println("Test Finish -------------------------\n");
    }

}
