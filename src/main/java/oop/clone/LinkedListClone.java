package oop.clone;

import java.util.LinkedList;

public class LinkedListClone implements Cloneable {
    private String name;
    private int age;
    private final LinkedList<String> event = new LinkedList<>();

    @Override
    public LinkedListClone clone() {
        System.out.println("\n\n LinkedListClone Use clone");
        try {
            // clone 是淺拷貝
            return (LinkedListClone) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    LinkedListClone() {
        //"1. " 原先建構函數
        System.out.println("Make LinkedListClone Store");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEvent(String... mem) {
        for(String m:mem) {
            if(!event.contains(m)) {
                event.add(m);
            }
        }
    }

    public void print() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);

        for(String m: event) {
            System.out.print(m + ", hashcode: " + m.hashCode() + "\n");
        }
        System.out.println();
    }
}


class LinkedListMain {
    public static void main(String[] args) {

        LinkedListClone i = new LinkedListClone();
        i.setName("Pan");
        i.setAge(13);
        i.setEvent("Hello", "World");
        i.print();

        LinkedListClone ii = i.clone();
        ii.setAge(16);
        ii.setEvent("Test", "1234");
        ii.print();

        System.out.println("---------------------------------------------");
        i.print();
    }
}