package oop.factory.reflect;

import java.util.ArrayList;
import java.util.List;

public class JapanTravelInfo implements ITravelInfo {

    public String name;
    public boolean chineseLang;
    public List<String> places = new ArrayList<>();

    public JapanTravelInfo() {
        this.name = "Japan";
        this.chineseLang = false;
        places.add("Tokyo");
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
