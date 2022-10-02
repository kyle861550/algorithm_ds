package learn.effect;

import java.util.*;

public class Championship {

    private static final int[] tournament = new int[] {3, 1, 4, 1, 5, 9, 2, 6};

    public int findMax() {
        int result = tournament[0];

        for (int i = 1; i < tournament.length; i++) {
            int item = tournament[i];

            if (item > result) {
                result = item;
            }
        }

        return result;
    }

    public int[] findMaxAndSecond() {

        int len = tournament.length;

        int[] winner = new int[len - 1];
        int[] loser = new int[len - 1];

        int id = 0;

        for (int i = 0; i < tournament.length; i += 2) {

            int winnerTmp = tournament[i];
            int loserTmp = tournament[i + 1];

            if(loserTmp > winnerTmp) {
                int tmp = winnerTmp;
                winnerTmp = loserTmp;
                loserTmp = tmp;
            }

            winner[id] = winnerTmp;
            loser[id] = loserTmp;

            id += 1;
        }

        int[] lastCompareResult = new int[len - 1];
        Arrays.fill(lastCompareResult, -1);

        int cIndex = 0;
        while (id < len - 1) {

            if(winner[cIndex] > winner[cIndex + 1]) {
                winner[id] = winner[cIndex];
                loser[id] = winner[cIndex + 1];

                lastCompareResult[id] = cIndex;
            } else {
                winner[id] = winner[cIndex + 1];
                loser[id] = winner[cIndex];

                lastCompareResult[id] = cIndex + 1;
            }

            cIndex += 2;
            id += 1;
        }

        int largest = winner[cIndex];
        int second = loser[cIndex];

        cIndex = lastCompareResult[cIndex];
        while (cIndex >= 0) {
            System.out.println("log compare: " + second + " < " + loser[cIndex] + "?");
            if(second < loser[cIndex]) {
                second = loser[cIndex];
            }
            cIndex = lastCompareResult[cIndex];
        }

        return new int[] {largest, second};
    }

    public static void main(String[] args) {
//        System.out.println("Max: " + new Championship().findMax());

        System.out.println("Max: " + Arrays.toString(new Championship().findMaxAndSecond()));
    }

}
