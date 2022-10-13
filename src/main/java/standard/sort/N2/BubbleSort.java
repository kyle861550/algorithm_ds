package standard.sort.N2;

import java.util.Arrays;

public class BubbleSort {
    public void sort(int[] array) {
        int compareTime = 0;

        for (int i = 0; i < array.length; i++) {

            for(int j = 0; j < array.length - 1 - i; j++) {
                compareTime += 1;

                if(array[j + 1] < array[j]) {
                    swap(array, j, j + 1);
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
        new BubbleSort().sort(nonSort);

        System.out.println("After sort: " + Arrays.toString(nonSort));
    }
}
