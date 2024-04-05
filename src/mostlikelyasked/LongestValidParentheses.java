package mostlikelyasked;

public class LongestValidParentheses {

    public static void main(String[] args) {
        int ret = new LongestValidParentheses()
                .longestValidParentheses("(()())");
        System.out.println(ret);
    }

    public int longestValidParentheses(String s) {
        int maxLength = 0;

        int[] dp = new int[s.length()];

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != ')') {
                continue;
            }

            if (s.charAt(i -1) == '(') {
                dp[i] = i > 2 ? dp[i - 2] + 2 : 2;
            } else if ( i - dp[i - 1] - 1 >= 0  && s.charAt(i - dp[i - 1] - 1) == '(') {
                // more
                dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 > 0 ? dp[i - dp[i - 1] - 2] : 0);
            }

            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }

}
