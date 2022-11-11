package impl.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LetterCombinations {

    private final Map<Character, char[]> phoneMap = new HashMap<>() {
        {
            put('2', new char[]{'a', 'b', 'c'});
            put('3', new char[]{'d', 'e', 'f'});
            put('4', new char[]{'g', 'h', 'i'});
            put('5', new char[]{'j', 'k', 'l'});
            put('6', new char[]{'m', 'n', 'o'});
            put('7', new char[]{'p', 'q', 'r', 's'});
            put('8', new char[]{'t', 'u', 'v'});
            put('9', new char[]{'w', 'x', 'y', 'z'});
        }
    };

    public List<String> letterCombinations(String digits) {
        LinkedList<String> result = new LinkedList<>();

        if(digits.length() > 0) {
            char[] chars = digits.toCharArray();

            backtrace(chars, new StringBuilder(), result, 0);
        }

        return result;
    }

    public void backtrace(char[] request,
                          StringBuilder builder,
                          LinkedList<String> result, int start) {

        if(request.length == builder.length()) {
            result.add(builder.toString());
            return;
        }

        char[] chars = phoneMap.get(request[start]);

        for (char sub : chars) {
            builder.append(sub);

            backtrace(request, builder, result, start + 1);

            builder.deleteCharAt(builder.length() - 1);
        }

    }

    public static void main(String[] args) {
        LetterCombinations combinations = new LetterCombinations();

        System.out.println(combinations.letterCombinations(""));
        System.out.println(combinations.letterCombinations("2"));
        System.out.println(combinations.letterCombinations("23"));
    }
}
