package oop.factory.reflect;

public class FactoryMain {

    public static void main(String[] args) {
        ICity iCity = new CityFactory();

        ITravelInfo taiwan = iCity.getTravel(TaiwanTravelInfo.class);
        print(taiwan);

        ITravelInfo japan = iCity.getTravel(JapanTravelInfo.class);
        print(japan);
    }

    public static void print(ITravelInfo travelInfo) {
        System.out.println("City: " + travelInfo.getCityName() +
                ", place: " + travelInfo.getTravelInfo());
    }

}
