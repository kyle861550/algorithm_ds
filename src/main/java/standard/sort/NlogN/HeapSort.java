package standard.sort.NlogN;

import java.util.Arrays;

public class HeapSort {

    private final int[] array;

    private int N;

    public HeapSort(int[] array) {
        this.array = array;
        this.N = array.length;

        for(int i = N / 2; i > 0; i--) {
            sink(i);
        }
    }

    private void sink(int index) {

        while (index * 2 + 1 <= N) {
            int c = index * 2;

//            if(array[c + 1] > array[c]) {     // replace by less
            if(less(c, c + 1)) {
                c = c + 1;
            }

//            if(array[index] > array[c]) {     // replace by less
            if(less(c, index)) {
                break;
            }
            swap(c, index);

            index = c;
        }

    }

    private void swap(int i, int j) {
        i -= 1;
        j -= 1;

        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private boolean less(int i, int j) {
        i -= 1;
        j -= 1;

        return array[i] < array[j];
    }

    public void sort() {
        while (N > 1) {
            swap(1, N);
            N -= 1;
            sink(1);
        }
    }

    public static void main(String[] args) {
        int[] array = {
                12, 13, 8, 2, 6 ,
                15, 14, 14, 9, 11
        };
//        int[] a = {15, 13, 14, 9, 11, 12, 14, 8, 2, 6};

        HeapSort heapSort = new HeapSort(array);

//        System.out.println(Arrays.toString(heapSort.array));

        heapSort.sort();
        System.out.println(Arrays.toString(heapSort.array));

//        for(int i = 10; i >= 0; i--) {
//            System.out.println("" + i);
//        }
    }

}
