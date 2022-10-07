package standard.hash;

public class LinkedHashTable<K, V> {

    private static final class Node<K, V> {
        private final K key;
        private V value;

        private Node<K, V> next;

        private Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int modulo;
    private final Node<K, V>[] hashArray;

    public LinkedHashTable(int modulo) {
        this.modulo = modulo;
        this.hashArray = new Node[modulo];
    }


    private int getHashNum(Object obj) {
        return obj.hashCode() & 0x7FFF_FFFF;
    }

    public V get(K key) {
        int hashValue = getHashNum(key) % modulo;

        Node<K, V> node = hashArray[hashValue];

        while (node != null) {
            if(node.key == key) {
                return node.value;
            }
            node = node.next;
        }

        return null;
    }


    public void put(K key, V value) {
        int hashValue = getHashNum(key) % modulo;

        Node<K, V> node = hashArray[hashValue];

        while (node != null) {
            if(node.key == key) {
                node.value = value;
                return;
            }
            node = node.next;
        }

        Node<K, V> newNode = new Node<>(key, value);
        Node<K, V> oldNode = hashArray[hashValue];
        if(oldNode != null) {
            newNode.next = oldNode;
        }
        hashArray[hashValue] = newNode;

    }

    public Node<K, V> remove(K key) {
        int hashValue = getHashNum(key) % modulo;

        Node<K, V> node = hashArray[hashValue];

        Node<K, V> pre = null;
        while (node != null) {
            if(node.key == key) {
                if(pre != null) {
                    pre.next = node.next;
                } else {
                    hashArray[hashValue] = node.next;
                }

                node.next = null;
                return node;
            }
            pre = node;
            node = node.next;
        }

        return null;
    }

    public static void main(String[] args) {
        LinkedHashTable<String, Integer> classStudent = new LinkedHashTable<>(10);

        classStudent.put("Alien", 10);
        classStudent.put("Pan", 13);
        classStudent.put("Wind", 6);
        classStudent.put("Jasper", 7);

        System.out.println("Alien age: " + classStudent.get("Alien"));
        System.out.println("Pan age: " + classStudent.get("Pan"));
        System.out.println("Wind age: " + classStudent.get("Wind"));
        System.out.println("Jasper age: " + classStudent.get("Jasper") + "\n");

        Node<String, Integer> alien = classStudent.remove("Alien");
        System.out.println(alien.key + " be remove, " + classStudent.get("Alien"));
    }

}
