package oop.factory_abstract;

public interface IComm {

    interface ICreate {
        void create();
    }

    interface IStart {
        String getStartCode();
    }
}
