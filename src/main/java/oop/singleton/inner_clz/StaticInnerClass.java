package oop.singleton.inner_clz;

public class StaticInnerClass {

    private StaticInnerClass() {
    }

    public static StaticInnerClass getInstance() {
        return innerClass.sic;
    }

    private static class innerClass {
        private static final StaticInnerClass sic = new StaticInnerClass();
    }

}
