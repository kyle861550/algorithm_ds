package medium;

import java.util.Arrays;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        LengthOfLongestSubstring s = new LengthOfLongestSubstring();

        String[] test = {
                "dvdf",         // 3
                "aabaab!bb",    // 3
                "pw1234wkew",   // 7
                "bbtablud",     // 6
                "pwwkew"        // 3
        };

        for (String str : test) {
            System.out.println(str + ": " + s.lengthOfLongestSubstring(str));
        }

//        String singleTest = "pw1234wkew";
//        System.out.println(singleTest + ": " + s.lengthOfLongestSubstring("pw1234wkew"));


    }

    private void debug(char[] source) {
        System.out.println(Arrays.toString(source));
    }

    private int findSameCharIndexWithRecord(char[] source, char target, int recode) {
        for (int result = recode; result < source.length; result++) {
            recode++;
            char c = source[result];
            if (c == target) {
                break;
            }
        }

        return recode;
    }

    private int findSameCharIndex(char[] source, char target) {
        int result = 0;
        for (char c : source) {
            if (c == target) {
                break;
            }
            result++;
        }

        return result;
    }

    private void setAndClearArray(char[] originalArray, char[] setArray, int oStart, int setArrayOffset) {
        int copyTimes = 0;

        for (int i = oStart + 1, length = setArray.length; i < length; i++) {
            if (setArray[++setArrayOffset] == '\u0000') {
                break;
            }

            setArray[copyTimes++] = originalArray[i];
        }

        for (int i = copyTimes, length = setArray.length; i < length; i++) {
            if (setArray[i] == '\u0000') {
                break;
            }
            setArray[i] = '\u0000';
        }

    }

    private int getNonZeroLen(char[] array) {
        int result = 0;
        for (char c : array) {
            if (c == '\u0000') {
                break;
            }
            result ++;
        }

        return result;
    }

    private int fixCharArray(char[] sourceArray, char[] cacheArray, char value, int lastTimeOffset, int dataIndex) {
        for (char c : cacheArray) {
            if (c == '\u0000') {
                break;
            }

            if (c == value) {
                lastTimeOffset = findSameCharIndexWithRecord(sourceArray, c, lastTimeOffset);

                setAndClearArray(sourceArray, cacheArray, lastTimeOffset - 1, findSameCharIndex(cacheArray, value));

                cacheArray[getNonZeroLen(cacheArray)] = value;

//                debug(cacheArray);

                return lastTimeOffset;
            }
        }

        cacheArray[dataIndex] = value;

//        debug(cacheArray);

        return lastTimeOffset;
    }

    public int lengthOfLongestSubstring(String s) {
        int index = 0, longest = 0;

        char[] chars = s.toCharArray();
        char[] cache = new char[chars.length];

        int lastTimeOffset = 0;

        while(index < chars.length) {

            int cacheIndex = getNonZeroLen(cache);

            lastTimeOffset = fixCharArray(chars, cache, chars[index], lastTimeOffset, cacheIndex);

            int temp = Math.max(cacheIndex, getNonZeroLen(cache));
            if(longest < temp) {
                longest = temp;
            }

            index++;
        }

        return longest;
    }

}
