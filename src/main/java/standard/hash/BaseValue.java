package standard.hash;

import java.util.Arrays;

public class BaseValue {


    public int base10(String value) {
        int base = 10, result = 0;

        char[] chars = value.toCharArray();
        int index = chars.length - 1;

        while (index >= 0) {
            int curNum = (int) chars[index] - '0';

            result = result + (int) (curNum * Math.pow(base, chars.length-1 - index));

            index -= 1;
        }

        return result;
    }

    public long base26(String value) {
        int base = 26;
        long result = 0;

        char[] chars = value.toLowerCase().toCharArray();
        int index = chars.length - 1;

        while (index >= 0) {
            int curNum = (int) chars[index] - 'a';

            result = result + (int) (curNum * Math.pow(base, chars.length-1 - index));

            index -= 1;
        }

        return result;
    }

    public static void main(String[] args) {
//        System.out.println("Base10 \"9527\": " + new BaseValue().base10("9527"));

//        System.out.println("Base26: \"june\": " + new BaseValue().base26("june"));
//        System.out.println("Base26: \"August\": " + new BaseValue().base26("August"));
//        System.out.println("Base26: \"August\" % 34: " + new BaseValue().base26("August") % 34);

        String[] month_key_array = new String[] {
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        };
        int[] month_length = new int[] {
                31, 28, 31, 30, 31, 30,
                31, 31, 30, 31, 30, 31
        };

        int[] result = new int[34];
        Arrays.fill(result, -1);

        BaseValue baseValue = new BaseValue();
        for (int i = 0; i < month_key_array.length; i++) {
            String mon = month_key_array[i];

            int index = (int) (baseValue.base26(mon) % 34);
            result[index] = month_length[i];
        }
        System.out.println("Finally: " + Arrays.toString(result));
    }
}
