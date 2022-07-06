package oop.factory_abstract;

public interface IFactory {

    IComm.ICreate create();

    IComm.IStart getStartCode();

}
