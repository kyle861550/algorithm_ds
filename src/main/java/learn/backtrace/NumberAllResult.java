package learn.backtrace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NumberAllResult {

    public void backtrace(int[] numbers, LinkedList<Integer> recordList, List<List<Integer>> result) {
        // finish condition
        if (numbers.length == recordList.size()) {
            result.add(new ArrayList<>(recordList));
            return;
        }

        // status choose
        for (int item : numbers) {
            if (recordList.contains(item)) {
                continue;
            }

            recordList.addLast(item);

            backtrace(numbers, recordList, result);

            recordList.removeLast();
        }

    }

    public static void main(String[] args) {
        NumberAllResult numberAllResult = new NumberAllResult();

        List<List<Integer>> result = new ArrayList<>();
        numberAllResult.backtrace(new int[] {1, 2, 3}, new LinkedList<>(), result);

        System.out.println("result: " + result);
    }

}
