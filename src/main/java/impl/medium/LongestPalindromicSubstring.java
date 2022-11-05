package impl.medium;

import java.util.*;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        int resStart = 0, resEnd = 0;
        int left = 0;

        char[] source = s.toCharArray();

        while(left < source.length) {
            char curChar = source[left];

            int tmpStart = left;
            int tmpEnd = source.length - 1;
            while (tmpStart < tmpEnd) {
                char endChar = source[tmpEnd];

                if(curChar == endChar) {

                    if(resEnd - resStart < tmpEnd - tmpStart) {
                        resStart = tmpStart;
                        resEnd = tmpEnd;
                    }
                }

                tmpEnd -= 1;
            }

            left += 1;

        }

        return s.substring(resStart, resEnd + 1);
    }

    public String longestPalindrome_2(String s) {
        int resStart = 0, resEnd = 0;
        int left = 0, right = 0;

        Map<Character, Integer> window = new HashMap<>();

        char[] source = s.toCharArray();

        while(right < source.length) {
            char curChar = source[right];

            window.put(curChar, window.getOrDefault(curChar, 0) + 1);

            while (window.get(curChar) >= 2) {

                window.put(curChar, window.get(curChar) - 1);

                char curStart = source[left];
                if(curStart != curChar) {
                    left += 1;
                }

                if(resEnd - resStart < right - left) {
                    resStart = left;
                    resEnd = right;
                }
            }
            right += 1;
        }

        return s.substring(resStart, resEnd + 1);
    }


//    public String longestPalindrome_3(String s) {
//        int resStart = 0, resEnd = 0;
//        int left = 0, right = 0;
//
//        List<Character> window = new ArrayList<>();
//
//        char[] source = s.toCharArray();
//
//        while(right < source.length) {
//            char curChar = source[right];
//
//            window.add(curChar);
//
//            if(!window.contains(curChar)) {
//                continue;
//            }
//
//            int tmp = right - 1;
//            while () {
//                char compareItem = source[tmp--];
//
//                if(compareItem != ?) {
//                    break;
//                }
//            }
//
//            right += 1;
//        }
//
//        return s.substring(resStart, resEnd + 1);
//    }

    public static void main(String[] args) {
        LongestPalindromicSubstring s = new LongestPalindromicSubstring();

        System.out.println("Result: " + s.longestPalindrome("babad"));
        System.out.println("Result: " + s.longestPalindrome("cbbd"));
        System.out.println("Result: " + s.longestPalindrome("a"));
        System.out.println("Result: " + s.longestPalindrome("aacabdkacaa"));

        System.out.println("\nResult: " + s.longestPalindrome_2("babad"));
        System.out.println("Result: " + s.longestPalindrome_2("cbbd"));
        System.out.println("Result: " + s.longestPalindrome_2("a"));
        System.out.println("Result: " + s.longestPalindrome_2("aacabdkacaa"));
    }
}
