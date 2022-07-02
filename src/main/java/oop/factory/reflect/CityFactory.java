package oop.factory.reflect;

import java.lang.reflect.Constructor;

public class CityFactory implements ICity {

    @Override
    public ITravelInfo getTravel(Class<? extends ITravelInfo> clz) {
        try {
            Constructor<? extends ITravelInfo> constructor = clz.getConstructor();

            return constructor.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
