package struct_type.lru_lfu.lru;

import java.util.HashMap;

public class LRU extends LRUCache {

    public static void main(String[] args) {
        LRU lru = new LRU(2);

        lru.put(1, "Alien");
        lru.put(2, "Bob");

        String s = lru.get(1);
        System.out.println("Key 1: " + s);

        lru.put(3, "XCode");

        String s1 = lru.get(2);
        System.out.println("Key 2: " + s1);

        lru.put(1, "Pan");

        String s2 = lru.get(1);
        System.out.println("Key 1: " + s2);
    }

    private final int capacity;

    public LRU(int capacity) {
        this.capacity = capacity;
    }

    public String get(int key) {
        if(!hashMap.containsKey(key)) {
            return null;
        }

        makeRecently(key);
        return hashMap.get(key).value;
    }

    public void put(int key, String value) {
        if(hashMap.containsKey(key)) {
            deleteNode(key);
            addRecently(key, value);
            return;
        }

        if(hashMap.size() >= capacity) {
            removeLeastRecently();
        }
        addRecently(key, value);
    }

}

class LRUCache {
    protected final HashMap<Integer, Node> hashMap = new HashMap<>();
    protected final DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

    protected void makeRecently(int key) {
        Node node = hashMap.get(key);

        doubleLinkedList.remove(node);
        doubleLinkedList.addFirst(node);
    }

    protected void removeLeastRecently() {
        Node node = doubleLinkedList.removeLast();
        hashMap.remove(node.key);
    }

    protected void addRecently(int key, String value) {
        Node node = new Node(key, value);

        doubleLinkedList.addFirst(node);
        hashMap.put(key, node);
    }

    protected void deleteNode(int key) {
        Node item = hashMap.remove(key);
        doubleLinkedList.remove(item);
    }
}

class Node {
    int key;
    String value;
    Node pre, next;

    public Node(int key, String value) {
        this.key = key;
        this.value = value;
    }
}

class DoubleLinkedList {
    Node head, tail;
    int size;

    DoubleLinkedList() {
        head = new Node(0, "");
        tail = new Node(0, "");
        head.next = tail;
        tail.pre = head;
        size = 0;
    }

    public void addFirst(Node node) {
        node.pre = head;
        node.next = head.next;

        head.next.pre = node;
        head.next = node;
        size++;
    }

    public void remove(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        size--;
    }

    public Node removeLast() {
        if(head.next == tail) {
            return null;
        }
        Node last = tail.pre;
        remove(last);
        return last;
    }

    public int getSize() {
        return size;
    }
}
