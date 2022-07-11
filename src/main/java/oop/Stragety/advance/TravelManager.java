package oop.Stragety.advance;

import java.util.HashMap;
import java.util.Map;

public class TravelManager {

    enum Option {
        BACK_PACKING,
        SELF_HELP,
        AGENCY
    }

    private final Map<Option, TravelCast> map = new HashMap<>() {
        {
            put(Option.BACK_PACKING, new Backpacking());
            put(Option.SELF_HELP, new SelfHelp());
            put(Option.AGENCY, new Agency());
        }
    };

    private Option option;

    public TravelManager() {
        option = Option.AGENCY;
    }

    public TravelManager setOption(Option option) {
        this.option = option;
        return this;
    }

    public void printCast() {
        TravelCast travelCast = map.get(option);

        if(travelCast == null) {
            throw new IllegalAccessError("setTravelCast first");
        }

        System.out.println(travelCast.getClass().getSimpleName() + " Cast: " + travelCast.calCast());
    }
}
