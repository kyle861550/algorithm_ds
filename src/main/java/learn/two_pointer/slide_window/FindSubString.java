package learn.two_pointer.slide_window;

import java.util.*;

public class FindSubString {

    public int[] findSubString(String originalStr, String findStr) {
        List<Integer> result = new ArrayList<>();

        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();

        char[] originalChars = originalStr.toCharArray();
        char[] findChars = findStr.toCharArray();

        for(char c : findChars) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;

        int valid = 0;

        while (right < originalChars.length) {

            char rightChar = originalChars[right++];

            if(need.get(rightChar) == null || need.get(rightChar) == 0) {
                continue;
            }

            window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);

            if(Objects.equals(window.get(rightChar), need.get(rightChar))) {
                valid++;
            }

            while (right - left >= findChars.length) {
                char leftChar = originalChars[left++];

                if(valid == findChars.length) {
                    result.add(left - 1);
                    System.out.println("Result item: " + originalStr.substring(left - 1, right));
                }


                if(need.get(leftChar) == null || need.get(leftChar) == 0) {
                    continue;
                }

                if(Objects.equals(window.get(leftChar), need.get(leftChar))) {
                    valid--;
                }

                window.put(leftChar, window.getOrDefault(leftChar, 0) - 1);
            }

        }

        int[] array = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            array[i] = result.get(i);
        }
        return array;
    }

    public static void main(String[] args) {
        FindSubString findSubString = new FindSubString();
        int[] subString = findSubString.findSubString("cbaebabacd", "abc");

        System.out.println("Result: " + Arrays.toString(subString));
    }

}
