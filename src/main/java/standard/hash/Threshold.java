package standard.hash;

public class Threshold<K, V> {

    private static final class Node<K, V> {
        private final K key;
        private V value;

        private Node<K, V> next;

        private Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int modulo;
    private Node<K, V>[] hashArray;

    private int curHashKeyCount;
    private static final float threshold = 0.75f;

    public Threshold(int modulo) {
        this.curHashKeyCount = 0;
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

        curHashKeyCount += 1;

        double curThreshold = ((double) (curHashKeyCount)) / ((double) (modulo));
        if(curThreshold > threshold) {
            int newSize = modulo * 2 + 1;

            Threshold<K, V> tmp = new Threshold<>(newSize);

            for (Node<K, V> item : hashArray) {
                while (item != null) {
                    tmp.put(item.key, item.value);

                    item = item.next;
                }
            }

            this.hashArray = tmp.hashArray;
            this.modulo = tmp.modulo;
        }

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
        Threshold<String, Integer> classStudent = new Threshold<>(10);

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
