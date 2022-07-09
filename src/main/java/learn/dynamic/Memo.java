package learn.dynamic;

import java.util.HashMap;

public class Memo {

    int step = 0;
    private int fibonacciArray(int value) {
        if(value == 0) return 0;

        int[] memo = new int[value + 1];

        return cancelByArray(value, memo);
    }

    private int cancelByArray(int value, int[] memo) {
        if(value == 1 || value == 2) {
            return 1;
        }

        if(memo[value] != 0) {
            System.out.println("value: " + value + ", memo[value]: " + memo[value]);
            return memo[value];
        }

        memo[value] = cancelByArray(value - 1, memo) + cancelByArray(value - 2, memo);

        System.out.println("Step: " + ++step);

        return memo[value];
    }

    private int fibonacciHashMap(int value) {
        if(value == 0) return 0;

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        return cancelByHashMap(value, hashMap);
    }

    private int cancelByHashMap(int value, HashMap<Integer, Integer> hashMap) {
        if(value == 1 || value == 2) {
            return 1;
        }

        Integer memoValue = hashMap.get(value);
        if(memoValue != null && memoValue != 0) {
            System.out.println("value: " + value + ", memo[value]: " + memoValue);
            return memoValue;
        }

        int result = cancelByHashMap(value - 1, hashMap) + cancelByHashMap(value - 2, hashMap);

        hashMap.put(value, result);

        System.out.println("Step: " + ++step);

        return result;
    }

    public static void main(String[] args) {
        Memo repeat = new Memo();

//        System.out.println("fibonacciArray: " + repeat.fibonacciArray(10));

        System.out.println("fibonacciHashMap: " + repeat.fibonacciHashMap(10));
    }

}
