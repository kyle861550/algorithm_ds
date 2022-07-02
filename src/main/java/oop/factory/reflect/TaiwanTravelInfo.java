package oop.factory.reflect;

import java.util.ArrayList;
import java.util.List;

public class TaiwanTravelInfo implements ITravelInfo {

    public String name;
    public boolean chineseLang;
    public List<String> places = new ArrayList<>();

    public TaiwanTravelInfo() {
        this.name = "Taiwan";
        this.chineseLang = true;
        places.add("Taipei");
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
