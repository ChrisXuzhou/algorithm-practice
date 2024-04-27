package topinterview;

public class StringToIntegerAtoI {

    public static void main(String[] args) {
        String s = " ";
        int ret =
                new StringToIntegerAtoI()
                        .myAtoi(s);

        System.out.println(ret);
    }

    public int myAtoi(String s) {

        if (s == null || s.length() == 0) return 0;

        long ans = 0;
        char[] chars = s.toCharArray();
        int i = 0;
        boolean positive = true;

        // remove starting empty spaces.
        while (i < chars.length && chars[i] == ' ') {
            i++;
        }

        if (i < chars.length && (chars[i] == '-' || chars[i] == '+')) {
            positive = chars[i] != '-';
            i++;
        }

        while (i < chars.length && chars[i] >= '0' && chars[i] <= '9') {
            long digit = chars[i] - '0';
            ans = ans * 10 + digit;

            if (positive && ans >= Integer.MAX_VALUE) {
                ans = Integer.MAX_VALUE;
                break;
            }

            if (!positive && -ans <= Integer.MIN_VALUE) {
                ans = Integer.MIN_VALUE;
                break;
            }
            i++;
        }

        return positive ? (int) ans : -(int) ans;
    }
}
