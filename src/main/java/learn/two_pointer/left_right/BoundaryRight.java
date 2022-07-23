package learn.two_pointer.left_right;

public class BoundaryRight {

    private int BoundaryLeft(int[] numbers, int target) {
        if(numbers.length == 0) {
            return -1;
        }

        int leftPtr = 0;
        int rightPtr = numbers.length;

        while (leftPtr < rightPtr) {
            int mid = (leftPtr + rightPtr) / 2;

            if(numbers[mid] == target) {
                leftPtr = mid + 1;

            } else if(numbers[mid] > target) {
                rightPtr = mid;

            } else if(numbers[mid] < target) {
                leftPtr = mid + 1;

            }
        }
        return leftPtr - 1;
    }


    private int BoundaryLeft_2(int[] numbers, int target) {
        if(numbers.length == 0) {
            return -1;
        }

        int leftPtr = 0;
        int rightPtr = numbers.length - 1;

        while (leftPtr <= rightPtr) {
            int mid = leftPtr + (rightPtr - leftPtr) / 2;

            if(numbers[mid] == target) {
                leftPtr = mid + 1;

            } else if(numbers[mid] > target) {
                rightPtr = mid - 1;

            } else if(numbers[mid] < target) {
                leftPtr = mid + 1;

            }
        }

        if(rightPtr == numbers.length || numbers[rightPtr] != target) {
            return -1;
        }

//        return leftPtr + 1;
        return rightPtr;
    }

}
