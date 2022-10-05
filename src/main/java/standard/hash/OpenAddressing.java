package standard.hash;

public class OpenAddressing<K, V> {

    static final class Entry<K, V> {
        final K key;
        V val;
        Entry(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    private final Entry<K, V>[] array;
    private final int modulo;

    private int usedBucket;
    public OpenAddressing(int modulo) {
        array = new Entry[modulo];
        this.modulo = modulo;
        usedBucket = 0;
    }

    public V get(K key) {
        int hashKey = hashCode(key) % modulo;

        while (array[hashKey] != null) {
            if(array[hashKey].key == key) {
                return array[hashKey].val;
            }

            hashKey = (hashKey + 1) % modulo;
        }
        return null;
    }

    public void put(K key, V val) {
        int hashKey = hashCode(key) % modulo;

        while (array[hashKey] != null) {
            if(array[hashKey].key == key) {
                array[hashKey].val = val;
                return;
            }

            hashKey = (hashKey + 1) % modulo;

        }

        if(usedBucket >= array.length - 1) {
            throw new RuntimeException(key + " conflict with: " + array[hashKey] + ", key: " + hashKey);
        }

        array[hashKey] = new Entry<>(key, val);
        usedBucket += 1;
    }

    public int hashCode(K key) {
        return key.hashCode() & 0x7fff_ffff;
    }

    public static void main(String[] args) {

//        OpenAddressing<String, Integer> table = new OpenAddressing<>(3);
        OpenAddressing<String, Integer> table = new OpenAddressing<>(10);

        table.put("April", 30);
        table.put("May", 31);
        table.put("September", 30);

        System.out.println(table.get("April"));
        System.out.println(table.get("May"));
        System.out.println(table.get("September"));
    }
}
