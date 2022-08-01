package struct_type.lru_lfu.lfu;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUBaseStruct {

    // key: Key
    // Value: Value
    private final HashMap<Integer, String> keyToVal = new HashMap<>();

    // key: Key
    // Value: freq
    private final HashMap<Integer, Integer> keyToFreq = new HashMap<>();

    // Key: freq
    // Value: key Linked<Key>
    private final HashMap<Integer, LinkedHashSet<Integer>> freqToKey = new HashMap<>();

    private final int capacity;

    private int minFreq = 0;

    public LFUBaseStruct(int capacity) {
        this.capacity = capacity;
    }

    public void put(int key, String val) {
        if(minFreq <= 0) return;

        if(keyToVal.containsKey(key)) {
            // TODO: Update freq
            keyToVal.put(key, val);
            return;
        }

        if(keyToVal.size() >= capacity) {
            LinkedHashSet<Integer> list = freqToKey.get(minFreq);
            if(list.size() > 1) {
                int leastKey = list.iterator().next();
                list.remove(leastKey);
            } else {
                list.remove(key);
            }
            // TODO: Remove min freq
        }

        keyToVal.put(key, val);
        keyToFreq.put(key, 1);

        freqToKey.putIfAbsent(1, new LinkedHashSet<>());
        freqToKey.get(1).add(key);

        minFreq = 1;
    }

    public String get(int key) {
        if(!keyToVal.containsKey(key)) {
            return null;
        }

        // TODO: Update freq
        return keyToVal.get(key);
    }
}
