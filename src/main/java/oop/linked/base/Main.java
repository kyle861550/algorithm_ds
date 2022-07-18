package oop.linked.base;

public class Main {

    public static void main(String[] args) {
        LinkedItem ceo = new CEO();
        LinkedItem manager = new Manager();
        LinkedItem supervisor = new Supervisor();

        supervisor.next = manager;
        manager.next = ceo;

        System.out.println("Linked result: " + supervisor.start(1_000));
        System.out.println("--------------------------------\n");
        System.out.println("Linked result: " + supervisor.start(10_000));
        System.out.println("--------------------------------\n");
        System.out.println("Linked result: " + supervisor.start(100_000));
        System.out.println("--------------------------------\n");
        System.out.println("Linked result: " + supervisor.start(1_000_000));

    }

}
