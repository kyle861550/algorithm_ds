package standard.hash;

public class Perfect_hash {

    public final int[] G = {0, 8, 1, 4, 7,10, 2, 0, 9, 11, 1, 5};

    public final int[] s1 = {9, 4, 8, 6, 6};
    public final int[] s2 = {2, 10, 6, 3, 5};

    public int hashCode(String str, int[] t) {
        int result = 0;
        char[] chars = str.toCharArray();

        for(int i = 0; i < chars.length; i++) {
            char item = chars[i];

            result += (t[i % t.length] * item);
        }
        return result % G.length;
    }

    public int perfectHashCode(String key) {
        return (G[hashCode(key, s1)] + G[hashCode(key, s2)]) % G.length;
    }

    public static void main(String[] args) {
        Perfect_hash ph = new Perfect_hash();

//        System.out.println("`a` use `s1` hashCode: " + ph.hashCode("a", ph.s1));
//        System.out.println("`a` use `s2` hashCode: " + ph.hashCode("a", ph.s2));
//        System.out.println("`a` perfect hashCode: " + ph.perfectHashCode("a") + "\n");
//
//
//        System.out.println("`by` use `s1` hashCode: " + ph.hashCode("by", ph.s1));
//        System.out.println("`by` use `s2` hashCode: " + ph.hashCode("by", ph.s2));
//        System.out.println("`by` perfect hashCode: " + ph.perfectHashCode("by"));

        String testStr = "a rose by any other name would smell as sweet";
        for (String item : testStr.split(" ")) {
            System.out.println("`" + item + "` perfect hashCode: " + ph.perfectHashCode(item));
        }
    }
}
