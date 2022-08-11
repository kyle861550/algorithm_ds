package oop.memo.standard;

import java.util.HashMap;
import java.util.Map;

public class Caretaker {

    private final Map<String, Memo> memoList = new HashMap<>();


    public void setMemo(String name, Memo memo) {
        if(memo == null) {
            return;
        }

        memoList.put(name, memo);
    }

    public Memo getMemo(String name) {
        if(name == null || name.isEmpty()) {
            return null;
        }

        return memoList.get(name);
    }
}
