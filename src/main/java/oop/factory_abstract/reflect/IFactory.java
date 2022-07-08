package oop.factory_abstract.reflect;

public interface IFactory {

    IComm.ICreate create(Class<? extends IComm.ICreate> clz);

    IComm.IStart getStartCode(Class<? extends IComm.IStart> clz);

}
