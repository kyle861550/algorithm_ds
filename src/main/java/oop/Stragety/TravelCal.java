package oop.Stragety;

public class TravelCal {

    public int getTravelCal(String type) {
        int result;

        if("Agency".equals(type)) {
            result = 300;
        } else if("SelfHelp".equals(type)) {
            result = 50;
        } else if("Backpacking".equals(type)) {
            result = 100;
        } else {
            result = -1;
        }

        return result;
    }
}
