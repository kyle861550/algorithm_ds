package standard.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CompleteRange {

    public List<List<Integer>> getCompleteRange(int[] array) {
        List<List<Integer>> result = new ArrayList<>();

        _getCompleteRange(array, new Stack<>(), result);

        return result;
    }

    private void _getCompleteRange(int[] array,
                                  Stack<Integer> memo,
                                  List<List<Integer>> result) {

        if(array.length == memo.size()) {
            List<Integer> tmp = new ArrayList<>(memo);
            result.add(tmp);
            return;
        }

        for(int item : array) {
            if(memo.contains(item)) {
                continue;
            }

            memo.push(item);

            _getCompleteRange(array, memo, result);

            memo.pop();
        }
    }


    public static void main(String[] args) {
        CompleteRange completeRange = new CompleteRange();

        int[] test = {
                1, 2, 3
        };

        List<List<Integer>> result = completeRange.getCompleteRange(test);

        for(List<Integer> subResult: result) {
            System.out.println(subResult);
        }
    }
}
