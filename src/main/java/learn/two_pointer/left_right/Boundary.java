package learn.two_pointer.left_right;

public class Boundary {

    public int LeftBoundary(int[] numbers, int target) {
        if(numbers.length == 0) {
            return -1;
        }

        int leftPtr = 0;
        int rightPtr = numbers.length;

        while (leftPtr < rightPtr) {
            int mid = (rightPtr + leftPtr) / 2;

            if(numbers[mid] == target) {
                rightPtr = mid;
            } else if(numbers[mid] > target) {
                // target on left
                rightPtr = mid;         // Notice
            } else if(numbers[mid] < target) {
                // target on right
                leftPtr = mid + 1;
            }
        }

        return leftPtr;
    }

    public int LeftBoundary_2(int[] numbers, int target) {
        if(numbers.length == 0) {
            return -1;
        }

        int leftPtr = 0;
        int rightPtr = numbers.length - 1;

        while (leftPtr <= rightPtr) {
            int mid = leftPtr + (rightPtr - leftPtr) / 2;

            if(numbers[mid] == target) {
                rightPtr = mid + 1;
            } else if(numbers[mid] > target) {
                // target on left
                rightPtr = mid + 1;         // Notice
            } else if(numbers[mid] < target) {
                // target on right
                leftPtr = mid + 1;
            }
        }

        if(leftPtr == numbers.length || numbers[leftPtr] != target) {
            return -1;
        }
        return leftPtr;
    }
}