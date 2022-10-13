package standard.sort.NlogN;

import java.util.Arrays;

public class MergeSort {

    public void mergeSort(int[] array) {
        _mergeSort(array, 0, array.length - 1);
    }

    private void _mergeSort(int[] array, int start, int end) {
        if(start == end) {
            return;
        }

        int mid = (start + end) / 2;

        _mergeSort(array, start, mid);
        _mergeSort(array, mid + 1, end);

        _merge(array, start, end, mid);
    }

    private void _merge(int[] array, int start, int end, int mid) {
        int[] tmpArray = new int[array.length];

        System.arraycopy(array, 0, tmpArray, 0, array.length);

        int left = start;
        int right = mid + 1;

        for(int i = start; i < end + 1; i++) {
            if(left > mid) {
                array[i] = tmpArray[right];

                right++;

            } else if(right > end) {
                array[i] = tmpArray[left];

                left++;
            } else if(array[left] < array[right]) {
                array[i] = tmpArray[left];

                left++;

            } else if(array[left] > array[right]) {
                array[i] = tmpArray[right];

                right++;

            }
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();

        int[] targetOrder = new int[] {
                21, 2, 15, 20, 3
        };
        mergeSort.mergeSort(targetOrder);

        System.out.println(Arrays.toString(targetOrder));
    }

}
