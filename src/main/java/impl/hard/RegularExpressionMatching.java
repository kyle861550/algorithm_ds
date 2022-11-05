package impl.hard;

import java.util.HashMap;
import java.util.Map;

public class RegularExpressionMatching {

    public boolean isMatch_self(String s, String p) {
        Map<Character, Integer> condition = new HashMap<>();

        for(Character item : p.toCharArray()) {
            if(!item.equals('.') && !item.equals('*')) {
                condition.put(item, condition.getOrDefault(item, 0) + 1);
            }
        }

        int start = 0 , end = 0;

        char[] source = s.toCharArray();

        while (end < source.length) {
            char item = source[end++];

            Integer request = condition.get(item);
            if(request != null && request < 0) {
                return false;
            } else if (request != null && request > 0) {
                condition.put(item, condition.getOrDefault(item, 0) - 1);
            } else if(request != null) {

            }

            while (start < end) {
                char startItem = source[start];

                if(item == '.') {
                    start += 1;

                } else if(item == '*' && item == startItem) {
                    start += 1;

                } else {
                    break;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

    }
}

enum Result {
    TRUE, FALSE
}

class Solution {
    Result[][] memo;

    public boolean isMatch(String text, String pattern) {
        memo = new Result[text.length() + 1][pattern.length() + 1];
        return dp(0, 0, text, pattern);
    }

    public boolean dp(int i, int j, String text, String pattern) {
        if (memo[i][j] != null) {
            return memo[i][j] == Result.TRUE;
        }
        boolean ans;
        if (j == pattern.length()){
            ans = i == text.length();
        } else{
            boolean first_match = (i < text.length() &&
                    (pattern.charAt(j) == text.charAt(i) ||
                            pattern.charAt(j) == '.'));

            if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
                ans = (dp(i, j+2, text, pattern) ||
                        first_match && dp(i+1, j, text, pattern));
            } else {
                ans = first_match && dp(i+1, j+1, text, pattern);
            }
        }
        memo[i][j] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }
}
