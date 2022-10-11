package standard.sort;

import java.util.Arrays;

public class InsertionSort {
    public void sort(int[] array) {
        int compareTime = 0;

        for (int i = 0; i < array.length; i++) {

            for(int j = i; j > 0; j--) {
                compareTime += 1;

                if(array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                }
            }
        }

        System.out.println("Total compare time use: " + compareTime);
    }

    private void swap(int[] array, int source, int target) {
        int tmp = array[source];
        array[source] = array[target];
        array[target] = tmp;
    }

    public static void main(String[] args) {
        int[] nonSort = {
                15, 21 ,20, 2, 15 ,24, 5, 19
        };
        new InsertionSort().sort(nonSort);

        System.out.println("After sort: " + Arrays.toString(nonSort));
    }
}
