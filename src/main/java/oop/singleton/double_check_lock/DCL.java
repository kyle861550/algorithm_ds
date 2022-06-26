package oop.singleton.double_check_lock;

public class DCL {
    private volatile static DCL d;    // 4

    private DCL() { }

    public static DCL getInstance() {
        if(d == null) {		// 1
            synchronized(DCL.class) {	// 3
                if(d == null) {		// 2
                    d = new DCL();
                }
            }
        }
        return d;
    }
}
