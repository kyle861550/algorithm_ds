package standard.sort.NlogN;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    public void quickSort(int[] array) {
        _quickSort(array, 0, array.length);
    }

    private void _quickSort(int[] array, int start, int end) {
        if(end <= start) {
            return;
        }

        int pivot = (int) (Math.random() * (end - start)) + start;
        System.out.println("Pivot: " + pivot + ", start: " + start + ", end: " + end);

        int location = partitionBySelection(array, start, end, pivot);

        _quickSort(array, start, location - 1);
        _quickSort(array, location + 1, end);
    }

    private int partitionBySelection(int[] array, int start, int end, int pivot) {

        int pVal = array[pivot];

        for(int i = start; i < end; i++) {
            for (int j = i + 1; j < end; j++) {
                if(array[i] > array[j]) {
                    exchange(array, i, j);
                }
            }

            if(array[i] == pVal) {
                pivot = i;
                break;
            }
        }
        return pivot;
    }

//    // Maybe cannot use insertion sort
//    private int partitionByInsertion(int[] array, int start, int end, int pivot) {
//
//        int pVal = array[pivot];
//
//        for (int i = start; i < end; i++) {
//
//            for(int j = i; j > 0; j--) {
//                if(array[j - 1] > array[j]) {
//                    exchange(array, j - 1, j);
//                }
//            }
//        }
//
//        return pivot;
//    }

    private void exchange(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();

        int[] array = {
                15, 21, 20, 2, 15, 24, 5, 19
        };
//        quickSort.partitionBySelection(array, 0, array.length - 1, 0);

        quickSort.quickSort(array);

        System.out.println(Arrays.toString(array));
    }

}
