package topinterview;

import java.util.Arrays;

public class PlusOne {

    public static void main(String[] args) {
        int[] ret = new PlusOne()
                .plusOne(new int[] {9});

        System.out.println(Arrays.toString(ret));
    }

    public int[] plusOne(int[] digits) {

        int carry = 1;
        int i = digits.length - 1;
        while (i >= 0 && carry > 0) {
            int ret = digits[i] + carry;
            carry = ret / 10;
            digits[i] = ret % 10;
            i--;
        }

        if (carry == 0) {
            return digits;
        }

        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = carry;
        System.arraycopy(digits, 0, newDigits, 1, digits.length);
        return newDigits;
    }

}
