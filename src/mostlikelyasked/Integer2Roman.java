package mostlikelyasked;

public class Integer2Roman {

    /*
    Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
     */

    public String intToRoman(int num) {

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            int val = values[i];
            while (num >= val) {
                num -= val;
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }

}
