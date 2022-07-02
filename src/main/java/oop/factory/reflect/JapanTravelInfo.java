package oop.factory.reflect;

import java.util.ArrayList;
import java.util.List;

public class TravelInfoImpl implements ITravelInfo {

    public String name;
    public boolean chineseLang;
    public List<String> places = new ArrayList<>();

    public TravelInfoImpl(String name, boolean chineseLang) {
        this.name = name;
        this.chineseLang = chineseLang;
    }

    @Override
    public String getCityName() {
        return name;
    }

    @Override
    public String getTravelInfo() {
        return places.toString() + ", Chinese lang: " + (chineseLang ? "Yes" : "No");
    }
}
