package mostlikelyasked;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = new String[]{"flower", "flow", "flight"};
        System.out.println(
                new LongestCommonPrefix().longestCommonPrefix(strs)
        );
    }

    public String longestCommonPrefix(String[] strs) {

        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (true) {
            Character c = null;
            for (String str : strs) {
                if (i < str.length()) {
                    if (c == null) {
                        c = str.charAt(i);
                    } else if (!c.equals(str.charAt(i))) {
                        return sb.toString();
                    }
                } else {
                    return sb.toString();
                }
            }

            sb.append(c);
            i++;
        }
    }

}
