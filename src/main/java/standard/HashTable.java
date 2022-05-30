package standard;

public class HashTable<K, V> {

    public static void main(String[] args) {
        HashTable<String, Integer> classStudent = new HashTable<>();

        classStudent.put("Alien", 10);
        classStudent.put("Pan", 13);
        classStudent.put("Wind", 6);
        classStudent.put("Jasper", 7);

        System.out.println(classStudent.get("Alien"));
        System.out.println(classStudent.get("Pan"));
        System.out.println(classStudent.get("Wind"));
        System.out.println(classStudent.get("Jasper"));
    }

    private static final class Node<K, V> {
        private final K key;
        private final V value;

        private Node<K, V> next;

        private Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final Node<K, V>[] hashArray = new Node[10];

    private int getHashNum(Object obj) {
        return obj.hashCode() & 0x09;
    }

    public void put(K key, V value) {
        if(value == null) {
            return;
        }
        int hashValue = getHashNum(key);

        Node<K, V> node = hashArray[hashValue];

        if(node == null) {
            hashArray[hashValue] = new Node<>(key, value);
            return;
        }

        while(true) {
            if(node.next == null) {
                node.next = new Node<>(key, value);
                break;
            }
            node = node.next;
        }
    }

    public V get(K key) {
        if(key == null) {
            return null;
        }
        int hashValue = getHashNum(key);

        Node<K, V> node = hashArray[hashValue];

        if(node == null) {
            return null;
        }

        V value;

        while (true) {
            if(node.key == key) {
                value = node.value;
                break;
            }
            node = node.next;
        }

        return value;
    }


}
