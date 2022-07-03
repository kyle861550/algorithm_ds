package impl.easy;

public class PalindromeNumber {

    public static void main(String[] args) {
        PalindromeNumber p = new PalindromeNumber();

        System.out.println("121: " + p.isPalindrome(121));

        System.out.println("-121: " + p.isPalindrome(-121));

        System.out.println("10: " + p.isPalindrome(10));

        System.out.println("0: " + p.isPalindrome(0));
    }

    public boolean isPalindrome(int x) {
        boolean result = true;

        String s = Integer.toString(x);
        char[] chars = s.toCharArray();

        int p = 0, e = chars.length - 1;
        boolean isEven = chars.length % 2 == 0;
        while (true) {
            if(isEven) {
                if(p - e == 1 ) {
                    break;
                }
            } else {
                if(p == e) {
                    break;
                }
            }

            char startChar = chars[p++];
            char endChar = chars[e--];

            if(startChar != endChar) {
                result = false;
                break;
            }
        }

        return result;
    }
}
