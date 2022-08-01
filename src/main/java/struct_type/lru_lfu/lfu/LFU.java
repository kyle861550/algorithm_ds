package struct_type.lru_lfu.lfu;

import java.util.LinkedHashSet;

public class LFU extends LFUKernel {
    public LFU(int capacity) {
        super(capacity);
    }

    public void put(int key, String val) {
        if(capacity <= 0) return;

        if(keyToVal.containsKey(key)) {
            keyToVal.put(key, val);
            increaseFreq(key);
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
            removeMinFreq();
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

        increaseFreq(key);
        return keyToVal.get(key);
    }

    public static void main(String[] args) {

        LFU lfu = new LFU(2);

        lfu.put(1, "Alien");
        lfu.put(2, "Bob");

        String s1 = lfu.get(1);
        System.out.println("Key1 : " + s1);

        lfu.put(3, "XCode");

        String s2 = lfu.get(2);
        System.out.println("Key2 : " + s2);
    }
}
