package mostlikelyasked;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        int t = new LongestSubstringWithoutRepeatingCharacters()
                .lengthOfLongestSubstring("abcabcbb");
        System.out.println(t);
    }

    public int lengthOfLongestSubstring(String s) {

        Set<Character> set = new HashSet<>();
        // "abcabcbb"
        char[] chars = s.toCharArray();
        int right = 0;
        int left = 0;
        int max = 0;

        while (right < chars.length) {
            char c = chars[right];
            if (set.add(c)) {
                max = Math.max(right - left + 1, max);
            } else {

                // find the left's location
                int i = right - 1;
                set = new HashSet<>();
                set.add(c);
                while (i > left && chars[i] != c) {
                    set.add(chars[i]);
                    i--;
                }
                left = i + 1;
            }

            right++;
        }
        return max;
    }
}
