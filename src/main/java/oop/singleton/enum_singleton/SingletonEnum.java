package oop.singleton.enum_singleton;

public enum SingletonEnum {
    INSTANCE,
    HELLO,
    WORLD;

    public void toDo() {
        System.out.println("to Do Something");
    }
}
