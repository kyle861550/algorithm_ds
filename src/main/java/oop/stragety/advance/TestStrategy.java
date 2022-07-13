package oop.stragety.advance;

public class TestStrategy {

    public static void main(String[] args) {
        TravelManager travelManager = new TravelManager();

        travelManager.setOption(TravelManager.Option.AGENCY).printCast();

        travelManager.setOption(TravelManager.Option.SELF_HELP).printCast();

        travelManager.setOption(TravelManager.Option.BACK_PACKING).printCast();
    }

}
