package oop.factory;

public class FactoryMain {

    public static void main(String[] args) {
        ICity iCity = new CityFactory();

        ITravelInfo taiwan = iCity.getTaiwan();
        print(taiwan);

        ITravelInfo japan = iCity.getJapan();
        print(japan);
    }

    public static void print(ITravelInfo travelInfo) {
        System.out.println("City: " + travelInfo.getCityName() +
                ", place: " + travelInfo.getTravelInfo());
    }

}
