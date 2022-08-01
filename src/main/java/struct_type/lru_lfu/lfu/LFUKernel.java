package struct_type.lru_lfu.lfu;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUKernel {

    // key: Key
    // Value: Value
    protected final HashMap<Integer, String> keyToVal = new HashMap<>();

    // key: Key
    // Value: freq
    protected final HashMap<Integer, Integer> keyToFreq = new HashMap<>();

    // Key: freq
    // Value: key Linked<Key>
    protected final HashMap<Integer, LinkedHashSet<Integer>> freqToKey = new HashMap<>();

    protected final int capacity;

    protected int minFreq = 0;

    public LFUKernel(int capacity) {
        this.capacity = capacity;
    }

    protected void removeMinFreq() {
        LinkedHashSet<Integer> list = freqToKey.get(minFreq);
        int leastKey = list.iterator().next();

        list.remove(leastKey);
        if(list.isEmpty()) {
            freqToKey.remove(leastKey);
            // TODO: Modify minFreq ?
        }

        keyToFreq.remove(leastKey);
        keyToVal.remove(leastKey);
    }

    protected void increaseFreq(int key) {
        int oldFreq = keyToFreq.get(key);
        int newFreq = oldFreq + 1;
        keyToFreq.put(key, newFreq);

        // remove old
        LinkedHashSet<Integer> oldKeyList = freqToKey.get(oldFreq);
        oldKeyList.remove(key);
        if(oldKeyList.isEmpty()) {  // update freqToKey list
            freqToKey.remove(oldFreq);
            if(oldFreq == minFreq) {
                minFreq = newFreq;
            }
        }

        // add to new
        freqToKey.putIfAbsent(newFreq, new LinkedHashSet<>());
        freqToKey.get(newFreq).add(key);
    }
}
