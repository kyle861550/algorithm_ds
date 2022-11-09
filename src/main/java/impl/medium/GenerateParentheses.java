package impl.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        backtrace(new StringBuilder(), result, 0, 0, n);

        return result;
    }

    public void backtrace(StringBuilder cur, List<String> result, int open, int close, int singleMax) {
        if(singleMax * 2 == cur.length()) {
            result.add(new String(cur));
        }

        if(open < singleMax) {      // Add 'C' first
            cur.append('(');
            backtrace(cur, result, open + 1, close, singleMax);
            cur.deleteCharAt(cur.length() - 1);
        }

        if(open > close) {          // Then add ')'
            cur.append(')');
            backtrace(cur, result, open, close + 1, singleMax);
            cur.deleteCharAt(cur.length() - 1);
        }
    }


    public static void main(String[] args) {
//        GenerateParentheses parentheses = new GenerateParentheses();
//
//        List<String> strings = parentheses.generateParenthesis(3);
//
//        System.out.println(strings.toString());

        double tan = Math.tan(Math.toRadians(45));

        System.out.println("Test: " + tan);
    }

}

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<>();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    public void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current))
                result.add(new String(current));
        } else {
            current[pos] = '(';
            generateAll(current, pos+1, result);
            current[pos] = ')';
            generateAll(current, pos+1, result);
        }
    }

    public boolean valid(char[] current) {
        int balance = 0;
        for (char c: current) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return (balance == 0);
    }
}
