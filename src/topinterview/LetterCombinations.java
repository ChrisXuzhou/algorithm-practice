package topinterview;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {

    private static final String[] LETTERS = {"", "",
            "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};


    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;
        backtrack(digits, 0, result, new StringBuilder());
        return result;
    }

    private void backtrack(String digits, int index,
                           List<String> result, StringBuilder sb) {

        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }

        int digit = digits.charAt(index) - '0';
        char[] chars = LETTERS[digit].toCharArray();
        for (char c: chars) {
            sb.append(c);
            backtrack(digits, index + 1, result, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
