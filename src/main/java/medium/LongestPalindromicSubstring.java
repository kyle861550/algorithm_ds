package medium;

import java.util.ArrayList;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        LongestPalindromicSubstring s = new LongestPalindromicSubstring();

//        System.out.println("babad: " + s.longestPalindrome("babad"));
//        System.out.println("cbbd: " + s.longestPalindrome("cbbd"));
        System.out.println("ac: " + s.longestPalindrome("ac"));
    }

    private boolean checkStr(String s) {
        boolean result = true;

        int count = s.length() % 2;

        for(int i = 0, j = s.length() -1;; i++, j--) {
            char startChar = s.charAt(i);
            char endChar = s.charAt(j);

            if(startChar != endChar) {
                result = false;
                break;
            }

            if(count == 0) {
                if(j - i == 1) {
                    break;
                }
            } else {
                if(i - j == 2) {
                    break;
                }
            }
        }

        return result;
    }

    public String longestPalindrome(String s) {
        String longestStr = "";

        ArrayList<String> record = new ArrayList<>();

        int oneWordIndex = 0;
        while (oneWordIndex < s.length()) {
            String singleWord = s.substring(oneWordIndex, oneWordIndex + 1);
            oneWordIndex++;

            if(record.contains(singleWord)) {
                continue;
            }
            record.add(singleWord);

            int lastStartIndex = 0;
            while (true) {
                int startIndex = s.indexOf(singleWord, lastStartIndex);
                int endIndex = s.lastIndexOf(singleWord);

                if(startIndex == endIndex) {
                    if(longestStr.isEmpty()) {
                        longestStr = singleWord;
                    }
                    break;
                }
                String substring = s.substring(startIndex, endIndex + 1);

                if(checkStr(substring) && longestStr.length() < substring.length()) {
                    longestStr = substring;
                }

                lastStartIndex = startIndex + 1;
            }
        }

        return longestStr;
    }

}
