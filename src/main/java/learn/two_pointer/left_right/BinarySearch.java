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

    public int binarySearch_2(int numbers[], int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if(numbers[mid] == target) {
                return mid;

            } else if(numbers[mid] > target) {
                right = mid - 1;

            } else if(numbers[mid] < target) {
                left = mid + 1;
            }

        }

        System.out.println("Left: " + left + ", right: " + right);

        return -(numbers.length - left);
    }

    public int binarySearch_3(int numbers[], int target) {
        int left = 0;
        int right = numbers.length - 1;

        int times = 0;

        while (left <= right) {

            System.out.println("Times: " + ++times);

            int mid = left + (right - left) / 2;

            int diff = numbers[mid] - target;

            if(diff == 0) {
                return mid;

            } else if(diff > 0) {
                right = mid - 1;

            } else if(diff < 0) {
                left = mid + 1;
            }

        }

        System.out.println("Left: " + left + ", right: " + right);

        return -(numbers.length - left);
    }
    public static void main(String[] args) {
        int[] numbers = new int[] {3, 14, 15, 19, 26, 53, 58};

//        System.out.println("Find 53 index: "
//                + new BinarySearch().binarySearch(numbers, 53));

//        System.out.println("Find 47 index: "
//                + new BinarySearch().binarySearch_2(numbers, 47));

        System.out.println("Find 3 index: "
                + new BinarySearch().binarySearch_3(numbers, 3));
    }

}
