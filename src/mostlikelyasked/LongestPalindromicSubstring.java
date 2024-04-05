package mostlikelyasked;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {

        if (s == null || s.length() < 2) return s;

        // record the result
        int start = 0;
        int end = 0;

        int length = s.length();
        boolean[][] dp = new boolean[length][length]; // cache the reusable palindrome

        for (int i = 0; i < length; i++) {
            dp[i][i] = true;

            for (int j = 0; j < i; j++) {
                // check if dp[j][i] is a palindrome
                if (s.charAt(j) == s.charAt(i) && (i - j < 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    if (i - j > end - start) {
                        start = j;
                        end = i;
                    }
                }
            }
        }

        return s.substring(start, end + 1);
    }

}
