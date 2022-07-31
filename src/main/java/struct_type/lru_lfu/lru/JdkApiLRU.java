package struct_type.lru_lfu.lru;

import java.util.LinkedHashMap;

public class JdkApiLRU {

    private final LinkedHashMap<Integer, String> map = new LinkedHashMap<>();

    private final int capacity;

    public JdkApiLRU(int capacity) {
        this.capacity = capacity;
    }

    public void put(int key, String value) {
        if(map.containsKey(key)) {
            map.put(key, value);
            addRecently(key);
            return;
        }

        if(map.size() >= capacity) {
            int leastKey = map.keySet().iterator().next();
            map.remove(leastKey);
        }

        map.put(key, value);
    }

    public String get(int key) {
        if(!map.containsKey(key)) {
            return null;
        }

        String val = map.get(key);
        addRecently(key);
        return val;
    }

    private void addRecently(int key) {
        String val = map.get(key);

        map.remove(key);
        map.put(key, val);
    }
}
