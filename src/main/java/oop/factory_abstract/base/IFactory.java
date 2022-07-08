package oop.factory_abstract.base;

public interface IFactory {

    IComm.ICreate create();

    IComm.IStart getStartCode();

}
