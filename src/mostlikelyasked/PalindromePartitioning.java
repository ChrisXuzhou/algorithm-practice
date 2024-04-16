package mostlikelyasked;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public static void main(String[] args) {
        List<List<String>> ret = new PalindromePartitioning()
                .partition("aab");

        System.out.println(ret.size());
    }

    public List<List<String>> partition(String s) {

        List<List<String>> results = new ArrayList<>();
        backtrack(results, new ArrayList<>(), s, 0);
        return results;
    }

    private void backtrack(List<List<String>> results,
                           List<String> tempList,
                           String s, int start) {

        if (start == s.length()) {
            results.add(new ArrayList<>(tempList));
        }

        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                tempList.add(s.substring(start, i + 1));
                backtrack(results, tempList, s, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) return false;
        }
        return true;
    }
}
