package oop.factory;

public class CityFactory implements ICity {
    @Override
    public ITravelInfo getTaiwan() {
        TravelInfoImpl travelInfo = new TravelInfoImpl("Taiwan", true);
        travelInfo.places.add("taipei");
        return travelInfo;
    }

    @Override
    public ITravelInfo getJapan() {
        TravelInfoImpl travelInfo = new TravelInfoImpl("Japan", false);
        travelInfo.places.add("tokyo");
        return travelInfo;
    }
}
