package oop.state.controller;

public class McuMain {

    public static void main(String[] args) {
        McuStateController controller = new McuStateController();

        controller.setState(McuStateController.State.ON);
        testController(controller);


        // Changer State
        controller.setState(McuStateController.State.OFF);
        testController(controller);
    }

    public static void testController(McuStateController controller) {
        controller.showLed();
        controller.closeMcu();

        System.out.println("Test Finish ------------------------------\n");
    }

}
