package oop.singleton.lazy;

public class LazyNoSyn {
    private static LazyNoSyn l;

    private LazyNoSyn() {
    }

    public static LazyNoSyn getInstance() {
        if(l == null) {
            l = new LazyNoSyn();
        }
        return l;
    }

}
