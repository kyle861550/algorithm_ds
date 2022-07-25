package learn.two_pointer.slide_window;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MinSubString {

    private String slideWindow(String str, String target) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();

        for(char c : target.toCharArray()) {
            int count = window.getOrDefault(c, 0);
            need.put(c, ++count);
        }

        char[] strChars = str.toCharArray();
        char[] targetChars = target.toCharArray();

        int left = 0, right = 0;
        int valid = 0;
        int startIndex = 0, len = Integer.MAX_VALUE;     // result

        while (right < strChars.length) {
            char rightItem = strChars[right++];

            Integer rightCount = need.get(rightItem);

            if(rightCount == null || rightCount == 0) {
                continue;
            }

            Integer originRightCount = window.getOrDefault(rightItem, 0);
            window.put(rightItem, originRightCount + 1);

            if(Objects.equals(need.get(rightItem), window.get(rightItem))) {
                valid++;
            }

            while (valid == targetChars.length) {
                if(right - left < len) {
                    len = right - left;
                    startIndex = left;

                    System.out.println("Choose item: " + str.substring(startIndex, startIndex + len));
                }

                char leftItem = strChars[left++];

                Integer leftCount = need.get(leftItem);

                if(leftCount == null || leftCount == 0) {
                    continue;
                }

                if(Objects.equals(need.get(leftItem), window.get(leftItem))) {
                    valid--;
                }
                Integer originCount = window.get(leftItem);
                if(originCount != null) {
                    window.put(leftItem, originCount - 1);
                }
            }
        }

        return len == Integer.MAX_VALUE ? "" : str.substring(startIndex, startIndex + len);

    }

    public static void main(String[] args) {
        String str = "ADBECFEBANC";
        String find = "ABC";

        MinSubString minSubString = new MinSubString();
        String result = minSubString.slideWindow(str, find);

        System.out.println("\nResult: " + result);
    }

    private void normal(String str, String target) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();

        for(char c : target.toCharArray()) {
            int count = window.getOrDefault(c, 0);
            need.put(c, ++count);
        }

        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            int count = window.getOrDefault(c, 0);
            window.put(c, ++count);

            for (int j = i; j < chars.length; j++) {
                char pre = chars[i];
                int count2 = window.getOrDefault(pre, 0);
                window.put(c, ++count2);
                // TODO:
            }
        }
    }

}
