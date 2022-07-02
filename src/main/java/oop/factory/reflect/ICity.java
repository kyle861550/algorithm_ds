package oop.factory.reflect;

public interface ICity {

    ITravelInfo getTravel(Class<? extends ITravelInfo> clz);

}
