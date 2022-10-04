package standard.hash;

import java.util.HashMap;
import java.util.Map;

public class Compare {

    private static int[] month_length = new int[] {
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
    };

    private static String[] month_key_array = new String[] {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
    };

    public int iteration_month(String month) {
        int result = -1;

        for (int i = 0; i < month_key_array.length; i++) {
            String mon = month_key_array[i];
            if (mon.equals(month)) {
                result = i;
                break;
            }
        }

        return result != -1 ? month_length[result] : -1;
    }

    private static final Map<String, Integer> monthMap = new HashMap<>() {
        {
            put("January", 31); put("February", 28); put("March", 31);
            put("April", 30); put("May", 31); put("June", 30);
            put("July", 31); put("August", 31); put("September", 30);
            put("October", 31); put("November", 30); put("December", 31);
        }
    };

    public int hash_month(String month) {
        return monthMap.getOrDefault(month, -1);
    }

    public static void main(String[] args) {

    }

}
