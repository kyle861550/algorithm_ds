package oop.factory_abstract.reflect;

import java.lang.reflect.Constructor;

public class UniversalFactory implements IFactory {

    @Override
    public IComm.ICreate create(Class<? extends IComm.ICreate> clz) {
        IComm.ICreate result;

        try {
            Constructor<? extends IComm.ICreate> constructor = clz.getConstructor();
            result = constructor.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public IComm.IStart getStartCode(Class<? extends IComm.IStart> clz) {
        IComm.IStart result;

        try {
            Constructor<? extends IComm.IStart> constructor = clz.getConstructor();
            result = constructor.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return result;
    }

}
