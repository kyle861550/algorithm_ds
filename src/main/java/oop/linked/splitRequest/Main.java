package oop.linked.splitRequest;

import oop.linked.splitRequest.handle.CEO;
import oop.linked.splitRequest.handle.LinkedItem;
import oop.linked.splitRequest.handle.Manager;
import oop.linked.splitRequest.handle.Supervisor;
import oop.linked.splitRequest.request.Alien;
import oop.linked.splitRequest.request.Pan;
import oop.linked.splitRequest.request.Shanks;

public class Main {

    public static void main(String[] args) {
        LinkedItem ceo = new CEO();
        LinkedItem manager = new Manager();
        LinkedItem supervisor = new Supervisor();

        supervisor.next = manager;
        manager.next = ceo;

        System.out.println("Linked result: " + supervisor.start(new Alien()));
        System.out.println("--------------------------------\n");
        System.out.println("Linked result: " + supervisor.start(new Pan()));
        System.out.println("--------------------------------\n");
        System.out.println("Linked result: " + supervisor.start(new Shanks()));

    }

}
