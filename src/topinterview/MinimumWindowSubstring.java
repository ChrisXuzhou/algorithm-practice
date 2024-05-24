package topinterview;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }


        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int required = tMap.size();
        int counted = 0;
        int[] ans = {-1, 0, 0}; // length, start, end

        Map<Character, Integer> sMap = new HashMap<>();  // this is the window
        while (right < s.length()) {

            char c = s.charAt(right);
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);

            // means that having matched the char word
            if (tMap.containsKey(c) && tMap.get(c).equals(sMap.get(c))) {
                counted++;
            }

            // check if matched the requirement
            while (left <= right && counted == required) {
                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }

                // try to move left rightwards
                c = s.charAt(left);
                sMap.put(c, sMap.get(c) - 1);
                if (tMap.containsKey(c) && sMap.getOrDefault(c, 0) < tMap.get(c)) {
                    counted--;
                }
                left++;
            }

            right++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
