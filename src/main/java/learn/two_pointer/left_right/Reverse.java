package learn.two_pointer.left_right;

import java.util.Arrays;

public class Reverse {

    public void reverse(int[] array) {
        int leftPtr = 0;
        int rightPtr = array.length - 1;

        while (leftPtr < rightPtr) {
            int leftVal = array[leftPtr];
            int rightVal = array[rightPtr];

            array[rightPtr--] = leftVal;
            array[leftPtr++] = rightVal;
        }
    }

    public static void main(String[] args) {
        Reverse reverse = new Reverse();

        int[] testArray = new int[] { 0, 1, 2, 3, 4};
        reverse.reverse(testArray);

        System.out.println(Arrays.toString(testArray));
    }

}
