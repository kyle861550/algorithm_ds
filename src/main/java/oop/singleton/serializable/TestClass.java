package oop.singleton.serializable;

import java.io.ObjectStreamException;
import java.io.Serial;
import java.io.Serializable;

//public class TestClass implements Serializable {
////    private static final TestClass instance = new TestClass();
//
//    private TestClass() {
//    }
//
////    public static TestClass getInstance() {
////        return instance;
////    }
////
////    @Serial
////    private Object readResolve() throws ObjectStreamException {
////        return instance;
////    }
//
//    public static TestClass getInstance() {
//        return Instance.instance;
//    }
//
//    @Serial
//    private Object readResolve() throws ObjectStreamException {
//        return Instance.instance;
//    }
//
//    private static final class Instance {
//        private static final TestClass instance = new TestClass();
//    }
//
//}

public enum TestClass {
    INSTANCE;
    public static TestClass getInstance() {
        return INSTANCE;
    }
}
