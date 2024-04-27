package mostlikelyasked;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnagramIndices {

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> ret = new ArrayList<>();
        if (s == null || p == null || p.length() == 0 || s.length() == 0) {
            return ret;
        }

        int[] target = new int[26];
        for (char c: p.toCharArray()) {
            target[c - 'a'] = target[c - 'a'] + 1;
        }

        int left = 0;
        int right = 0;
        int[] window = new int[26];

        while (right < s.length()){
            char curr = s.charAt(right);
            window[curr - 'a'] = window[curr - 'a'] + 1;
            right++;

            if (right - left == p.length()) {
                // means the window has reached the length equals array p.
                if (Arrays.equals(window, target)) {
                    ret.add(left);
                }
                char currLeft = s.charAt(left);
                window[currLeft - 'a'] --;
                left ++;
            }
        }

        return ret;
    }
}
