package impl.easy;

public class ValidParentheses {

    public static void main(String[] args) {

        ValidParentheses p = new ValidParentheses();

        System.out.println("(): " + p.isValid("()"));

        System.out.println("()[]{}: " + p.isValid("()[]{}"));

        System.out.println("(]: " + p.isValid("(]"));

        System.out.println("{[]}: " + p.isValid("{[]}"));

        System.out.println("(){}}{: " + p.isValid("(){}}{"));

        System.out.println("(([]){}): " + p.isValid("(([]){})"));

        System.out.println("([]): " + p.isValid("([])"));

        System.out.println("(: " + p.isValid("("));


    }

    // refs solution
    public boolean isValid(String s) {

        int sIndex = 0;
        char[] stack = new char[s.length()];

        for(int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);

            if(curChar == '(' || curChar == '[' || curChar == '{') {
                stack[sIndex++] = curChar;

            } else if (sIndex == 0) {
                return false;
            } else {
                if ('}' == curChar && stack[--sIndex] != '{') {
                    return false;
                } else if (')' == curChar && stack[--sIndex] != '(') {
                    return false;
                } else if (']' == curChar && stack[--sIndex] != '[') {
                    return false;
                }
            }

        }

        return sIndex == 0;
    }
}
