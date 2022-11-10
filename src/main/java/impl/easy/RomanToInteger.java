package impl.easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    private final Map<String, Integer> map = new HashMap<String, Integer>() {
        {
            put("I", 1);
            put("IV", 4);
            put("V", 5);
            put("IX", 9);
            put("X", 10);
            put("XL", 40);
            put("L", 50);
            put("XC", 90);
            put("C", 100);
            put("CD", 400);
            put("D", 500);
            put("CM", 900);
            put("M", 1000);
        }
    };

    public int romanToInt(String s) {
        if(s.length() == 0) return 0;
        if(s.length() == 1) return map.get(s);

        String firstStr = s.substring(0, 1);
        String twoStr = s.substring(0, 2);

        int val, offset;
        if(map.containsKey(twoStr)) {
            val = map.get(twoStr);
            offset = 2;
        } else {
            val = map.get(firstStr);
            offset = 1;
        }

        return val + romanToInt(s.substring(offset));
    }

    public static void main(String[] args) {

        RomanToInteger roman = new RomanToInteger();
        System.out.println(roman.romanToInt("III"));
        System.out.println(roman.romanToInt("LVIII"));
        System.out.println(roman.romanToInt("MCMXCIV"));

    }
}
