package learn.two_pointer.left_right;

public class TwoNumSum {
    
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {

            int sum = numbers[left] + numbers[right];

            if(sum == target) {
                return new int[] {left + 1, right + 1};
            } else if(sum > target) {
                // sum on target's right part
                // must reduce sums
                right--;
            } else if(sum < target) {
                // sum on target left part
                // must puls sums
                left++;
            }
        }

        return null;
    }
    
}
