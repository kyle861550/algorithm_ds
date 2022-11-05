package impl.medium;

public class ReverseInteger {

    public int reverse(int x) {
        boolean isNeg = x < 0;
        if(isNeg) {
            x =- x;
        }

        String valStr = String.valueOf(x);

        char[] tmpSource = valStr.toCharArray();
        int left = 0, right = tmpSource.length - 1;

        long result = 0;
        while (left < right) {
            char leftVal = tmpSource[left];
            char rightVal = tmpSource[right];

            tmpSource[left] = rightVal;
            tmpSource[right] = leftVal;

            int leftValInt = (tmpSource[left] - '0');
            result += leftValInt * Math.pow(10, right);

            int rightValInt = (tmpSource[right] - '0');
            result += rightValInt * Math.pow(10, left);

            if(result > Integer.MAX_VALUE) {
                return 0;
            }

            left++;
            right--;
        }

        if(tmpSource.length % 2 != 0) {
            int middle = tmpSource.length / 2;
            int val = tmpSource[middle] - '0';
            result += val * Math.pow(10, middle);
        }

        return (int) (isNeg ? -result : result);
    }

    public int reverse_official(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        ReverseInteger r = new ReverseInteger();

        System.out.println("Reverse 123: " + r.reverse(123));
        System.out.println("\nReverse -123: " + r.reverse(-123));
        System.out.println("\nReverse 120: " + r.reverse(120));
        System.out.println("\nReverse 1249: " + r.reverse(1249));
        System.out.println("\nReverse 1534236469: " + r.reverse(1534236469));
    }


}
