package learn.backtrace;

import java.util.LinkedList;
import java.util.function.Supplier;

public class NQueens {

    private void iterate(Character[][] array, Supplier<Character> supplier) {
        for (Character[] characters : array) {
            for (int i = 0; i < array.length; i++) {
                if (supplier == null) {
                    System.out.print("[" + characters[i] + "]");
                    continue;
                }
                characters[i] = supplier.get();
            }
            System.out.println();
        }
        System.out.println("------------------");
    }

    private void debug(Character[][] array) {
        iterate(array, null);
    }

    private Character[][] copy(Character[][] array) {
        int size = array.length;
        Character[][] result =  new Character[size][size];

        for (int i = 0; i < array.length; i++) {
            System.arraycopy(array[i], 0, result[i], 0, array.length);
        }

        return result;
    }

    public LinkedList<Character[][]> backtrace_nQueens(int n) {
        Character[][] board = new Character[n][n];

        iterate(board, () -> '.');
        debug(board);

        LinkedList<Character[][]> result = new LinkedList<>();

        backtrace(0, board, result);

        return result;
    }

    private void backtrace(int row, Character[][] board, LinkedList<Character[][]> result) {
        if(row == board.length - 1) {
//            debug(board);
            result.addLast(copy(board));
            return;
        }

        for(int col = 0; col < board.length; col++) {
            if(!isValid(board, row, col)) {
                continue;
            }

            board[row][col] = 'Q';

            backtrace(row + 1, board, result);

            board[row][col] = '.';
        }
    }

    private boolean isValid(Character[][] board, int row, int col) {
        for(int i = 0; i < row; i++) {
            if(board[i][col] == 'Q') {
                return false;
            }
        }

        int boardLimit = board.length;
        for(int i = row - 1, j = col + 1;
                i >= 0 && j < boardLimit; i--, j++) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }

        for(int i = row - 1, j = col - 1;
            i >= 0 && j >= 0; i--, j--) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();

        for (Character[][] backtrace_nQueen : nQueens.backtrace_nQueens(2)) {
            nQueens.debug(backtrace_nQueen);
        }

    }

}
