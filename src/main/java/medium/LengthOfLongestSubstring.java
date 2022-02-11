package medium;

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

    private int lastTimeOffset = 0;

    private int findSameCharIndexWithRecord(char[] source, char target) {
        for (int result = lastTimeOffset; result < source.length; result++) {
            lastTimeOffset++;
            char c = source[result];
            if (c == target) {
                break;
            }
        }

        return lastTimeOffset;
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
        if(originalArray.length != setArray.length) {
            throw new RuntimeException();
        }

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

    private int fixCharArray(char[] sourceArray, char[] cacheArray, char value) {
        int len = getNonZeroLen(cacheArray);

        for (char c : cacheArray) {
            if (c == '\u0000') {
                break;
            }

            if (c == value) {
                int start = findSameCharIndexWithRecord(sourceArray, c);

                setAndClearArray(sourceArray, cacheArray, start - 1, findSameCharIndex(cacheArray, value));

                cacheArray[getNonZeroLen(cacheArray)] = value;

                return len;
            }
        }

        cacheArray[len] = value;

        return len;
    }

    public int lengthOfLongestSubstring(String s) {
        int index = 0, longest = 0;

        char[] chars = s.toCharArray();
        char[] cache = new char[chars.length];

        while(index < chars.length) {

            int oldLen = fixCharArray(chars, cache, chars[index]);

            int temp = Math.max(oldLen, getNonZeroLen(cache));
            if(longest < temp) {
                longest = temp;
            }

            index++;
        }

        lastTimeOffset = 0;

        return longest;
    }

}
