package oop.factory.reflect;

import java.util.ArrayList;
import java.util.List;

public class JapanTravelInfo implements ITravelInfo {

    public String name;
    public boolean chineseLang;
    public List<String> places = new ArrayList<>();

    public JapanTravelInfo(String name) {
        this.name = name;
        this.chineseLang = false;
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
