package learn.two_pointer.slide_window;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class StringSort {

    public boolean hasSubString(String originalStr, String keyStr) {
        char[] oriChars = originalStr.toCharArray();
        char[] keyChars = keyStr.toCharArray();

        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();

        for(char c : keyChars) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;

        int valid = 0;

        while (right < oriChars.length) {

            char rightChar = oriChars[right++];

            if(need.get(rightChar) == null || need.get(rightChar) == 0) {
                continue;
            }

            window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);

            if(Objects.equals(window.get(rightChar), need.get(rightChar))) {
                valid++;
            }

            while (right - left >= keyChars.length) {
                if(valid == need.size()) {
                    return true;
                }

                char leftChar = oriChars[left++];

                if(need.get(leftChar) == null || need.get(leftChar) == 0) {
                    continue;
                }
                if(Objects.equals(window.get(leftChar), need.get(leftChar))) {
                    valid--;
                }

                window.put(leftChar, window.getOrDefault(leftChar, 0) - 1);
            }

        }

        return false;
    }

    public static void main(String[] args) {
        StringSort stringSort = new StringSort();

        boolean b = stringSort.hasSubString("helloworld", "oow");

        System.out.println("Has sub string: " + b);
    }
}
