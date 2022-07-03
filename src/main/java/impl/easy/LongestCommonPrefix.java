package impl.easy;

public class LongestCommonPrefix {

    public static void main(String[] args) {

        LongestCommonPrefix p = new LongestCommonPrefix();

        System.out.println(p.longestCommonPrefix(new String[]{"","racecar","car"}));

        System.out.println(p.longestCommonPrefix(new String[]{"flower","flow","flight"}));

        System.out.println(p.longestCommonPrefix(new String[]{"dog","racecar","car"}));

        System.out.println(p.longestCommonPrefix(new String[]{"flower","flow","flowwwww"}));

        System.out.println(p.longestCommonPrefix(new String[]{"f","flow","flowwwww"}));

    }

    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();

        int s = 0, e = 1;
        String rootStr = strs[0];
        boolean keepCheck = true;
        while (true) {
            if(e > rootStr.length()) {
                break;
            }
            String oneWord = rootStr.substring(s, e);

            for(int i = 1; i < strs.length; i++) {
                String compareStr = strs[i];
                if(e > compareStr.length()) {
                    keepCheck = false;
                    break;
                }
                String compareStrWord = compareStr.substring(s, e);
                if(!compareStrWord.equals(oneWord)) {
                    keepCheck = false;
                    break;
                }
            }
            if(!keepCheck) {
                break;
            }
            result.append(oneWord);
            s++;
            e++;

        }

        return result.toString();
    }


}
