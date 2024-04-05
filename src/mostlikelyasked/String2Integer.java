package mostlikelyasked;

public class String2Integer {

    public int myAtoi(String s) {

        if (s == null) return 0;

        int i = 0;
        long res = 0;
        int length = s.length();

        // white space
        while (i < length && s.charAt(i) == ' ') {
            i++;
        }
        if (i == length) {
            return 0;
        }

        // sign
        int sign = 1;
        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }
        if (i == length) {
            return 0;
        }

        // iterate for the digits
        while (i < length && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            res = res * 10 + s.charAt(i) - '0';
            if (res > Integer.MAX_VALUE) {
                break;
            }
            i++;
        }

        if ((int) res != res) {
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        return (int) res * sign;
    }

}
