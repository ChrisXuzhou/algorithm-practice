package mostlikelyasked;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsFromPhoneNumber {

    public static void main(String[] args) {

    }


    private final String[] phone = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<>();
        if (digits == null || digits.equals("")) {
            return ret;
        }

        char[] chars = digits.toCharArray();
        backtrack(ret, chars, 0, "");
        return ret;
    }

    private void backtrack(List<String> ret, char[] digits, int i, String combined) {
        if (i == digits.length) {
            ret.add(combined);
            return;
        }

        char[] letters = phone[digits[i] - '0'].toCharArray();
        for (char letter: letters) {
            backtrack(ret, digits, i+1, combined + letter);
        }
    }
}
