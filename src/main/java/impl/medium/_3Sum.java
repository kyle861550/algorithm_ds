package impl.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _3Sum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> numList = new LinkedList<>();
        for (int n : nums) {
            numList.add(n);
        }

        backtrace(numList, result, new LinkedList<>());

        return result;
    }

    public void backtrace(LinkedList<Integer> nums, List<List<Integer>> result, LinkedList<Integer> record) {
        System.out.println("record:" + Arrays.toString(record.toArray()));

        if (record.size() == 3 && record.get(0) + record.get(1) + record.get(2) == 0) {
            result.add(new ArrayList<>(record));
            return;
        }

        for (int i = 0; i < nums.size(); i++) {
            int item = nums.get(i);

            record.add(item);

            nums.removeFirst();
            backtrace(nums, result, record);

            record.removeLast();
        }

    }

    public static void main(String[] args) {
        _3Sum sum = new _3Sum();

        List<List<Integer>> lists;

//        lists = sum.threeSum(new int[]{0, 0, 0});
//        System.out.println(Arrays.toString(lists.toArray()));
//
//        lists = sum.threeSum(new int[]{0, 1, 1});
//        System.out.println(Arrays.toString(lists.toArray()));

//        lists = sum.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
//        System.out.println(Arrays.toString(lists.toArray()));

        int[] ints = {-1, 0, 1, 2, -1, -4};
        Arrays.sort(ints);

        System.out.println(Arrays.toString(ints));
    }

}
