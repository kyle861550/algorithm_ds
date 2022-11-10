package impl.medium;

import java.util.List;

public class FindTheIndexOfTheFirstOccurrenceInAString {

    public int strStr(String haystack, String needle) {

        int right = 0;
        char[] chars = haystack.toCharArray();

        StringBuilder window = new StringBuilder();

        while (right < chars.length) {

            char rightChar = chars[right];

            window.append(rightChar);
            if(window.toString().equals(needle)) {
                return right - needle.length() + 1;
            }

            int index = 0;
            while (window.length() >= needle.length()) {
                if(needle.charAt(index) != window.charAt(index)) {
                    window.deleteCharAt(0);
                }
                index ++;
            }

            right += 1;

        }

        return -1;
    }

    public static void main(String[] args) {
        FindTheIndexOfTheFirstOccurrenceInAString string = new FindTheIndexOfTheFirstOccurrenceInAString();

        System.out.println("Result: " + string.strStr("sadbutsad", "sad"));
        System.out.println("Result: " + string.strStr("leetcode", "leeto"));
        System.out.println("Result: " + string.strStr("sabbutsad", "sad"));
        System.out.println("Result: " + string.strStr("sbssadbut", "sad"));

        System.out.println("Result: " + string.strStr("aaaaa", "bba"));
    }

    public int strStr2(String haystack, String needle) {
        // empty needle appears everywhere, first appears at 0 index
        if (needle.length() == 0)
            return 0;
        if (haystack.length() == 0)
            return -1;


        for (int i = 0; i < haystack.length(); i++) {
            // no enough places for needle after i
            if (i + needle.length() > haystack.length()) break;

            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i+j) != needle.charAt(j))
                    break;
                if (j == needle.length()-1)
                    return i;
            }
        }

        return -1;
    }
}
