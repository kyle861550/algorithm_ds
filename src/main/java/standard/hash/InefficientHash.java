package standard.hash;

public class InefficientHash<K, V> {

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

    public InefficientHash(int modulo) {
        array = new Entry[modulo];
        this.modulo = modulo;
    }

    public V get(K key) {
        int hashKey = hashCode(key) % modulo;

        if(array[hashKey] != null) {
            return array[hashKey].val;
        }
        return null;
    }

    public void put(K key, V val) {
        int hashKey = hashCode(key) % modulo;

        Entry<K, V> item = array[hashKey];

        if(item != null) {

            if(item.key == key) {
                item.val = val;
            } else {
                throw new RuntimeException(key + " conflict with: " + item.key + ", key: " + hashKey);
            }
        } else {
            array[hashKey] = new Entry<>(key, val);
        }
    }

    public int hashCode(K key) {
        return key.hashCode() & 0x7fff_ffff;
    }

    public static void main(String[] args) {
        InefficientHash<String, Integer> table = new InefficientHash<>(10);

        table.put("April", 30);
        table.put("May", 31);
        table.put("September", 30);

        System.out.println(table.get("April"));
        System.out.println(table.get("May"));
        System.out.println(table.get("September"));

    }

}
