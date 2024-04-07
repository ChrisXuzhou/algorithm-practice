package mostlikelyasked;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        String ret = new MinimumWindowSubstring()
                .minWindow(
                        "ADOBECODEBANC",
                        "ABC"
                );

        System.out.println(ret);
    }

    public String minWindow(String s, String t) {

        if (s == null || t == null || s.length() < t.length()) return "";

        Map<Character, Integer> targetCount = new HashMap<>();
        for (char c: t.toCharArray()) {
            targetCount.put(c, targetCount.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        String minWindow = "";
        int requiredCount = targetCount.size();

        Map<Character, Integer> windowCount = new HashMap<>();
        while (right < s.length()) {

            char c = s.charAt(right);
            windowCount.put(c, windowCount.getOrDefault(c, 0) + 1);

            if (targetCount.containsKey(c) && targetCount.get(c).equals(windowCount.get(c))) {
                requiredCount --;
            }

            // find a window can contain all the chars in t
            while (requiredCount == 0) {

                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;

                    System.out.println(left + ":" + right);
                    minWindow = s.substring(left, right + 1);
                }

                char leftChar = s.charAt(left);
                windowCount.put(leftChar, windowCount.get(leftChar) - 1);
                if (targetCount.containsKey(leftChar) && windowCount.get(leftChar) < targetCount.get(leftChar)){
                    requiredCount ++;
                }
                left++;
            }

            right++;
        }

        return minWindow;
    }

}
