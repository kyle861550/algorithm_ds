package learn.effect;

import java.util.Arrays;

public class ListMax {

    public int findMaxValue(int[] array) {
        int max = Integer.MIN_VALUE;

        for(int item : array) {
            if(item > max) {
                max = item;
            }

            System.out.println("max: " + max);
        }

        return max;
    }

    public int findMaxValue_2(int[] array) throws ArrayIndexOutOfBoundsException {
        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            int item = array[i];
            if (item > max) {
                max = item;
            }

            System.out.println("max: " + max);
        }

        return max;
    }

    public int findMaxValue_3(int[] array) throws ArrayIndexOutOfBoundsException {
        for(int outSide : array) {
            boolean isMaxVal = true;

            System.out.println(outSide);

            for (int inside : array) {
                System.out.print(inside + " > " + outSide + " ?\n");

                if(inside > outSide) {
                    isMaxVal = false;
                    break;
                }
            }

            System.out.println("--------------");
            if(isMaxVal) {
                return outSide;
            }
        }

        return -1;
    }

    public int[] findMaxValueTwo(int[] array) throws ArrayIndexOutOfBoundsException {
        int large = array[0];
        int largeSecond = array[1];

        if(largeSecond > large) {
            int tmp = largeSecond;
            largeSecond = large;
            large = tmp;
        }

        for(int i = 2; i < array.length; i++) {
            int curVal = array[i];
            if(curVal > large) {
                int tmp = large;
                large = curVal;
                largeSecond = tmp;
            } else if(curVal > largeSecond) {
                largeSecond = curVal;
            }
        }

        return new int[] {large, largeSecond};
    }


    public static void main(String[] args) {
        int result;

//        result = new ListMax().findMaxValue(new int[] {1, 3, 5, 1, 2, 9, 1, 8});
//
//        System.out.println("finally result: " + result);
//
//        result = new ListMax().findMaxValue_2(new int[] {});
//
//        System.out.println("finally result 2: " + result);

//        result = new ListMax().findMaxValue_3(new int[] {1, 5, 2, 9, 3, 4});
//
//        System.out.println("finally result 3: " + result);

//        int bestCase = new ListMax().findMaxValue_3(new int[] {9, 1, 5, 2, 3, 4});
//
//        System.out.println("Best case: " + bestCase);
//
//        int worstCase = new ListMax().findMaxValue_3(new int[] {1, 2, 3, 4, 5, 9});
//
//        System.out.println("Worst case: " + worstCase);

//        int[] largeTwo = new ListMax().findMaxValueTwo(new int[] {1, 5, 2, 9, 3, 4});
//
//        System.out.println("Large two: " + Arrays.toString(largeTwo));

    }

}
