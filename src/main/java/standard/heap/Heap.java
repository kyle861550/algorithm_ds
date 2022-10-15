package standard.heap;

import java.util.Arrays;

public class Heap {

    private Integer[] storage;
    private int cur;

    public Heap(int size) {
        storage = new Integer[size + 1];
        cur = 0;
    }

    public void enqueue(int newVal) {
        if(cur == storage.length - 1) {
            resize();
        }

        cur += 1;
        storage[cur] = newVal;
        swim(cur);
    }

    public void resize() {
        int oldSize = storage.length;
        Integer[] tmp = storage;
        storage = new Integer[oldSize * 2];
        cur = 0;
        for(int i = 1; i < tmp.length; i++) {
            if(tmp[i] == null) continue;
            enqueue(tmp[i]);
        }
    }

    public void swim(int index) {
        while (index > 1) {
            int compareIndex = index / 2;
            int compareVal = storage[compareIndex];

            if(storage[index] < compareVal) {
                break;
            }
            swap(index, compareIndex);
            index = compareIndex;
        }
    }

    public void swap(int i, int j) {
        int tmp = storage[i];
        storage[i] = storage[j];
        storage[j] = tmp;
    }

    public int dequeue() {
        if(cur == 0) {
            throw new RuntimeException("No value in heap now.");
        }
        int top = storage[1];

        storage[1] = storage[cur];
        storage[cur] = null;
        cur -= 1;
        sink();

        return top;
    }

    public void sink() {
        int rootIndex = 1;

        while (rootIndex * 2 + 1 <= cur) {
            int rootVal = storage[rootIndex];

            int leftIndex = 2 * rootIndex;
            int rightIndex = 2 * rootIndex + 1;

            int swapIndex = leftIndex;
            if(storage[leftIndex] < storage[rightIndex]) {  // compare left & right
                swapIndex = rightIndex;
            }

            if(rootVal > storage[swapIndex]) {
                break;
            }

            swap(rootIndex, swapIndex);

            rootIndex = swapIndex;
        }
    }

    public static void main(String[] args) {
        int[] a = {15, 13, 14, 9, 11, 12, 14, 8, 2, 6};
        Heap heap = new Heap(a.length);

        for (int i : a) {
            heap.enqueue(i);
        }


//        heap.enqueue(3);
//        heap.enqueue(1);
//        heap.dequeue();
//        System.out.println("Array: " + Arrays.toString(heap.storage));

//        System.out.println("\n\n");

        for (int j = 1; j < heap.storage.length; j++) {
            int top = heap.dequeue();

            System.out.println("top: " + top);
            System.out.println("Array: " + Arrays.toString(heap.storage));
        }

    }
}
