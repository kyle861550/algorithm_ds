package learn.dynamic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Coins {

    private int lessCoinOptDpTable(int[] coins, int targetAmount) {
        int[] dp = new int[targetAmount + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);

        // base case
        dp[0] = 0;

        for(int i = 0; i < dp.length; i++) {
            for(int item : coins) {
                if(i - item < 0) continue;
                dp[i] = Math.min(dp[i], 1 + dp[i - item]);
            }
        }

        return dp[targetAmount] == Integer.MAX_VALUE ? -1 : dp[targetAmount];
    }

    private int lessCoinOpt(int[] coins, int targetAmount) {
        Map<Integer, Integer> memo = new HashMap<>();

        return cal(coins, targetAmount, memo);
    }

    private int cal(int[] coins, int targetAmount, Map<Integer, Integer> memo) {

        Integer value = memo.get(targetAmount);
        if(value != null && value != 0) {
            return value;
        }

        if(targetAmount == 0) return  0;

        if(targetAmount < 0) return -1;

        int result = Integer.MAX_VALUE;

        for(int item : coins) {
            int subProblem = cal(coins, targetAmount - item, memo);

            if(subProblem == -1) continue;

            result = Math.min(result, subProblem + 1);
        }

        memo.put(targetAmount, result == Integer.MAX_VALUE ? -1 : result);
        System.out.println("key:" + targetAmount + ", value: " + result);
        return result;
    }


    private int lessCoins(int[] coins, int targetAmount) {
//        System.out.println("targetAmount: " + targetAmount);

        if(targetAmount == 0) return 0;

        if(targetAmount < 0) return -1;

        int res = Integer.MAX_VALUE;

        for(int item : coins) {
            int subProblem = lessCoins(coins, targetAmount - item);

            if(subProblem == -1) continue;

            res = Math.min(res, subProblem + 1);
        }

//        System.out.println("res 2: " + res);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[]rgs) {
        Coins coins = new Coins();

//        int result = coins.lessCoins(new int[] {1, 5, 10}, 11);
//        int result = coins.lessCoinOpt(new int[] {1, 5, 10}, 11);
        int result = coins.lessCoinOptDpTable(new int[] {1, 5, 10}, 11);

        System.out.println("result: " + result);
    }

}
