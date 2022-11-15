package impl.medium;

public class Search {

    public int search(int[] nums, int target) {         // Error
        int pivot = -1;

        for (int i = 0; i < nums.length; i++) {
            int item = nums[i];

            if(item == target) {
                boolean pass = rotate(nums, i);
                if(pass) {
                    pivot = i;
                }
                break;
            }
        }

        return pivot;
    }

    private boolean rotate(int[] nums, int pivot) {
        int[] result = new int[nums.length];

        int index = 0;
        while (index < result.length - 1) {

            if(pivot > nums.length - 1) {
                pivot = 0;
            }

            result[index] = nums[pivot++];

            if(index > 0 && result[index - 1] > result[index]) {
                return false;
            }

            index += 1;
        }

        return true;
    }

    public static void main(String[] args) {
        Search search = new Search();

        int res = search.search(new int[] {4, 5, 6, 7, 0, 1, 2}, 0);
        System.out.println("res: " + res);

        res = search.search(new int[] {4, 5, 6, 7, 0, 1, 2}, 3);
        System.out.println("res: " + res);

        res = search.search(new int[] {1}, 0);
        System.out.println("res: " + res);

        res = search.search(new int[] {1, 3, 5}, 5);
        System.out.println("res: " + res);
    }

}

class Solution_Search {
    public int search(int[] A, int target) {
        int lo = 0;
        int hi = A.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (A[mid] == target) return mid;

            if (A[lo] <= A[mid]) {
                if (target >= A[lo] && target < A[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (target > A[mid] && target <= A[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return A[lo] == target ? lo : -1;
    }
}