package impl.medium;

public class IntegerToRoman {

    public static final class Node {
        private Node next;
        private final int val;
        private final String symbol;

        public Node(int val, String symbol) {
            this.val = val;
            this.symbol = symbol;
        }

        public Node(int val, String symbol, Node node) {
            this(val, symbol);
            node.next = this;
        }
    }

    public String intToRoman(int num) {
        Node M = new Node(1000, "M");
        Node D = new Node(500, "D", M);
        Node C = new Node(100, "C", D);
        Node L = new Node(50, "L", C);
        Node X = new Node(10, "X", L);
        Node V = new Node(5, "V", X);
        new Node(1, "I", V);

        StringBuilder res = new StringBuilder();
        _intToRoman(num, M, res, M);
        return res.toString();
    }

    private void _intToRoman(int num, Node node, StringBuilder builder, Node source) {
        if(num == 0 || node == null) {
            return;
        }

        int tmp = num;
        int times = 0;
        while (tmp > 10) {
            tmp = tmp / 10;
            times += 1;
        }

        int firstNum = tmp * (int) Math.pow(10, times);
        String symbol = null;

        Node tmpNode = source;
        while (tmpNode != null) {

            Node tmpNode2 = tmpNode.next;
            while (tmpNode2 != null) {

                if(firstNum == tmpNode2.val) {
                    symbol = tmpNode2.symbol;
                    break;
                }
                if(firstNum == tmpNode.val - tmpNode2.val) {
                    symbol = tmpNode2.symbol + tmpNode.symbol;
                    break;
                }
                tmpNode2 = tmpNode2.next;
            }

            if(symbol != null) {
                break;
            }
            tmpNode = tmpNode.next;
        }

        int remain;
        if(symbol == null) {
            int ans = num / node.val;
            builder.append(String.valueOf(node.symbol).repeat(Math.max(0, ans)));
            remain = num % node.val;
        } else {
            builder.append(symbol);
            remain = num - firstNum;
        }


        _intToRoman(remain, node.next, builder, source);
    }

    public String intToRoman_ans(int num) {

        // Approach:
        // This method uses two arrays with the corresponding integer-roman map, in descending order.

        int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder romanNumeral = new StringBuilder();

        for (int i = 0; i < value.length && num > 0; i++) {
            // Check from the highest value, 1000 to the smallest.
            // If it is possible to subtract, for example 400, we know the roman numeral next is "CD".
            while (num >= value[i]) {
                romanNumeral.append(roman[i]);
                num -= value[i];
            }
        }
        return romanNumeral.toString();
    }

    public static void main(String[] args) {
        IntegerToRoman roman = new IntegerToRoman();

        System.out.println("roman: " + roman.intToRoman(1994));
        System.out.println("roman: " + roman.intToRoman(3));
        System.out.println("roman: " + roman.intToRoman(58));
    }
}
