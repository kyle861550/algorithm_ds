package easy;

import java.util.Arrays;

public class TwoSum {

    public static void main(String[] args) {
        TwoSum t = new TwoSum();

        int[] tt = new int[] {
                2, 7, 11, 15
        };

        tt = t.twoSum(tt, 9);

        System.out.println(Arrays.toString(tt));
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        int rootIndex = 0;
        int mvIndex = 1;

        int limit = nums.length - 1;

        while(rootIndex < limit) {

            if(mvIndex > limit) {
                rootIndex++;
                mvIndex = rootIndex + 1;
            }

            int testValue = nums[rootIndex] + nums[mvIndex];

            if(target == testValue) {
                result[0] = rootIndex;
                result[1] = mvIndex;
                break;
            }

            mvIndex++;
        }

        return result;

    }
}
