package mostlikelyasked;

import java.util.*;

class CharNode {
    char val;
    boolean isEnd;
    Map<Character, CharNode> children;

    public CharNode(char val) {
        this.val = val;
        this.isEnd = false;
        children = new HashMap<>();
    }
}


public class WordBreak {

    public static void main(String[] args) {
        boolean ret = new WordBreak()
                .wordBreak("abcd", new ArrayList<>(Arrays.asList("a", "abc", "b", "cd")));

        System.out.println(ret);
    }


    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            // check if dp[i] can be break
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

}
