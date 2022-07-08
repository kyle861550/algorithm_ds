package oop.factory_abstract.base;

public interface IComm {

    interface ICreate {
        void create();
    }

    interface IStart {
        String getStartCode();
    }
}
