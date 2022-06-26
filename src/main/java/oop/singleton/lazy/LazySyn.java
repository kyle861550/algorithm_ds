package oop.singleton.lazy;

public class LazySyn {

    private static LazySyn l;

    private LazySyn() {
    }

    public static synchronized LazySyn getInstance() {
        if(l == null) {
            l = new LazySyn();
        }
        return l;
    }

}
