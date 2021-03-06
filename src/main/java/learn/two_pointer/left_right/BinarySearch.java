package learn.two_pointer.left_right;

public class BinarySearch {

//    public int binarySearch_Module(int[] array, int target) {
//        int left = 0;
//        int right = array.length - 1;
//
//        while(...) {
//            int mid = left + (right - left) / 2;
//
//            if(array[mid] == target) {
//                // TODO:
//            } else if(array[mid] > target) {
//                // TODO:
//            } else if(array[mid] < target) {
//                // TODO:
//            }
//        }
//
//        return ...;
//    }


    public int binarySearch(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left <= right) {
            int mid = (right + left) / 2;

            if(numbers[mid] == target) {
                return mid;
            } else if(numbers[mid] > target) {
               // target on left
               right = mid - 1;
            } else if(numbers[mid] < target) {
               // target on right
                left = mid + 1;
            }
        }

        return -1;
    }

}
